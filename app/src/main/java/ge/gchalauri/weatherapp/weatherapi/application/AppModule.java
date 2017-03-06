package ge.gchalauri.weatherapp.weatherapi.application;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ge.gchalauri.weatherapp.weatherapi.base.clients.Preferences;
import ge.gchalauri.weatherapp.weatherapi.base.clients.PreferencesImpl;
import ge.gchalauri.weatherapp.weatherapi.domain.dataProviders.EndpointApi;
import ge.gchalauri.weatherapp.weatherapi.domain.repositories.Repository;
import ge.gchalauri.weatherapp.weatherapi.domain.repositories.RepositoryImpl;

/**
 * Created by giodz on 3/6/2017.
 */

@Module
public class AppModule {
    private Application mApp;

    public AppModule(Application app) {
        this.mApp = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApp;
    }

    @Provides
    @Singleton
    SharedPreferences providePreferenceManager(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Preferences providePreferences(SharedPreferences sharedPreferences) {
        return new PreferencesImpl(sharedPreferences);
    }

    @Provides
    @Singleton
    Repository provideRepository(EndpointApi endpointApi, Preferences preferences) {
        return new RepositoryImpl(endpointApi, preferences);
    }


}
