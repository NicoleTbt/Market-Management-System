import java.util.Scanner;

public class Driver extends Methods{

	public static void main(String[] args) {
		
		ReadFiles();
		
		Scanner scan = new Scanner(System.in);

		int choice;

		System.out.println("What do you want to manage?");

		do {
			System.out.println("1)Employee");
			System.out.println("2)Supplier");
			System.out.println("3)Product Category");
			System.out.println("4)Product");
			System.out.println("5)Accounting");
			System.out.println("6)Purchase");
			System.out.println("7)Sales");
			System.out.println("8)Return");
			System.out.println("9)Exit..");
			choice = scan.nextInt();

			switch(choice) {
			case 1:
				manageEmployee();
				break;
			case 2:
				manageSupplier();
				break;
			case 3:
				manageCategory();
				break;
			case 4:
				manageProducts();
				break;
			case 5:
				manageAccounting();
				break;
			case 6:
				managePurchase();
				break;
			case 7:
				manageSales();
				break;
			case 8:
				manageReturn();
				break;
			case 9:
				System.out.println("Exit menu..");
				break;
			default:
				System.out.println("Invalid Number");
			}
		}while(choice != 9);

		ClearFiles();
		WriteFiles();

	}
}
