package ge.gchalauri.weatherapp.weatherapi.networking;

import ge.gchalauri.weatherapp.weatherapi.entities.ApixuResponse;
import ge.gchalauri.weatherapp.weatherapi.utils.Consts;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by G.Chalauri on 03/07/17.
 */

public interface ApixuService {

    @GET("current.json")
    Call<ApixuResponse> getWeather(@Query("q") String city,@Query("key") String key);

}
