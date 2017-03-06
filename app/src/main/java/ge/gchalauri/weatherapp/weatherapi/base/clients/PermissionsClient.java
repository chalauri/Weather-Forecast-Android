package ge.gchalauri.weatherapp.weatherapi.base.clients;

import android.Manifest;

import rx.Observable;

/**
 * Created by giodz on 3/1/2017.
 */

public interface PermissionsClient {
    String READ_CONTACTS_PERMISSION = Manifest.permission.READ_CONTACTS;

    Observable<Boolean> requestPermissions(String... args);

    Observable<Boolean> PermissionRequestWasDisabled(String... args);
}
