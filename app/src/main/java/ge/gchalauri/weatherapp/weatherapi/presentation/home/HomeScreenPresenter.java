package ge.gchalauri.weatherapp.weatherapi.presentation.home;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import ge.gchalauri.weatherapp.weatherapi.base.presenters.BasePresenter;
import ge.gchalauri.weatherapp.weatherapi.domain.models.reponseModels.CityWeatherResponseModel;
import ge.gchalauri.weatherapp.weatherapi.domain.usecases.GetWeatherByCityUseCase;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by giodz on 3/6/2017.
 */

public class HomeScreenPresenter extends BasePresenter<HomeScreenView> {

    private GetWeatherByCityUseCase mGetWeatherByCityUseCase;

    @Inject
    public HomeScreenPresenter(GetWeatherByCityUseCase getWeatherByCityUseCase) {
        this.mGetWeatherByCityUseCase = getWeatherByCityUseCase;
    }

    @Override
    protected void onFirstAttach() {
        super.onFirstAttach();
        mView.showLoader();
        registerSubscription(
                mGetWeatherByCityUseCase.createObservable("Paris")
                        .doOnTerminate(mView::hideLoader)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe(this::onResponseReceived,
                                this::onError,
                                this::onCompleted)
        );
    }

    private void onCompleted() {

    }

    private void onError(Throwable e) {
        Logger.d(e);
    }

    private void onResponseReceived(CityWeatherResponseModel cityWeatherResponseModel) {
        Logger.d(cityWeatherResponseModel);
    }
}
