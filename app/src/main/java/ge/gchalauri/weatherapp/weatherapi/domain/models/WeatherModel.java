package ge.gchalauri.weatherapp.weatherapi.domain.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by giodz on 3/6/2017.
 */

public final class WeatherModel {
    @SerializedName("last_updated_epoch")
    public final long lastUpdatedEpoch;
    @SerializedName("last_updated")
    public final String lastUpdated;
    @SerializedName("temp_c")
    public final double tempC;
    @SerializedName("temp_f")
    public final double tempF;
    @SerializedName("is_day")
    public final int isDay;
    @SerializedName("condition")
    public final WeatherConditionModel condition;
    @SerializedName("wind_mph")
    public final double windMph;
    @SerializedName("wind_kph")
    public final double windKph;
    @SerializedName("wind_degree")
    public final double windDegree;
    @SerializedName("wind_dir")
    public final String windDir;
    @SerializedName("pressure_mb")
    public final double pressureMb;
    @SerializedName("pressure_in")
    public final double pressureIn;
    @SerializedName("precip_mm")
    public final double precipMm;
    @SerializedName("precip_in")
    public final double precipIn;
    @SerializedName("humidity")
    public final double humidity;
    @SerializedName("cloud")
    public final double cloud;

    public WeatherModel(long lastUpdatedEpoch,
                        String lastUpdated,
                        double tempC,
                        double tempF,
                        int isDay,
                        WeatherConditionModel condition,
                        double windMph,
                        double windKph,
                        double windDegree,
                        String windDir,
                        double pressureMb,
                        double pressureIn,
                        double precipMm,
                        double precipIn,
                        double humidity,
                        double cloud) {
        this.lastUpdatedEpoch = lastUpdatedEpoch;
        this.lastUpdated = lastUpdated;
        this.tempC = tempC;
        this.tempF = tempF;
        this.isDay = isDay;
        this.condition = condition;
        this.windMph = windMph;
        this.windKph = windKph;
        this.windDegree = windDegree;
        this.windDir = windDir;
        this.pressureMb = pressureMb;
        this.pressureIn = pressureIn;
        this.precipMm = precipMm;
        this.precipIn = precipIn;
        this.humidity = humidity;
        this.cloud = cloud;
    }
}
