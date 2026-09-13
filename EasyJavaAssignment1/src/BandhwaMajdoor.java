
public class BandhwaMajdoor {
	double salary;
    int hours;

    void getInfo(double salary, int hours) {
        this.salary = salary;
        this.hours = hours;
    }

    void addSal() {
        if (salary < 500) {
            salary = salary + 10;
        }
    }

    void addWork() {
        if (hours > 6) {
            salary = salary + 5;
        }
    }

    void displaySalary() {
        System.out.println("Final Salary = $" + salary);
    }

    public static void main(String[] args) {
    	

        System.out.print("Enter salary: ");
        double salary = ConsoleInput.getFloat();

        System.out.print("Enter number of hours of work per day: ");
        int hours = ConsoleInput.getInt();

        
        BandhwaMajdoor e=new BandhwaMajdoor();

        e.getInfo(salary, hours);
        e.addSal();
        e.addWork();
        e.displaySalary();

    }
}