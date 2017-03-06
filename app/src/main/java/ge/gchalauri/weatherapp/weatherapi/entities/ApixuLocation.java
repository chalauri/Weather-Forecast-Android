package ge.gchalauri.weatherapp.weatherapi.entities;

import java.io.Serializable;

/**
 * Created by G.Chalauri on 03/06/17.
 */

public class ApixuLocation implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private String region;
    private String country;
    private Double lat;
    private Double lon;
    private String ts_id ;
    private Double localtime_epoch;
    private String localtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getTs_id() {
        return ts_id;
    }

    public void setTs_id(String ts_id) {
        this.ts_id = ts_id;
    }

    public Double getLocaltime_epoch() {
        return localtime_epoch;
    }

    public void setLocaltime_epoch(Double localtime_epoch) {
        this.localtime_epoch = localtime_epoch;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }
}
