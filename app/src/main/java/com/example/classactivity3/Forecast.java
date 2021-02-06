package com.example.classactivity3;

public class Forecast {
    private String date;
    private String time;
    private String description;
    private String feelsLikeTemp;

    public Forecast(String date, String time, String description, String feelsLikeTemp){
        this.date = date;
        this.time = time;
        this.description = description;
        this.feelsLikeTemp = feelsLikeTemp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeelsLikeTemp() {
        return feelsLikeTemp;
    }

    public void setFeelsLikeTemp(String feelsLikeTemp) {
        this.feelsLikeTemp = feelsLikeTemp;
    }
}
