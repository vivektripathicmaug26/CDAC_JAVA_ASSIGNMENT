package employeemanagement;

public class Manager extends Employee {
	private double hra;

	public Manager(String name, String address, int age, char gender, double basicSalary, double hra) {
		super(name, address, age, gender, basicSalary);
		this.hra = hra;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	@Override
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("Basic Salary: " + basicSalary);
		System.out.println("HRA: " + hra);
	}
}