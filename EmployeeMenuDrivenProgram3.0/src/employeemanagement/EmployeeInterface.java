package employeemanagement;

import utility.ConsoleInput;

public class EmployeeInterface {

	public static void main(String[] args) {

		EmployeeManager manager = new EmployeeManager();

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

			case 1 -> manager.addEmployee();

			case 2 -> manager.displayEmployee();

			case 3 -> manager.deleteEmployee();

			case 4 -> manager.sortEmployee();

			case 5 -> manager.saveEmployee();

			case 6 -> manager.loadEmployee();

			case 7 -> System.out.println("Exiting...");

			default -> System.out.println("Invalid choice.");
			}

		} while (choice != 7);
	}
}