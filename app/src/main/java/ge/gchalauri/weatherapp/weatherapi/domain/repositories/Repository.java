package ge.gchalauri.weatherapp.weatherapi.domain.repositories;

import ge.gchalauri.weatherapp.weatherapi.domain.models.reponseModels.CityWeatherResponseModel;
import rx.Observable;

/**
 * Created by giodz on 3/6/2017.
 */

public interface Repository {
    Observable<CityWeatherResponseModel> getWeatherByCity(String city);
}
