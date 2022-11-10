package encapsulationExercise.classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        checkNumberIsPositive(length, "Length");
        this.length = length;
    }

    private void setWidth(double width) {
        checkNumberIsPositive(width, "Width");
        this.width = width;
    }

    private void setHeight(double height) {
        checkNumberIsPositive(height, "Height");
        this.height = height;
    }

    public double calculateSurfaceArea() {
        return (2 * length * height) + (2 * width * height) + (2 * length * width);
    }

    public double calculateLateralSurfaceArea() {
            return ((2 * length * height) + (2 * width * height));
    }

    public double calculateVolume() {
       return width * length * height;

    }
    private void checkNumberIsPositive(double digit, String messagePrefix) {
        if(digit <= 0 ) {
            throw new IllegalArgumentException(messagePrefix + " cannot be zero or negative.");
        }
    }
}
