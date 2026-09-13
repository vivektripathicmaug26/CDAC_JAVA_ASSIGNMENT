public class Triangle {
	
	int side1;
	int side2;
	int side3;
	
	public Triangle(int side1, int side2, int side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	void area() {
		double area=(side1*side2)/2.0;
		System.out.println("Area of Triangle: "+area);
	}
	void perimeter() {
		int perimeter=side1+side2+side3;
		System.out.println("Perimeter of triangle is : "+perimeter);
		
	}

	public static void main(String[] args) {
		Triangle t = new Triangle(3, 4, 5);

        t.area();
        t.perimeter();
    }
		
	}