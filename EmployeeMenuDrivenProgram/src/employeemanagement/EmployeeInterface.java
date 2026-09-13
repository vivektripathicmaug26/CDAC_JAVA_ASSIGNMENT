package employeemanagement;

import utility.ConsoleInput;

public class EmployeeInterface {

	static Employee[] employees = new Employee[100];
	static int count = 0;

	public static void main(String[] args) {

		int choice;

		do {
			System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
			System.out.println("1. Add");
			System.out.println("2. Display");
			System.out.println("3. Delete");
			System.out.println("4. Sort");
			System.out.println("5. Save");
			System.out.println("6. Load");
			System.out.println("7. Exit");

			System.out.print("Enter choice: ");
			choice = ConsoleInput.getInt();

			switch (choice) {
			case 1 -> addEmployee();
			case 2 -> displayEmployee();
			case 3 -> System.out.println("Delete is not implemented yet.");
			case 4 -> System.out.println("Sort is not implemented yet.");
			case 5 -> System.out.println("Save is not implemented yet.");
			case 6 -> System.out.println("Load is not implemented yet.");
			case 7 -> System.out.println("Exiting...");
			default -> System.out.println("Invalid choice.");
			}

		} while (choice != 7);
	}

	static void addEmployee() {

		String choice;

		do {
			System.out.println("\n----- ADD AN EMPLOYEE -----");
			System.out.println("a. Manager");
			System.out.println("b. Engineer");
			System.out.println("c. Sales Person");
			System.out.println("d. Exit to Main Menu");

			System.out.print("Enter choice: ");
			choice = ConsoleInput.getString();

			switch (choice.toLowerCase()) {

			case "a" -> addManager();

			case "b" -> addEngineer();

			case "c" -> addSalesPerson();

			case "d" -> System.out.println("Returning to Main Menu...");

			default -> System.out.println("Invalid choice.");
			}

		} while (!choice.equalsIgnoreCase("d"));
	}

	static void addManager() {

		System.out.print("Enter name: ");
		String name = ConsoleInput.getString();

		System.out.print("Enter address: ");
		String address = ConsoleInput.getString();

		System.out.print("Enter age: ");
		int age = ConsoleInput.getInt();

		System.out.print("Enter gender: ");
		char gender = ConsoleInput.getString().charAt(0);

		System.out.print("Enter basic salary: ");
		double salary = ConsoleInput.getFloat();

		System.out.print("Enter HRA: ");
		double hra = ConsoleInput.getFloat();

		employees[count] = new Manager(name, address, age, gender, salary, hra);
		count++;

		System.out.println("Manager added successfully.");
	}

	static void addEngineer() {

		System.out.print("Enter name: ");
		String name = ConsoleInput.getString();

		System.out.print("Enter address: ");
		String address = ConsoleInput.getString();

		System.out.print("Enter age: ");
		int age = ConsoleInput.getInt();

		System.out.print("Enter gender: ");
		char gender = ConsoleInput.getString().charAt(0);

		System.out.print("Enter basic salary: ");
		double salary = ConsoleInput.getFloat();

		System.out.print("Enter overtime: ");
		int overtime = ConsoleInput.getInt();

		employees[count] = new Engineer(name, address, age, gender, salary, overtime);
		count++;

		System.out.println("Engineer added successfully.");
	}

	static void addSalesPerson() {

		System.out.print("Enter name: ");
		String name = ConsoleInput.getString();

		System.out.print("Enter address: ");
		String address = ConsoleInput.getString();

		System.out.print("Enter age: ");
		int age = ConsoleInput.getInt();

		System.out.print("Enter gender: ");
		char gender = ConsoleInput.getString().charAt(0);

		System.out.print("Enter basic salary: ");
		double salary = ConsoleInput.getFloat();

		System.out.print("Enter commission percentage: ");
		double commission = ConsoleInput.getFloat();

		employees[count] = new SalesPerson(
				name,
				address,
				age,
				gender,
				salary,
				commission);

		count++;

		System.out.println("Sales Person added successfully.");
	}

	static void displayEmployee() {

		String choice;

		do {
			System.out.println("\n----- DISPLAY -----");
			System.out.println("a. All Employees");
			System.out.println("b. Exit to Main Menu");

			System.out.print("Enter choice: ");
			choice = ConsoleInput.getString();

			switch (choice.toLowerCase()) {

			case "a" -> {
				if (count == 0) {
					System.out.println("No employees found.");
				} else {
					for (int i = 0; i < count; i++) {
						employees[i].display();
						System.out.println("----------------------");
					}
				}
			}

			case "b" -> System.out.println("Returning to Main Menu...");

			default -> System.out.println("Invalid choice.");
			}

		} while (!choice.equalsIgnoreCase("b"));
	}
}