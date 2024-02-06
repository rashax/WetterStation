package Wetterstation;

public class WS_GUI {
    public static void main(String[] args) {

        WeatherStationModel model = new WeatherStationModel();

        MainFrame mainFrame = new MainFrame("Verwaltung von Wetterstationen");
        mainFrame.setSize(850, 550);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);

        mainFrame.setWeatherStationModel(model);
        mainFrame.setPath("C:\\Dokus\\3 Drittes Jahr\\LF12\\00_Wetterstation");

    }
}

//http://www.gailer-net.de/tutorials/java/Notes/chap57/ch57_15.html#program,%20one%20button%20GUI
