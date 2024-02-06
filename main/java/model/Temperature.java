package Wetterstation;

public class Temperature {

    int number;
    String date;
    String time;
    double temp;

    public Temperature(String num, String date, String time, String tempGrad) {
        this.number = Integer.parseInt(num);
        this.date = date;
        this.time = time;
        this.temp = Double.parseDouble(tempGrad.replace(",", "."));
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
