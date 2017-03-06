package ge.gchalauri.weatherapp.weatherapi.domain.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by giodz on 3/6/2017.
 */

public final class WeatherConditionModel {
    @SerializedName("text")
    public final String text;
    @SerializedName("icon")
    public final String icon;
    @SerializedName("code")
    public final long code;

    public WeatherConditionModel(String text,
                                 String icon,
                                 long code) {
        this.text = text;
        this.icon = icon;
        this.code = code;
    }
}
