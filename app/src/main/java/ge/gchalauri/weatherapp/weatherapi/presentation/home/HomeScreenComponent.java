package ge.gchalauri.weatherapp.weatherapi.presentation.home;

import dagger.Component;
import ge.gchalauri.weatherapp.weatherapi.application.AppComponent;
import ge.gchalauri.weatherapp.weatherapi.base.di.base.BasePresentationComponent;
import ge.gchalauri.weatherapp.weatherapi.base.di.scopes.PerActivity;

/**
 * Created by giodz on 3/6/2017.
 */

@PerActivity
@Component(dependencies = AppComponent.class)
public interface HomeScreenComponent extends BasePresentationComponent<HomeScreenActivity> {
}
