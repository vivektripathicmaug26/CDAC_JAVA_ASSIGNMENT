package employeemanagement;

public class SalesPerson extends Employee {
	private double commission;

	public SalesPerson(String name, String address, int age, char gender, double basicSalary, double commission) {
		super(name, address, age, gender, basicSalary);
		this.commission = commission;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	@Override
	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Age: " + age);
		System.out.println("Gender: " + gender);
		System.out.println("Basic Salary: " + basicSalary);
		System.out.println("Commission: " + commission + "%");
	}
}