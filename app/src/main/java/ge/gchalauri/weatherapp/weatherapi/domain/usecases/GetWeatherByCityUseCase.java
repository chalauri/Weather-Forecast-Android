package ge.gchalauri.weatherapp.weatherapi.domain.usecases;

import javax.inject.Inject;

import ge.gchalauri.weatherapp.weatherapi.domain.models.reponseModels.CityWeatherResponseModel;
import ge.gchalauri.weatherapp.weatherapi.domain.repositories.Repository;
import ge.gchalauri.weatherapp.weatherapi.domain.usecases.base.UseCaseWithRepository;
import rx.Observable;

/**
 * Created by giodz on 3/6/2017.
 */

public final class GetWeatherByCityUseCase
        extends
        UseCaseWithRepository<CityWeatherResponseModel, String> {

    @Inject
    public GetWeatherByCityUseCase(Repository repository) {
        super(repository);
    }

    @Override
    public final Observable<CityWeatherResponseModel> createObservable(String... args) {
        String city = args[0];
        return mRepository.getWeatherByCity(city);
    }
}
