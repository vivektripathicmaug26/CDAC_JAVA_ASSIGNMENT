package easyjava.q4;

public class ShapeDemo {
	public static void main(String[] args) {

		Shape shape = new Shape();
		Rectangle rectangle = new Rectangle();
		Circle circle = new Circle();
		Square square = new Square();

		shape.printShape();

		rectangle.printShape();
		rectangle.printRectangle();

		circle.printShape();
		circle.printCircle();

		square.printShape();
		square.printRectangle();
		square.printSquare();
}
}