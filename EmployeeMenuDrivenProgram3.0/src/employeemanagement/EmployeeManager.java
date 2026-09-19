package employeemanagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import utility.ConsoleInput;

public class EmployeeManager {

    private Employee[] employees = new Employee[30];
    private int count = 0;

    private static final String FILE_NAME = "employees.txt";

    public void addEmployee() {

        String choice;

        do {
            System.out.println("\n----- ADD EMPLOYEE -----");
            System.out.println("a. Manager");
            System.out.println("b. Engineer");
            System.out.println("c. Sales Person");
            System.out.println("d. Exit");

            System.out.print("Enter choice: ");
            choice = ConsoleInput.getString();

            switch (choice.toLowerCase()) {

            case "a" -> addManager();
            case "b" -> addEngineer();
            case "c" -> addSalesPerson();
            case "d" -> System.out.println("Returning...");
            default -> System.out.println("Invalid choice.");
            }

        } while (!choice.equalsIgnoreCase("d"));
    }

    private EmployeeData getEmployeeDetails() {

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

        return new EmployeeData(name, address, age, gender, salary);
    }

    private boolean isFull() {

        if (count == employees.length) {
            System.out.println("Employee array is full.");
            return true;
        }

        return false;
    }

    private void addToArray(Employee employee) {
        employees[count++] = employee;
    }

    private void addManager() {

        if (isFull()) {
            return;
        }

        EmployeeData data = getEmployeeDetails();

        System.out.print("Enter HRA: ");
        double hra = ConsoleInput.getFloat();

        addToArray(new Manager(
                data.name,
                data.address,
                data.age,
                data.gender,
                data.salary,
                hra));

        System.out.println("Manager added successfully.");
    }

    private void addEngineer() {

        if (isFull()) {
            return;
        }

        EmployeeData data = getEmployeeDetails();

        System.out.print("Enter overtime: ");
        int overtime = ConsoleInput.getInt();

        addToArray(new Engineer(
                data.name,
                data.address,
                data.age,
                data.gender,
                data.salary,
                overtime));

        System.out.println("Engineer added successfully.");
    }

    private void addSalesPerson() {

        if (isFull()) {
            return;
        }

        EmployeeData data = getEmployeeDetails();

        System.out.print("Enter commission percentage: ");
        double commission = ConsoleInput.getFloat();

        addToArray(new SalesPerson(
                data.name,
                data.address,
                data.age,
                data.gender,
                data.salary,
                commission));

        System.out.println("Sales Person added successfully.");
    }

    public void displayEmployee() {

        if (count == 0) {
            System.out.println("No employees found.");
            return;
        }

        for (int i = 0; i < count; i++) {

            employees[i].display();

            if (employees[i] instanceof Manager) {
                System.out.println("Employee Type: " + EmployeeType.MANAGER);

            } else if (employees[i] instanceof Engineer) {
                System.out.println("Employee Type: " + EmployeeType.ENGINEER);

            } else if (employees[i] instanceof SalesPerson) {
                System.out.println("Employee Type: " + EmployeeType.SALES_PERSON);
            }

            System.out.println("----------------------");
        }
    }

    public void deleteEmployee() {

        if (count == 0) {
            System.out.println("No employees found.");
            return;
        }

        System.out.print("Enter employee name: ");
        String name = ConsoleInput.getString();

        int index = -1;

        for (int i = 0; i < count; i++) {

            if (employees[i].getName().equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[--count] = null;

        System.out.println("Employee deleted successfully.");
    }

    public void sortEmployee() {

        if (count == 0) {
            System.out.println("No employees found.");
            return;
        }

        for (int i = 0; i < count - 1; i++) {

            for (int j = 0; j < count - 1 - i; j++) {

                if (employees[j].getName()
                        .compareToIgnoreCase(employees[j + 1].getName()) > 0) {

                    Employee temp = employees[j];

                    employees[j] = employees[j + 1];

                    employees[j + 1] = temp;
                }
            }
        }

        System.out.println("Employees sorted successfully.");
    }

    public void saveEmployee() {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (int i = 0; i < count; i++) {

                Employee employee = employees[i];

                StringBuilder data = new StringBuilder();

                data.append(getEmployeeType(employee))
                    .append("|")
                    .append(employee.getName())
                    .append("|")
                    .append(employee.getAddress())
                    .append("|")
                    .append(employee.getAge())
                    .append("|")
                    .append(employee.getGender())
                    .append("|")
                    .append(employee.getBasicSalary())
                    .append("|")
                    .append(getExtraData(employee));

                writer.write(data.toString());
                writer.newLine();
            }

            System.out.println("Employees saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving employees.");
        }
    }

    private EmployeeType getEmployeeType(Employee employee) {

        if (employee instanceof Manager) {
            return EmployeeType.MANAGER;

        } else if (employee instanceof Engineer) {
            return EmployeeType.ENGINEER;

        } else {
            return EmployeeType.SALES_PERSON;
        }
    }

    private String getExtraData(Employee employee) {

        if (employee instanceof Manager manager) {
            return String.valueOf(manager.getHra());

        } else if (employee instanceof Engineer engineer) {
            return String.valueOf(engineer.getOvertime());

        } else if (employee instanceof SalesPerson salesPerson) {
            return String.valueOf(salesPerson.getCommission());
        }

        return "";
    }

    public void loadEmployee() {

        try (BufferedReader reader =
                new BufferedReader(new FileReader(FILE_NAME))) {

            count = 0;

            String line;

            while ((line = reader.readLine()) != null
                    && count < employees.length) {

                String[] data = line.split("\\|");

                Employee employee = createEmployee(data);

                if (employee != null) {
                    employees[count++] = employee;
                }
            }

            System.out.println("Employees loaded successfully.");

        } catch (IOException e) {

            System.out.println(
                    "File not found or error while loading.");

        } catch (Exception e) {

            System.out.println(
                    "Invalid data in file.");
        }
    }

    private Employee createEmployee(String[] data) {

        EmployeeType type =
                EmployeeType.valueOf(data[0]);

        String name = data[1];
        String address = data[2];
        int age = Integer.parseInt(data[3]);
        char gender = data[4].charAt(0);
        double salary = Double.parseDouble(data[5]);

        switch (type) {

        case MANAGER:

            double hra = Double.parseDouble(data[6]);

            return new Manager(
                    name,
                    address,
                    age,
                    gender,
                    salary,
                    hra);

        case ENGINEER:

            int overtime = Integer.parseInt(data[6]);

            return new Engineer(
                    name,
                    address,
                    age,
                    gender,
                    salary,
                    overtime);

        case SALES_PERSON:

            double commission = Double.parseDouble(data[6]);

            return new SalesPerson(
                    name,
                    address,
                    age,
                    gender,
                    salary,
                    commission);

        default:
            return null;
        }
    }

    private static class EmployeeData {

        String name;
        String address;
        int age;
        char gender;
        double salary;

        EmployeeData(
                String name,
                String address,
                int age,
                char gender,
                double salary) {

            this.name = name;
            this.address = address;
            this.age = age;
            this.gender = gender;
            this.salary = salary;
        }
    }
}