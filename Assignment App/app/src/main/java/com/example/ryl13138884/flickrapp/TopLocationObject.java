package com.example.ryl13138884.flickrapp;



import java.io.Serializable;

public class TopLocationObject implements Serializable{

    private String CityName;
    private String CountryName;
    private Integer FlagResource;

    private String mapPictureURL;
    private String woeid;



    public String getCityName() {
        return CityName;
    }

    public String getCountryName() {
        return CountryName;
    }

    public Integer getFlagResource() {
        return FlagResource;
    }

    public String getMapPictureURL() {
        return mapPictureURL;
    }

    public String getwoeid(){
        return woeid;
    }

    public TopLocationObject(String cityName, String countryName, Integer flagResource, String mapPictureURL, String woeid) {
        this.CityName = cityName;
        this.CountryName = countryName;
        this.FlagResource = flagResource;
        this.mapPictureURL = mapPictureURL;
        this.woeid = woeid;
    }
}
