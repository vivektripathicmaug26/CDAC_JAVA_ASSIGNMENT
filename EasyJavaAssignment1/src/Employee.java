
public class Employee {
	String name;
	int yearOfJoining;
	String address;
	public Employee(String name, int yearOfJoining, String address) {
		super();
		this.name = name;
		this.yearOfJoining = yearOfJoining;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearOfJoining() {
		return yearOfJoining;
	}
	public void setYearOfJoining(int yearOfJoining) {
		this.yearOfJoining = yearOfJoining;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	void display() {
		System.out.println(name+"\t\t"+yearOfJoining+"\t\t"+address);
	}
	public static void main(String[] args) {
		Employee e1=new Employee("Robert",1994,"64C-WallsStreet");
		Employee e2=new Employee("Sam",2000,"68D-WallsStreet");
		Employee e3=new Employee("John",1999,"13B-WallsStreet");
		
		System.out.println("Name\tYear of joining\t\tAddress");
		e1.display();
		e2.display();
		e3.display();
		
	}

}
