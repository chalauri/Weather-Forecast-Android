package ge.gchalauri.weatherapp.weatherapi.domain.usecases.base;

import rx.Observable;

/**
 * Created by giodz on 3/6/2017.
 */
public interface IUseCase<Result, Argument> {
    Observable<Result> createObservable(Argument... args);
}
