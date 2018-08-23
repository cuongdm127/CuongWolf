package practice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Util {
	
	public static ArrayList<Department> departments = new ArrayList<>();
	public static ArrayList<Employee> employees = new ArrayList<>();
	public static Scanner scan = new Scanner(System.in);
	public static Department dep = new Department();

	
	// Employee Menu
	public static void employee() {
        String choice;
        
        do {
        	System.out.println("Employees:");
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Exit");
            choice = scan.nextLine();
            choice = choice.trim();

            switch (choice) {
                case "1":
                    AddEmployee();
                    break;
                case "2":
                    SearchEmployee();
                    break;
                case "3":
                    RemoveEmployee();
                    break;
                case "4":
                    return;
            }
        }
        while (choice != "4");
    }
	
	// Add employee method
	public static void AddEmployee() {
		if (departments.size() < 1) {
            System.out.println("Must enter department first!");
            return;
        }
		
        Employee emp = new Employee();
        System.out.println("Input information: ");
        UUID uuid = UUID.randomUUID();
        emp.id = uuid.toString();
        System.out.print("Name: ");
        emp.name = scan.nextLine();
        System.out.print("Description: ");
        emp.description = scan.nextLine();
        System.out.print("Department: ");
        listDepartments();
        String i = scan.nextLine();
        departments.get(Integer.parseInt(i.trim()) - 1).AddEmployee(emp);
    }
	
	// Search Employee method
	public static void SearchEmployee() {
        if (departments.size() < 1) {
            System.out.println("No employees");
            return;
        }

        System.out.print("Search by name: ");

        for (int i = 0; i < departments.size(); i++) {
            Employee emp = departments.get(i).findEmployee(scan.nextLine());
            if (emp.name != "") {
                System.out.println("Name: " + emp.name);
                System.out.println("Description: " + emp.description);
                return;
            }
        }

        System.out.println("Not found");
    }
	
	// Remove employee method
	public static void RemoveEmployee() {
        if (departments.size() < 1) {
            System.out.println("No employees");
            return;
        }

        System.out.print("Delete by name: ");

        for (int i = 0; i < departments.size(); i++) {
            boolean deleted = departments.get(i).removeEmployee(scan.nextLine());
            if (deleted) {
                System.out.println("Deleted");
                return;
            }
        }

        System.out.println("Not found");
    }
	
	// List all departments are existing
	public static void listDepartments() {
        System.out.println("Departments: ");          
        for (int i = 0; i < departments.size(); i++) {
            System.out.print((i+1) + ". " + departments.get(i).name);
        }
    }

	// Remove Employee
    public boolean removeEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (name.equalsIgnoreCase(this.employees.get(i).name)) {
                this.employees.remove(this.employees.get(i));
                return true;
            }
        }

        return false;
    }
    
    
    // Department Menu
    public static void department() {
        String choice;
        do {
        	System.out.println("Departments:");
            System.out.println("1. Add");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Show all");
            System.out.println("5. Exit");
            choice = scan.nextLine();
            choice = choice.trim();

            switch (choice) {
                case "1":
                    AddDepartment();
                    break;
                case "2":
                    SearchDepartment();
                    break;
                case "3":
                    RemoveDepartment();
                    break;
                case "4":
                    showAll();
                    break;
                case "5":
                    return;
            }
        }
        while (choice != "5");
    }
    
    // Add department method
    public static void AddDepartment() {
        System.out.println("Input information: ");
        UUID uuid = UUID.randomUUID();
        dep.id = uuid.toString();
        System.out.print("Name: ");
        dep.name = scan.nextLine();
        System.out.print("Description: ");
        dep.description = scan.nextLine();
        departments.add(dep);
    }
    
    // Search department method
    public static void SearchDepartment() {
        if (departments.size() < 1) {
            System.out.println("No departments");
            return;
        }

        System.out.print("Search by name: ");
        String name = scan.nextLine();

        for (int i = 0; i < departments.size(); i++) {
            if (name.equalsIgnoreCase(departments.get(i).name)) {
                departments.get(i).showEmployees();
                return;
            }
        }

        System.out.println("Not found");
    }
    
    // Remove Department method
    public static void RemoveDepartment() {
        if (departments.size() < 1) {
            System.out.println("No department");
            return;
        }

        System.out.print("Delete by name: ");
        String name = scan.nextLine();

        for (int i = 0; i < departments.size(); i++) {
            if (name.equalsIgnoreCase(departments.get(i).name)) {
                departments.remove(departments.get(i));
                System.out.println("Deleted");
                return;
            }
        }

        System.out.println("Not found");
    }
    
    // Show all employees of Departments
    public static void showAll() {
        if (departments.size() < 1) {
            System.out.println("No departments");
            return;
        }

        for (int i = 0; i < departments.size(); i++) {
            departments.get(i).showEmployees();
        }
    }
}
