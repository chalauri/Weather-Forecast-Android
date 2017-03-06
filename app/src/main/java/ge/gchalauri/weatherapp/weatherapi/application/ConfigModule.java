package ge.gchalauri.weatherapp.weatherapi.application;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by giodz on 3/6/2017.
 */

@Module
public class ConfigModule {

    private String mBaseUrl;
    private String mApiKey;

    public ConfigModule(String baseUrl, String apiKey) {
        this.mBaseUrl = baseUrl;
        this.mApiKey = apiKey;
    }

    @Provides
    @Singleton
    @Named("BaseUrl")
    String provideBaseUrl() {
        return mBaseUrl;
    }

    @Provides
    @Singleton
    @Named("ApiKey")
    String provideApiKey() {
        return mApiKey;
    }
}
