package exercise;

// BEGIN
import static java.lang.Math.signum;

public class Cottage implements Home{
    private double area;
    private int floor;

    public Cottage(double area, int floor) {
        this.area = area;
        this.floor = floor;
    }

    public double getArea() {
        return this.area;
    }

    public int compareTo(Home another) {
        return (int) signum(this.getArea() - another.getArea());
    }

    @Override
    public String toString() {
        return this.floor +
                " этажный коттедж площадью " +
                this.getArea() +
                " метров";
    }
}
// END
