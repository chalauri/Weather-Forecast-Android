package ge.gchalauri.weatherapp.weatherapi.entities;

import java.io.Serializable;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by G.Chalauri on 03/06/17.
 */

@RealmClass
public class Current implements Serializable, RealmModel {

    private static final long serialVersionUID = 1L;

    //Local time when the real time data was updated.
    private Double last_updated_epoch;

    //Local time when the real time data was updated in unix time.
    private String last_updated;

    //Temperature in celsius
    private Double temp_c;

    //Temperature in fahrenheit
    private Double temp_f;

    //	1 = Yes 0 = No
    // Whether to show day condition icon or night icon
    private Integer is_day;

    private Condition condition;

    //	Wind speed in miles per hour
    private Double wind_mph;

    //Wind speed in kilometer per hour
    private Double wind_kph;

    //Wind direction in degrees
    private Integer wind_degree;

    //Wind direction as 16 point compass. e.g.: NSW
    private String wind_dir;

    //Pressure in millibars
    private Integer pressure_mb;

    //Pressure in inches
    private Double pressure_in;

    //Precipitation amount in millimeters
    private Double precip_mm;

    //Precipitation amount in inches
    private Double precip_in;

    //Humidity as percentage
    private Integer humidity;

    //Cloud cover as percentage
    private Integer cloud;

    public Double getLast_updated_epoch() {
        return last_updated_epoch;
    }

    public void setLast_updated_epoch(Double last_updated_epoch) {
        this.last_updated_epoch = last_updated_epoch;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public Double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(Double temp_c) {
        this.temp_c = temp_c;
    }

    public Double getTemp_f() {
        return temp_f;
    }

    public void setTemp_f(Double temp_f) {
        this.temp_f = temp_f;
    }

    public Integer getIs_day() {
        return is_day;
    }

    public void setIs_day(Integer is_day) {
        this.is_day = is_day;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Double getWind_mph() {
        return wind_mph;
    }

    public void setWind_mph(Double wind_mph) {
        this.wind_mph = wind_mph;
    }

    public Double getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(Double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public Integer getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(Integer wind_degree) {
        this.wind_degree = wind_degree;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public Integer getPressure_mb() {
        return pressure_mb;
    }

    public void setPressure_mb(Integer pressure_mb) {
        this.pressure_mb = pressure_mb;
    }

    public Double getPressure_in() {
        return pressure_in;
    }

    public void setPressure_in(Double pressure_in) {
        this.pressure_in = pressure_in;
    }

    public Double getPrecip_mm() {
        return precip_mm;
    }

    public void setPrecip_mm(Double precip_mm) {
        this.precip_mm = precip_mm;
    }

    public Double getPrecip_in() {
        return precip_in;
    }

    public void setPrecip_in(Double precip_in) {
        this.precip_in = precip_in;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getCloud() {
        return cloud;
    }

    public void setCloud(Integer cloud) {
        this.cloud = cloud;
    }
}
