package ge.gchalauri.weatherapp.weatherapi.domain.dataProviders;

import ge.gchalauri.weatherapp.weatherapi.domain.models.reponseModels.CityWeatherResponseModel;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by giodz on 3/6/2017.
 */

public interface EndpointApi {

    @GET("current.json")
    Observable<CityWeatherResponseModel> getWeatherByCity(@Query(ParamKeys.KEY_CITY)
                                                                  String city);

}
