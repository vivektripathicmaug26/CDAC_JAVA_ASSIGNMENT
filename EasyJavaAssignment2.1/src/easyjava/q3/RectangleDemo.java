package easyjava.q3;

public class RectangleDemo {
	public static void main(String[] args) {

		Rectangle rectangle = new Rectangle(10, 5);
		Square square = new Square(5);

		rectangle.printArea();
		rectangle.printPerimeter();

		System.out.println();

		square.printArea();
		square.printPerimeter();
	}
}

