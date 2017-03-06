package ge.gchalauri.weatherapp.weatherapi.application;

import android.app.Application;

import javax.inject.Singleton;

import ge.gchalauri.weatherapp.weatherapi.R;
import ge.gchalauri.weatherapp.weatherapi.base.di.api.HasComponent;

/**
 * Created by giodz on 3/6/2017.
 */

@Singleton
public class App
        extends
        Application
        implements
        HasComponent<AppComponent> {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = provideComponent();
    }

    @Override
    public AppComponent provideComponent() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .configModule(
                        new ConfigModule(getString(R.string.base_url),
                                getString(R.string.weather_api_key)))
                .networkingModule(new NetworkingModule()).build();
    }

    @Override
    public AppComponent getComponent() {
        return mAppComponent;
    }
}
