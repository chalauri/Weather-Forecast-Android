package ge.gchalauri.weatherapp.weatherapi.base.clients;

import rx.Observable;

/**
 * Created by giodz on 3/1/2017.
 */

public interface Preferences {
    Preferences add(String key, int value);

    Preferences add(String key, String value);

    Preferences add(String key, boolean value);

    Preferences add(String key, float value);

    Preferences remove(String key);

    Observable<Integer> getObservable(String key, int defaultValue);

    Observable<String> getObservable(String key, String defaultValue);

    Observable<Boolean> getObservable(String key, boolean defaultValue);

    Observable<Float> getObservable(String key, float defaultValue);

    int get(String key, int defaultValue);

    String get(String key, String defaultValue);

    boolean get(String key, boolean defaultValue);

    float get(String key, float defaultValue);

    void commit();

    void commitAsync();

    void clearAllData();
}
