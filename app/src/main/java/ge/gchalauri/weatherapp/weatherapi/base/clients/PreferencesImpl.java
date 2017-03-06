package ge.gchalauri.weatherapp.weatherapi.base.clients;

import android.content.SharedPreferences;

import com.f2prateek.rx.preferences.RxSharedPreferences;

import rx.Observable;

/**
 * Created by giodz on 3/1/2017.
 */

public class PreferencesImpl implements Preferences {

    private SharedPreferences mSharedPreferences;
    private RxSharedPreferences mRxSharedPreferences;
    private SharedPreferences.Editor mEditor;


    public PreferencesImpl(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
        mRxSharedPreferences = RxSharedPreferences.create(sharedPreferences);
        mEditor = mSharedPreferences.edit();
    }

    @Override
    public Preferences add(String key, int value) {
        mEditor.putInt(key, value);
        return this;
    }

    @Override
    public Preferences add(String key, String value) {
        mEditor.putString(key, value);
        return this;
    }

    @Override
    public Preferences add(String key, boolean value) {
        mEditor.putBoolean(key, value);
        return this;
    }

    @Override
    public Preferences add(String key, float value) {
        mEditor.putFloat(key, value);
        return this;
    }

    @Override
    public Preferences remove(String key) {
        mEditor.remove(key);
        return this;
    }

    @Override
    public Observable<Integer> getObservable(String key, int defaultValue) {
        return mRxSharedPreferences.getInteger(key, defaultValue).asObservable();
    }

    @Override
    public Observable<String> getObservable(String key, String defaultValue) {
        return mRxSharedPreferences.getString(key, defaultValue).asObservable();
    }

    @Override
    public Observable<Boolean> getObservable(String key, boolean defaultValue) {
        return mRxSharedPreferences.getBoolean(key, defaultValue).asObservable();
    }

    @Override
    public Observable<Float> getObservable(String key, float defaultValue) {
        return mRxSharedPreferences.getFloat(key, defaultValue).asObservable();
    }

    @Override
    public int get(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    @Override
    public String get(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    @Override
    public boolean get(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    @Override
    public float get(String key, float defaultValue) {
        return mSharedPreferences.getFloat(key, defaultValue);
    }

    @Override
    public void commit() {
        mEditor.commit();
    }

    @Override
    public void commitAsync() {
        mEditor.apply();
    }

    @Override
    public void clearAllData() {
        mEditor.clear().commit();
    }
}
