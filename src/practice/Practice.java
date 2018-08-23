package practice;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String choice;
        do {
        	System.out.println("Main:");
            System.out.println("1. Departments");
            System.out.println("2. Employee");
            System.out.println("3. Exit");
            choice = scan.nextLine();
            choice = choice.trim();

            switch (choice) {
                case "1":
                	Util.department();
                    break;
                case "2":
                	Util.employee();
                    break; 
                case "3":
                    return;
            }
        }
        while (choice != "3");
	}
	
}
