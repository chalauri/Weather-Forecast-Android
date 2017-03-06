package ge.gchalauri.weatherapp.weatherapi.base.api;


import ge.gchalauri.weatherapp.weatherapi.base.presenters.IPresenter;

/**
 * Created by zuluft on 11/27/16.
 */
public interface HasPresenter<Presenter extends IPresenter> {
    void injectPresenter(Presenter presenter);
}
