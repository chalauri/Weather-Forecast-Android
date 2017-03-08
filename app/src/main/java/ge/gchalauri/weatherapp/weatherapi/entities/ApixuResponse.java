package ge.gchalauri.weatherapp.weatherapi.entities;

import java.io.Serializable;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by G.Chalauri on 03/06/17.
 */

@RealmClass
public class ApixuResponse  implements Serializable, RealmModel {

    private static final long serialVersionUID = 1L;

    private ApixuLocation location;

    private  Current current;

    public ApixuLocation getLocation() {
        return location;
    }

    public void setLocation(ApixuLocation location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}
