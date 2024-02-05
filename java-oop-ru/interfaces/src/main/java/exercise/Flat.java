package exercise;

// BEGIN
import static java.lang.Math.signum;

public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public double getArea() {
        return this.area + this.balconyArea;
    }

    public int compareTo(Home another) {
        return (int) signum(this.getArea() - another.getArea());
    }

    @Override
    public String toString() {
        return "Квартира площадью " +
                this.getArea() +
                " метров на " +
                this.floor +
                " этаже";
    }
}
// END
