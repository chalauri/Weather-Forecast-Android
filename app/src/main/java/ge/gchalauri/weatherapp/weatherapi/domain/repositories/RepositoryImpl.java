package ge.gchalauri.weatherapp.weatherapi.domain.repositories;

import ge.gchalauri.weatherapp.weatherapi.base.clients.Preferences;
import ge.gchalauri.weatherapp.weatherapi.domain.dataProviders.EndpointApi;
import ge.gchalauri.weatherapp.weatherapi.domain.models.reponseModels.CityWeatherResponseModel;
import rx.Observable;

/**
 * Created by giodz on 3/6/2017.
 */

public class RepositoryImpl implements Repository {
    private EndpointApi mEndpointApi;
    private Preferences mPreferences;

    public RepositoryImpl(EndpointApi endpointApi, Preferences preferences) {
        this.mEndpointApi = endpointApi;
        this.mPreferences = preferences;
    }

    @Override
    public Observable<CityWeatherResponseModel> getWeatherByCity(String city) {
        return mEndpointApi.getWeatherByCity(city);
    }
}
