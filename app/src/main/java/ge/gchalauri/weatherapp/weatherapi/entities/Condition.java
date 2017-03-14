package ge.gchalauri.weatherapp.weatherapi.entities;

import java.io.Serializable;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by G.Chalauri on 3/13/2017.
 */

@RealmClass
public class Condition implements Serializable, RealmModel{

    private static final long serialVersionUID = 1L;

    private String text;
    private String icon;
    private Integer code;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
