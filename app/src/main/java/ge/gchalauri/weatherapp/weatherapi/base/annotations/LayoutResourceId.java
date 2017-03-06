package ge.gchalauri.weatherapp.weatherapi.base.annotations;

import android.support.annotation.LayoutRes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zuluft on 10/28/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LayoutResourceId {
    @LayoutRes
    int value();
}
