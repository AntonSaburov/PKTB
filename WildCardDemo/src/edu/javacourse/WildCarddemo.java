package edu.javacourse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by antonsaburov on 23.06.16.
 */
public class WildCarddemo
{
    public static void main(String[] args) {
        List<CargoWagon> wagons = new ArrayList<>();
        for(int i = 1; i<10; i++) {
            wagons.add(new CargoWagon(new Double(i), new Double(i), new Double(i)));
        }

        printVolume(wagons);
    }

    private static void printVolume(List<? extends Wagon> wagons) {
        for(Wagon w : wagons) {
            System.out.println(w.getVolume());
        }
    }

}


class Wagon
{
    private Double length;
    private Double width;
    private Double height;

    public Wagon(Double length, Double width, Double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getVolume() {
        return length * width * height;
    }
}

class CargoWagon extends Wagon
{
    public CargoWagon(Double length, Double width, Double height) {
        super(length, width, height);
    }

    public Double getVolume() {
        return getLength() * getWidth() * getHeight() / 1.2;
    }
}