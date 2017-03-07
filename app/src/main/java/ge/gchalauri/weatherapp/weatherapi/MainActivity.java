package ge.gchalauri.weatherapp.weatherapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

import ge.gchalauri.weatherapp.weatherapi.entities.ApixuResponse;
import ge.gchalauri.weatherapp.weatherapi.networking.ApixuService;
import ge.gchalauri.weatherapp.weatherapi.utils.Consts;
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

        Call<ApixuResponse> callService = service.getWeather(Consts.DEFAULT_CITY, Consts.API_KEY);

        System.out.println("URL " + callService.request().url());
        callService.enqueue(new Callback<ApixuResponse>() {
            @Override
            public void onResponse(Call<ApixuResponse> call, Response<ApixuResponse> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<ApixuResponse> call, Throwable t) {
                System.out.println("ERR" + t.getMessage());
            }
        });
    }
}
