
public class Rectangle {
	int breadth;
	int length;
	public Rectangle(int breadth,int length) {
		this.breadth=breadth;
		this.length=length;	
	}
	void area() {
		int area=breadth*length;
		System.out.println("The area of rectangle is :"+area);
	}
	void perimeter() {
		int perimeter=2*(breadth+length);
		System.out.println("the perimeter of area is :"+perimeter);
	}
	public static void main(String[] args) {
		Rectangle r1=new Rectangle(5, 4);
		Rectangle r2=new Rectangle(3, 7);
		r1.area();
		r1.perimeter();
		r2.area();
		r2.perimeter();
		
	}
}
