package ge.gchalauri.weatherapp.weatherapi.base.clients;

import android.app.Activity;

import com.tbruyelle.rxpermissions.RxPermissions;

import java.lang.ref.WeakReference;

import rx.Observable;

/**
 * Created by giodz on 3/1/2017.
 */

public class PermissionsClientImpl implements PermissionsClient {

    private final RxPermissions mRxPermissions;
    private WeakReference<Activity> mActivityWeakReference;

    public PermissionsClientImpl(Activity activity) {
        mRxPermissions = new RxPermissions(activity);
        mActivityWeakReference = new WeakReference<>(activity);
    }

    @Override
    public Observable<Boolean> requestPermissions(String... args) {
        return mRxPermissions.request(args);
    }

    @Override
    public Observable<Boolean> PermissionRequestWasDisabled(String... args) {
        return mRxPermissions
                .shouldShowRequestPermissionRationale(mActivityWeakReference.get(), args);
    }
}
