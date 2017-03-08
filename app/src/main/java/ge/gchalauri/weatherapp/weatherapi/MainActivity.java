package ge.gchalauri.weatherapp.weatherapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

import ge.gchalauri.weatherapp.weatherapi.entities.ApixuLocation;
import ge.gchalauri.weatherapp.weatherapi.entities.ApixuResponse;
import ge.gchalauri.weatherapp.weatherapi.entities.Current;
import ge.gchalauri.weatherapp.weatherapi.networking.ApixuService;
import ge.gchalauri.weatherapp.weatherapi.utils.Consts;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void search(View view) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Consts.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApixuService service = retrofit.create(ApixuService.class);
        System.out.println("BASE " + Consts.URL);
        Call<ApixuResponse> callService = service.getWeather(Consts.DEFAULT_CITY, Consts.API_KEY);

        System.out.println("URL " + callService.request().url());
        callService.enqueue(new Callback<ApixuResponse>() {
            @Override
            public void onResponse(Call<ApixuResponse> call, Response<ApixuResponse> response) {
                System.out.println(response.body());
                ApixuResponse ar = response.body();
                System.out.println(ar.getLocation().getLat());

                save(ar);

            }

            @Override
            public void onFailure(Call<ApixuResponse> call, Throwable t) {
                System.out.println("ERR" + t.getMessage());
            }
        });
    }

    public void save(ApixuResponse response) {
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
    }

    public void find(View view) throws IOException {
        //TODO test realm retrieve data
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        final RealmResults<ApixuResponse> puppies = realm.where(ApixuResponse.class).findAll();
        System.out.println("SIZE  " + puppies.size());
    }
}
