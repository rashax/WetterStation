package Wetterstation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WeatherStationModel {

    String path;
    ArrayList<WeatherStation> weatherStations = new ArrayList<>();
    ArrayList<String> files = new ArrayList<>();

    public WeatherStationModel() {

//        try {
//            readDataFromDataBank();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
    }

    private void readDataFromDataBank() throws SQLException {

        Connection connection = new DatabaseConnection().getConnection();
        if (connection == null) {
            System.out.println("WeatherStationModel: connection is null");
            return;
        }
        System.out.println("WeatherStationModel: connection is not null");

        String sql = "SELECT * FROM weatherstation";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.execute();

        ResultSet resultSet = preparedStatement.getResultSet();
        WeatherStation weatherStation;

        while (resultSet.next()) {

            weatherStation = new WeatherStation();
            weatherStation.setId(resultSet.getString("id"));
            weatherStation.setName(resultSet.getString("ws_name"));
            weatherStation.setDate(resultSet.getString("file_date"));
            weatherStation.setFileName(resultSet.getString("file_name"));
            weatherStation.setAverageTemp(resultSet.getDouble("average_Temp"));
            weatherStation.setMinTemp(resultSet.getDouble("min_Temp"));
            weatherStation.setMaxTemp(resultSet.getDouble("max_Temp"));
            weatherStations.add(weatherStation);

            files.add(resultSet.getString("fileName"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }

    private void saveDataToDataBank() {

        Connection connection = new DatabaseConnection().getConnection();
        if (connection == null) {
            System.out.println("WeatherStationModel: connection is null");
            return;
        }

        String sql = """
                INSERT INTO Weather_Station
                (id, ws_name, file_date, file_name, average_Temp, min_Temp, max_Temp)
                VALUES (?, ?, ?, ?, ?, ?, ?)""";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (WeatherStation weatherStation : weatherStations) {

                preparedStatement.setString(1, weatherStation.getId());
                preparedStatement.setString(2, weatherStation.getName());
                preparedStatement.setString(3, weatherStation.getDate());
                preparedStatement.setString(4, weatherStation.getFileName());
                preparedStatement.setDouble(5, weatherStation.getAverageTemp());
                preparedStatement.setDouble(6, weatherStation.getMinTemp());
                preparedStatement.setDouble(7, weatherStation.getMaxTemp());
                preparedStatement.execute();
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getPath() {
        return path;
    }

    public ArrayList<WeatherStation> getWeatherStations() {
        return weatherStations;
    }

    public ArrayList<String> getFiles() {
        return files;
    }

    public void insertWeatherStation(WeatherStation weatherStation) {

        System.out.println("WeatherStationModel: insertWeatherStation");

        Connection connection = new DatabaseConnection().getConnection();
        if (connection == null) {
            System.out.println("WeatherStationModel: connection is null");
            return;
        }
        System.out.println("WeatherStationModel: is connected");

        String sql = """
                INSERT INTO Weather_Station
                (id, ws_name, file_date, file_name, average_Temp, min_Temp, max_Temp)
                VALUES (?, ?, ?, ?, ?, ?, ?)""";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, weatherStation.getId());
            statement.setString(2, weatherStation.getName());
            statement.setString(3, weatherStation.getDate());
            statement.setString(4, weatherStation.getFileName());
            statement.setDouble(5, weatherStation.getAverageTemp());
            statement.setDouble(6, weatherStation.getMinTemp());
            statement.setDouble(7, weatherStation.getMaxTemp());
            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void savePath() {

        Connection connection = new DatabaseConnection().getConnection();
        if (connection == null) {
            System.out.println("WeatherStationModel: connection is null");
            return;
        }

        String sql = "INSERT INTO Path VALUES (?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, path);
            preparedStatement.execute();

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
