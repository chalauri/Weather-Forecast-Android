package ge.gchalauri.weatherapp.weatherapi.domain.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by giodz on 3/6/2017.
 */
public final class LocationModel {
    @SerializedName("name")
    public final String name;
    @SerializedName("region")
    public final String region;
    @SerializedName("country")
    public final String country;
    @SerializedName("lat")
    public final double lat;
    @SerializedName("lon")
    public final double lon;
    @SerializedName("tz_id")
    public final String tzId;
    @SerializedName("localtime_epoch")
    public final long localtimeEpoch;
    @SerializedName("localtime")
    public final String localtime;

    public LocationModel(String name,
                         String region,
                         String country,
                         double lat,
                         double lon,
                         String tzId,
                         long localtimeEpoch,
                         String localtime) {
        this.name = name;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
        this.tzId = tzId;
        this.localtimeEpoch = localtimeEpoch;
        this.localtime = localtime;
    }
}
