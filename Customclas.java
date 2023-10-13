package set;

import java.util.TreeSet;

public class Customclas {
    class Car implements Comparable<Car> {
        int Cost;
        String name, city;
        int stock;

        public Car(int Cost, String name, String city, int stock) {
            this.Cost = Cost;
            this.name = name;
            this.city = city;
            this.stock = stock;
        }

        public int compareTo(Car c) {
            if (Cost > c.Cost) {
                return -1;
            } else if (Cost < c.Cost) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        TreeSet<Car> set = new TreeSet<Car>();

        Car c1 = new Customclas().new Car(13200, "BMW", "Dallas", 35);
        Car c2 = new Customclas().new Car(26900, "Audi", "Atlanta", 20);
        Car c3 = new Customclas().new Car(56000, "Kia", "Houston", 15);
        Car c4 = new Customclas().new Car(10900, "Creta", "Chicago", 26);
        Car c5 = new Customclas().new Car(13200, "BMW", "Dallas",35);

        set.add(c1);
        set.add(c2);
        set.add(c3);
        set.add(c4);
        set.add(c5);

        Car[] uniqueCars = new Car[set.size()];

        int index = 0;
        for (Car car : set) {
            uniqueCars[index] = car;
            index++;
        }

        for (Car car : uniqueCars) {
            System.out.println(car.stock + " " + car.name + " " + car.city + " " + car.Cost);
        }
    }
}