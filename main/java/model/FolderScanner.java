package Wetterstation;

import javax.swing.*;
import java.io.*;
import java.util.Objects;

public class FolderScanner {
    private static void readNewFile(WeatherStationModel model, File fileEntry) {

        try (BufferedReader br = new BufferedReader(new FileReader(fileEntry.getAbsolutePath()))) {

            boolean isTemperature = false;
            WeatherStation weatherStation = null;
            String line;
            Temperature temperature;
            while ((line = br.readLine()) != null) {

                System.out.println(line);
                if (line.equals(";;;")) continue;

                if (line.startsWith("Station")) {
                    weatherStation = new WeatherStation(line.split(";")[1]);

                } else if (line.startsWith("Nr")) {
                    isTemperature = true;

                } else if (isTemperature) {

                    String[] tempeData = line.split(";");
                    temperature = new Temperature(tempeData[0], tempeData[1], tempeData[2], tempeData[3]);
                    assert weatherStation != null;
                    weatherStation.addTemperature(temperature);
                }
            }
            model.getWeatherStations().add(weatherStation);
            model.getFiles().add(fileEntry.getName());
            model.insertWeatherStation(weatherStation);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public FolderScanner(WeatherStationModel model, String path) {

        if (path.isEmpty()) {
            System.out.println("FolderScanner: path is empty");
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Bitte geben Sie zuerst einen Pfad ein.");
            return;
        }

        File folder = new File(path);
        if (!folder.exists()) {
            System.out.println("FolderScanner: path does not exist");
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Der angegebene Pfad existiert nicht.");
            return;
        }
        if (!folder.isDirectory()) {
            System.out.println("FolderScanner: path is not a directory");
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Der angegebene Pfad ist kein Verzeichnis.");
            return;
        }
        if (!folder.canRead()) {
            System.out.println("FolderScanner: path is not readable");
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Der angegebene Pfad ist nicht lesbar.");
            return;
        }

        if (Objects.requireNonNull(folder.listFiles()).length == 0) {
            System.out.println("FolderScanner: path is empty");
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Der angegebene Pfad ist leer.");
            return;
        }

        System.out.println("FolderScanner: path is valid");

        if ( path.equals(model.getPath()) ) {
            System.out.println("save Path");
            model.savePath();
        }

        for ( File fileEntry : Objects.requireNonNull(folder.listFiles())) {

            if (!model.getFiles().contains(fileEntry.getName())) {

                System.out.println("FolderScanner: file " + fileEntry.getName() + " is new");


                readNewFile(model, fileEntry);
            }
        }
    }

    public static void main(String[] args) {
    }
}
