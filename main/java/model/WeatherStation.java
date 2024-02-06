package Wetterstation;

import java.util.ArrayList;

public class WeatherStation {

    String id;
    String name;
    String date;
    String fileName;
    double averageTemp;
    double minTemp;
    double maxTemp;
    ArrayList<Temperature> temperatures = new ArrayList<>();

    public WeatherStation(String stationName) {
        this.name = stationName;
    }

    public WeatherStation() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAverageTemp() {
        return averageTemp;
    }

    public void setAverageTemp(double averageTemp) {
        this.averageTemp = averageTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public ArrayList<Temperature> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(ArrayList<Temperature> temperatures) {
        this.temperatures = temperatures;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void addTemperature(Temperature temperature) {
        temperatures.add(temperature);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
