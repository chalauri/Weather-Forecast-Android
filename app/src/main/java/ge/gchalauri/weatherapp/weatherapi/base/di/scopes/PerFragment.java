package ge.gchalauri.weatherapp.weatherapi.base.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by giodz on 12/16/2016.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
