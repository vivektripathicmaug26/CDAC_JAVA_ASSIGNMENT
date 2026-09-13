package easyjava.q3;

class Rectangle {
	double length;
	double breadth;

	public Rectangle(double length, double breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	public void printArea() {
		System.out.println("Area of Rectangle: " + (length * breadth));
	}

	public void printPerimeter() {
		System.out.println("Perimeter of Rectangle: " + (2 * (length + breadth)));
	}
}

class Square extends Rectangle {

	public Square(double side) {
		super(side, side);
	}

	public void printArea() {
		System.out.println("Area of Square: " + (length * breadth));
	}

	public void printPerimeter() {
		System.out.println("Perimeter of Square: " + (2 * (length + breadth)));
	}
}

