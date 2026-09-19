package employeemanagement;

public class Engineer extends Employee {
	private int overtime;

	public Engineer(String name, String address, int age, char gender, double basicSalary, int overtime) {
		super(name, address, age, gender, basicSalary);
		this.overtime = overtime;
	}

	public int getOvertime() {
		return overtime;
	}

	public void setOvertime(int overtime) {
		this.overtime = overtime;
	}

	@Override
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("Basic Salary: " + basicSalary);
		System.out.println("Overtime: " + overtime);
	}
}