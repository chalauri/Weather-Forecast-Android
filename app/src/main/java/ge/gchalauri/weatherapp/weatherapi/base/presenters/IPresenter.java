package ge.gchalauri.weatherapp.weatherapi.base.presenters;


import ge.gchalauri.weatherapp.weatherapi.base.views.IView;

/**
 * Created by zuluft on 10/25/16.
 */

public interface IPresenter<View extends IView> {
    void attach(View view);

    void detachView();
}
