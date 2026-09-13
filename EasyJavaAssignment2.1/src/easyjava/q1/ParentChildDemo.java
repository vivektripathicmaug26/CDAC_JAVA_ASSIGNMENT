package easyjava.q1;

public class ParentChildDemo {
	public static void main(String[] args) {

		Parent p = new Parent();
		Child c = new Child();

		p.parentMethod();

		c.childMethod();

		c.parentMethod();
	}
}