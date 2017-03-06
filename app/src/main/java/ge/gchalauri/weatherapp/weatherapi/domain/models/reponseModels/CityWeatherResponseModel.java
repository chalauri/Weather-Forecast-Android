package ge.gchalauri.weatherapp.weatherapi.domain.models.reponseModels;

import com.google.gson.annotations.SerializedName;

import ge.gchalauri.weatherapp.weatherapi.domain.models.LocationModel;
import ge.gchalauri.weatherapp.weatherapi.domain.models.WeatherModel;

/**
 * Created by giodz on 3/6/2017.
 */

public final class CityWeatherResponseModel {
    @SerializedName("location")
    public final LocationModel location;
    @SerializedName("current")
    public final WeatherModel weather;

    public CityWeatherResponseModel(LocationModel location, WeatherModel weather) {
        this.location = location;
        this.weather = weather;
    }
}
