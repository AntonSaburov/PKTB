package edu.javacourse.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by antonsaburov on 23.06.16.
 */
public class LambdaDemo {
    public static void main(String[] args) {
        List<Wagon> wagons = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            wagons.add(new Wagon(new Double(i), new Double(i), new Double(i)));
        }

//        printVolume(wagons, new MyCalculate());

//        printVolume(wagons, (w) -> w.getLength() * w.getWidth() * w.getHeight());

//        List<Double> collect = wagons.stream()
//                .filter(w -> w.getLength() > 4.0)
//                .map(w -> w.getLength() * w.getWidth() * w.getHeight())
//                .collect(Collectors.toList());

        wagons.stream().sorted(new WagonComparator()).forEach(w -> System.out.println(w));
        wagons.stream().sorted(new WagonComparator2()).forEach(w -> System.out.println(w));
        wagons.stream().sorted(WagonComparator3::compare1).forEach(w -> System.out.println(w));


        Collections.sort(wagons);
    }

//    private static void printVolume(List<? extends Wagon> wagons, CalculateVolume calc) {
//        for (Wagon w : wagons) {
//            Double d = calc.getVolume(w);
//            System.out.println(d);
//        }
//    }

    private static void printVolume(List<? extends Wagon> wagons, Function<Wagon, Double> fun) {
        for (Wagon w : wagons) {
            Double d = fun.apply(w);
            System.out.println(d);
        }
    }

}


class Wagon implements Comparable<Wagon> {
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

    @Override
    public String toString() {
        return "Wagon{" +
                "length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public int compareTo(Wagon o) {
        return (int)(getLength() - o.getLength());
    }
}


class WagonComparator implements Comparator<Wagon>
{
    @Override
    public int compare(Wagon o1, Wagon o2) {
        return (int)(o1.getLength() - o2.getLength());
    }
}

class WagonComparator2 implements Comparator<Wagon>
{
    @Override
    public int compare(Wagon o1, Wagon o2) {
        return -(int)(o1.getLength() - o2.getLength());
    }
}

class WagonComparator3
{
    public static int compare1(Wagon o1, Wagon o2) {
        return -(int)(o1.getLength() - o2.getLength());
    }

     public int compare2(Wagon o1, Wagon o2) {
         return -(int)(o1.getLength() - o2.getLength());
     }

}


//interface CalculateVolume {
//    Double getVolume(Wagon w);
//}

//class MyCalculate implements CalculateVolume {
//    @Override
//    public Double getVolume(Wagon w) {
//        return w.getLength() * w.getWidth() * w.getHeight();
//    }
//}