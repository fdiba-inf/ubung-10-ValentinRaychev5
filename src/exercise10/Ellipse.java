package exercise10;

public class Ellipse extends Figure {

    public Ellipse() {

        super(new Point(0, 0), 1, 1);
    }

    public Ellipse(Point startPoint, double side1, double side2) {

        super(new Point(startPoint), side1, side2);
    }

    public Ellipse(Ellipse otherEllipse) {
        super(otherEllipse.startPoint, otherEllipse.side1, otherEllipse.side2);
    }

    @Override
    public double calculatePerimeter() {
        return Math.PI * (3.0 * (side1 + side2) - Math.sqrt((3.0 * side1 + side2) * (side1 + 3.0 * side2)));
    }

    @Override
    public double calculateArea() {
        return Math.PI * side1 * side2;
    }

    @Override
    public String getType() {
        return (side1 == side2) ? "Circle" : "Ellipse";
    }

    @Override
    public boolean equal(Figure otherFigure) {

      if  (otherFigure instanceof Figure)  {
        return super.equal(otherFigure);
      }
      else  {
        return false;
      }

    }

    public boolean containsClick(Point click) {

        double formula = (Math.pow((click.getX() - startPoint.getX()), 2)) / (side1*side1)
        +
        (Math.pow((click.getY() - startPoint.getY()), 2)) / (side2*side2);

        if (formula <= 1) {
          return true;
        }
        return false;
    }
}
