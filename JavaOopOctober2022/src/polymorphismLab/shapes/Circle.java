package polymorphismLab.shapes;

public class Circle extends Shape{

    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * Math.PI * getRadius());
    }

    @Override
    protected void calculateArea() {
        setArea(Math.PI * getRadius() * getRadius());
    }
}
