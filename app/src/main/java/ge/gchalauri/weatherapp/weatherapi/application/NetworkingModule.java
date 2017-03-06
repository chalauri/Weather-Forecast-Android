package ge.gchalauri.weatherapp.weatherapi.application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ge.gchalauri.weatherapp.weatherapi.domain.dataProviders.EndpointApi;
import ge.gchalauri.weatherapp.weatherapi.domain.dataProviders.ParamKeys;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by giodz on 3/6/2017.
 */

@Module
public class NetworkingModule {

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    @Named("ApiKeyInterceptor")
    Interceptor provideApiKeyInterceptor(@Named("ApiKey") final String apiKey) {
        return chain -> {
            Request request = chain.request();
            HttpUrl url = request.url();
            url = url.newBuilder().addQueryParameter(ParamKeys.KEY_API, apiKey).build();
            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        };
    }


    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(@Named("ApiKeyInterceptor") Interceptor apiInterceptor) {
        return new OkHttpClient.Builder().addInterceptor(apiInterceptor).build();
    }

    @Provides
    @Singleton
    CallAdapter.Factory providerCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@Named("BaseUrl") String baseUrl,
                             OkHttpClient okHttpClient,
                             Converter.Factory converterFactory,
                             CallAdapter.Factory callAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build();
    }

    @Provides
    @Singleton
    EndpointApi provideEndpointApi(Retrofit retrofit) {
        return retrofit.create(EndpointApi.class);
    }


}
