package ge.gchalauri.weatherapp.weatherapi.base.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by zuluft on 11/27/16.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerView {
}
