package ge.gchalauri.weatherapp.weatherapi.application;

import javax.inject.Singleton;

import dagger.Component;
import ge.gchalauri.weatherapp.weatherapi.base.clients.Preferences;
import ge.gchalauri.weatherapp.weatherapi.base.di.base.BaseComponent;
import ge.gchalauri.weatherapp.weatherapi.domain.dataProviders.EndpointApi;
import ge.gchalauri.weatherapp.weatherapi.domain.repositories.Repository;

/**
 * Created by giodz on 3/6/2017.
 */

@Singleton
@Component(modules = {ConfigModule.class, AppModule.class, NetworkingModule.class})
public interface AppComponent extends BaseComponent {
    Repository repository();

    Preferences preferences();
}
