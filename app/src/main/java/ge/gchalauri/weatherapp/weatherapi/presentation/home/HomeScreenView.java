package ge.gchalauri.weatherapp.weatherapi.presentation.home;

import ge.gchalauri.weatherapp.weatherapi.base.views.IView;

/**
 * Created by giodz on 3/6/2017.
 */

public interface HomeScreenView extends IView {
    void showLoader();

    void hideLoader();

}
