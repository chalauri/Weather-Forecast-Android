package ge.gchalauri.weatherapp.weatherapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import ge.gchalauri.weatherapp.weatherapi.entities.ApixuLocation;
import ge.gchalauri.weatherapp.weatherapi.entities.ApixuResponse;
import ge.gchalauri.weatherapp.weatherapi.entities.Current;
import ge.gchalauri.weatherapp.weatherapi.networking.ApixuService;
import ge.gchalauri.weatherapp.weatherapi.utils.Consts;
import io.realm.Realm;
import io.realm.RealmResults;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText citySearch;
    ImageView icon;
    TextView temperature, cityData, note;

    ApixuService service;

    LinearLayout dataLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Consts.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApixuService.class);

        citySearch = (EditText) findViewById(R.id.city);
        icon = (ImageView) findViewById(R.id.icon_data);
        temperature = (TextView) findViewById(R.id.temperature);
        cityData = (TextView) findViewById(R.id.city_data);
        note = (TextView) findViewById(R.id.note);

        dataLayout = (LinearLayout)findViewById(R.id.data_layout);
    }

    public void search(View view) throws IOException {

        String city = citySearch.getText().toString();

        if (city == null || city.trim().equals("")) {
            city = Consts.DEFAULT_CITY;
        }

        Call<ApixuResponse> callService = service.getWeather(city, Consts.API_KEY);

        System.out.println("URL " + callService.request().url());
        callService.enqueue(new Callback<ApixuResponse>() {
            @Override
            public void onResponse(Call<ApixuResponse> call, Response<ApixuResponse> response) {
                System.out.println(response.body());
                ApixuResponse ar = response.body();

                System.out.println(ar.getCurrent().getCondition().getIcon());
                loadData(ar);
            }

            @Override
            public void onFailure(Call<ApixuResponse> call, Throwable t) {
                System.out.println("ERR" + t.getMessage());
                Toast.makeText(MainActivity.this, "ERROR DURING LOADING DATA", Toast.LENGTH_SHORT).show();
            }
        });
    }

  /*  public void save(ApixuResponse response) {
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        ApixuLocation location = response.getLocation();
        Current current = response.getCurrent();

        realm.beginTransaction();
        final ApixuLocation managedLocation = realm.createObject(ApixuLocation.class); // Persist unmanaged objects
        managedLocation.setCountry("GEORGIA");
        final Current managedCurrent = realm.createObject(Current.class);
        managedCurrent.setIs_day(1);

        ApixuResponse saveResponse = realm.createObject(ApixuResponse.class); // Create managed objects directly
        saveResponse.setCurrent(managedCurrent);
        saveResponse.setLocation(managedLocation);
        realm.commitTransaction();

        System.out.println(realm.getPath());
    }*/

  /*  public void find(View view) throws IOException {
        //TODO test realm retrieve data
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        final RealmResults<ApixuResponse> puppies = realm.where(ApixuResponse.class).findAll();
        System.out.println("SIZE  " + puppies.size());
    }*/

    private void loadImage(String url) {
        Call<ResponseBody> call = service.fetchCaptcha(url);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        // display the image data in a ImageView or save it
                        Bitmap bitmap = BitmapFactory.decodeStream(response.body().byteStream());
                        icon.setImageBitmap(bitmap);
                    } else {
                        icon.setImageBitmap(null);
                    }
                } else {
                    icon.setImageBitmap(null);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                icon.setImageBitmap(null);
                Toast.makeText(MainActivity.this, "ERROR DURING LOADING ICON", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadData(ApixuResponse response){
        cityData.setText(response.getLocation().getName().toUpperCase());
        temperature.setText(response.getCurrent().getTemp_c()+ " ℃");
        note.setText(response.getCurrent().getCondition().getText());

        dataLayout.setVisibility(View.VISIBLE);

        String iconUrl = response.getCurrent().getCondition().getIcon();
        loadImage(iconUrl);
    }
}
