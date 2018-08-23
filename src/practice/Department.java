package practice;

import java.util.ArrayList;

public class Department {
	public String id;
	public String name;
	public String description;
	public static ArrayList<Employee> employees = new ArrayList<>();
	
	public void AddEmployee(Employee emp) {
        this.employees.add(emp);
    }
	
	public Employee findEmployee(String name) {
        Employee e = new Employee();

        for (int i = 0; i < this.employees.size(); i++) {
            if (name.equalsIgnoreCase(this.employees.get(i).name)) {
                return this.employees.get(i);
            }
        }

        return e;
    }
	
	public void showEmployees() {
        System.out.println("Department " + this.name + " has " + this.employees.size() + " employees:");
        for (int i = 0; i < this.employees.size(); i++) {
            System.out.println(this.employees.get(i).name);
        }
    }
	
	public boolean removeEmployee(String name) {
        for (int i = 0; i < this.employees.size(); i++) {
            if (name.equalsIgnoreCase(this.employees.get(i).name)) {
                this.employees.remove(this.employees.get(i));
                return true;
            }
        }

        return false;
    }
}
