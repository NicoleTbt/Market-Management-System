import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Methods {

	static FileManip Hemployee = new FileManip("Hemployee.txt");
	static FileManip Femployee = new FileManip("Femployee.txt");
	static FileManip Supplier = new FileManip("Supplier.txt");
	static FileManip Purchase = new FileManip("Purchase.txt");
	static FileManip Products = new FileManip("Product.txt");
	static FileManip Category = new FileManip("Category.txt");
	static FileManip Accounting = new FileManip("Accounting.txt");
	static FileManip Sold = new FileManip("Sold.txt");
	static FileManip Return = new FileManip("Return.txt");

	static ArrayList<Hourly_Emp> hemployeeList = new ArrayList<Hourly_Emp>();
	static ArrayList<Fixed_Emp> femployeeList = new ArrayList<Fixed_Emp>();
	static ArrayList<Product> prodList = new ArrayList<Product>();
	static ArrayList<Product_Category> categList=new ArrayList<Product_Category>();
	static ArrayList<Supplier> suppliersList = new ArrayList<Supplier>();
	static ArrayList<Purchase> purchases = new ArrayList<Purchase>();
	static ArrayList<Accounting> accList = new ArrayList<Accounting>();
	static ArrayList<Sold> soldList = new ArrayList<Sold>();
	static ArrayList<Return> returnList = new ArrayList<Return>();
	
	public static void ReadFiles() {
		femployeeList = Femployee.readFempFile();
		hemployeeList = Hemployee.readHempFile();
		suppliersList = Supplier.readSupFile();
		categList = Category.readCatFile();
		prodList = Products.readPrdFile();
		accList = Accounting.readAccFile();
		purchases = Purchase.readPurFile(accList, prodList);
		soldList = Sold.readSoldFile(accList, prodList);
		returnList = Return.readRetFile(accList, prodList);
	}
	
	public static void ClearFiles() {
		Femployee.clearCSVFile();
		Hemployee.clearCSVFile();
		Supplier.clearCSVFile();
		Category.clearCSVFile();
		Products.clearCSVFile();
		Accounting.clearCSVFile();
		Purchase.clearCSVFile();
		Sold.clearCSVFile();
		Return.clearCSVFile();
	}
	
	public static void WriteFiles() {
		for(Hourly_Emp hemp : hemployeeList) {
			try {
				hemp.HEmpwriteFile(Hemployee);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		for(Fixed_Emp femp : femployeeList) {
			try {
				femp.FEmpwriteFile(Femployee);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		for(Supplier sup : suppliersList) {
			try {
				sup.SupwriteFile(Supplier);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		for(Product_Category cat : categList) {
			try {
				cat.CatwriteFile(Category);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		for(Product pr : prodList) {
			try {
				pr.ProdwriteFile(Products);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		for(Accounting acc : accList) {
			try {
				acc.AccwriteFile(Accounting);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		for(Purchase pur : purchases) {
			try {
				pur.PurchwriteFile(Purchase);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		for(Sold s : soldList) {
			try {
				s.SoldwriteFile(Sold);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		for(Return ret : returnList) {
			try {
				ret.RetwriteFile(Return);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void manageProducts() {

		Scanner scan = new Scanner(System.in);
		int choice;

		do {
			System.out.println("Products:");
			System.out.println("1) Add a new Product");
			System.out.println("2) Search for a Product");
			System.out.println("3) Update a Product's information");
			System.out.println("4) Delete a Product");
			System.out.println("5) Display the list of Product");
			System.out.println("6) Return to previous menu");

			choice = scan.nextInt();

			switch (choice) {
			case 1:
				addProduct();
				break;
			case 2:
				searchProduct();
				break;
			case 3:
				updateProduct();
				break;
			case 4:
				deleteProduct();
				break;
			case 5:
				displayProduct();
				break;
			case 6:
				System.out.println("Returning to previous menu...");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (choice != 6);
	}

	public static void manageCategory() {
		Scanner scan = new Scanner(System.in);
		int choice;

		do {
			System.out.println("Products Categories:");
			System.out.println("1) Add a new Category");
			System.out.println("2) Search for a Category");
			System.out.println("3) Update a Category's information");
			System.out.println("4) Delete a Category");
			System.out.println("5) Display Products in the Category");
			System.out.println("6) Return to previous menu");

			choice = scan.nextInt();

			switch (choice) {
			case 1:
				addCategory();
				break;
			case 2:
				searchCategory();
				break;
			case 3:
				updateCategory();
				break;
			case 4:
				deleteCategory();
				break;
			case 5:
				displayCategoryProduct();
				break;
			case 6:
				System.out.println("Returning to previous menu...");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (choice != 6);
	}

	public static void manageAccounting() {
		Scanner scan = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Accounting:");
			System.out.println("1) Create new Accounting report");
			System.out.println("2) Update Accounting report's information");
			System.out.println("3) Make a payment");
			System.out.println("4) Display the Accounting Properties");
			System.out.println("5) Return to previous menu");

			choice = scan.nextInt();

			switch (choice) {
			case 1:
				addAccount();
				break;
			case 2:
				updateAccount();
				break;
			case 3:
				AddPayment();
				break;
			case 4:
				displayAccInf();
				break;
			case 5:
				System.out.println("Returning to previous menu...");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (choice != 5);
	}



	public static void manageEmployee() {
		Scanner scan = new Scanner(System.in);
		int choose;

		do {
			System.out.println("\nEmployees:");
			System.out.println("1) Add a new employee");
			System.out.println("2) Search for an employee");
			System.out.println("3) Update an employee's information");
			System.out.println("4) Delete an employee");
			System.out.println("5) Display the list of employees");
			System.out.println("6) Return to previous menu");

			choose = scan.nextInt();

			switch (choose) {
			case 1:
				addEmployee();
				break;
			case 2:
				searchEmployee();
				break;
			case 3:
				updateEmployee();
				break;
			case 4:
				deleteEmployee();
				break;
			case 5:
				displayEmployeeList();
				break;
			case 6:
				System.out.println("Returning to previous menu...");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (choose != 6);
	}
	public static void manageSupplier() {
		Scanner scan = new Scanner(System.in);

		int choose;

		do {
			System.out.println("\nSupplier:");
			System.out.println("1) Add a new supplier");
			System.out.println("2) Search for a supplier");
			System.out.println("3) Update a supplier's information");
			System.out.println("4) Delete a supplier");
			System.out.println("5) Display the list of suppliers");
			System.out.println("6) Return to previous menu");

			choose = scan.nextInt();

			switch (choose) {
			case 1:
				addSupplier();
				break;
			case 2:
				searchSupplier();
				break;
			case 3:
				updateSupplier();
				break;
			case 4:
				deleteSupplier();
				break;
			case 5:
				displaySupplierList();
				break;
			case 6:
				System.out.println("Returning to previous menu...");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		}while(choose != 6);
	}

	public static void managePurchase() {
		Scanner scan = new Scanner(System.in);

		int choose;

		do {
			System.out.println("\nPurchases:");
			System.out.println("1) Add a new purchase");
			System.out.println("2) Search for purchases by supplier ID");
			System.out.println("3) Update purchase information");
			System.out.println("4) Delete a purchase");
			System.out.println("5) Display the list of purchases");
			System.out.println("6) Return to previous menu");

			choose = scan.nextInt();

			switch (choose) {
			case 1:
				addPurchase();
				break;
			case 2:
				searchPurchase();
				break;
			case 3:
				updatePurchase();
				break;
			case 4:
				deletePurchase();
				break;
			case 5:
				DisplayPurchaseList();
				break;
			case 6:
				System.out.println("Returning to previous menu...");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (choose != 6);
	}

	public static void manageReturn() {
		Scanner scan = new Scanner(System.in);

		int choose;

		do {
			System.out.println("\nReturn:");
			System.out.println("1) Add a new Return");
			System.out.println("2) Search for Return by ID");
			System.out.println("3) Delete a Return");
			System.out.println("4) Display the list of Returns");
			System.out.println("5) Return to previous menu");

			choose = scan.nextInt();

			switch (choose) {
			case 1:
				addReturn();
				break;
			case 2:
				searchReturn();
				break;
			case 3:
				deleteReturn();
				break;
			case 4:
				DisplayReturnList();
				break;
			case 5:
				System.out.println("Returning to previous menu...");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (choose != 5);
	}

	public static void manageSales() {
		Scanner scan = new Scanner(System.in);

		int choose;

		do {
			System.out.println("\nSales:");
			System.out.println("1) Add a new Sale");
			System.out.println("2) Search for Sale by ID");
			System.out.println("3) Delete a Sale");
			System.out.println("4) Display the list of Sales");
			System.out.println("5) Return to previous menu");

			choose = scan.nextInt();

			switch (choose) {
			case 1:
				addSold();
				break;
			case 2:
				searchSold();
				break;
			case 3:
				deleteSold();
				break;
			case 4:
				DisplaySoldList();
				break;
			case 5:
				System.out.println("Returning to previous menu...");
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		} while (choose != 5);
	}

	//...........................METHODS............................//



	public static void addProduct() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Adding a new Product:");

		System.out.print("Enter by order Product Barcode , Supplier ID and Price: ");
		String barcode = scan.next();  String supid = scan.next(); double price = scan.nextDouble(); 
		boolean  ch1=true , ch2=false;

		for (Product pr : prodList) {
			if(pr.getBarCode().equals(barcode)) {
				ch1=false;
			}
		}

		for (Supplier sup: suppliersList) {
			if(sup.getSupID().equals(supid)) {
				ch2=true;
			}
		}
		if(ch1==true && ch2==true) {
			System.out.print("Enter the category ID of the product: ");
			int caid = scan.nextInt();
			Product_Category cat;
			boolean check=false;

			for (Product_Category ct : categList) {
				if (ct.getCatID()==caid) {
					cat=ct;
					Product pr= new Product(barcode, supid,cat , price);
					check=true;
					prodList.add(pr);
					AddToCat(pr.getCategory(),pr);
					System.out.println("Product added successfully.");
				}
			}
			if(check==false)System.out.println("Category with ID " + caid+ " was not found! Product cannot be created!");
		}else System.out.println("!Wrong Information Entered!");
	}

	public static void searchProduct() {
		Scanner scan = new Scanner(System.in);

		System.out.println("\nSearching for Product:");

		System.out.print("Enter Product Barcode: ");
		String bcode = scan.next();
		boolean check=false;

		for (Product pr : prodList) {
			if (pr.getBarCode().equals(bcode)) {
				System.out.println(pr.toString());
				check=true;}
		}

		if(check==false) 
			System.out.println("Product not found.");		
	}


	public static void updateProduct() {
		Scanner scan = new Scanner(System.in);

		int choice;
		System.out.println("\nUpdating Product:");

		System.out.print("Enter Product Barcode: ");
		String bcode = scan.next();
		boolean check=false;

		for (Product pr : prodList) {
			if (pr.getBarCode().equals(bcode)) {
				do {
					System.out.println("1)Change Product Barcode"

							+ "\n2)Change Product Supplier"
							+ "\n3)Change Product Price"
							+ "\n4)Change Product Category"
							+ "\n5)Exit");
					choice = scan.nextInt();

					switch(choice) {
					case 1:
						System.out.print("Enter new Barcode: ");
						String bc = scan.next(); 
						boolean  ch=true;

						for (Product prd :prodList) {
							if(pr.getBarCode().equals(bc)) {
								ch=false;
							}
						}

						if(ch==true)pr.setBarCode(bc);
						else System.out.println("Barcode Already Used!!");

						break;
					case 2:
						System.out.print("Enter new Supplier ID: ");
						String supid = scan.next();
						boolean ch1=false;
						for (Supplier sup: suppliersList) {
							if(sup.getSupID().equals(supid)) {
								ch1=true;
							}
						}
						if(ch1==true)pr.setSupID(supid);
						else  System.out.println("Supplier not found!!");
						break;
					case 3:
						System.out.print("Enter new Price: ");
						double pri = scan.nextDouble();
						if(pri>0) {
							pr.setPrice(pri);
						}else System.out.println("Price not valid!");
						break;
					case 4:
						System.out.print("Enter new Category ID: ");
						int caid = scan.nextInt();
						boolean che=false;

						for (Product_Category ct : categList) {
							if (ct.getCatID()==caid) {
								DeleteFromCat(pr.getCategory(), pr);
								Product_Category cat=ct;
								pr.setCategory(cat);
								AddToCat(pr.getCategory(),pr);
								che=true;
							}
							if(che==false)System.out.println("Category with ID" + caid+ " was not found! Product cannot be updated!");
						}
						break;

					default:
						System.out.println("Option not available!");
					}
				}while (choice!=5);
				check=true;
			}
		}
		if (check==false) System.out.println("Product not found.");
	}

	//deleting adding to category//
	public static void AddToCat (Product_Category PC, Product P) {
		PC.getCatProdList().add(P);
	}
	public static void DeleteFromCat (Product_Category PC,Product P) {
		PC.getCatProdList().remove(P);
	}
	//

	public static void deleteProduct() {
		Scanner scan = new Scanner(System.in);

		System.out.println("\nDeleting Product:");

		System.out.print("Enter Product Barcode: ");
		String bc = scan.next();
		boolean check=false;

		for (Product pr : prodList) {
			if (pr.getBarCode().equals(bc)) {
				DeleteFromCat (pr.getCategory(),pr);
				prodList.remove(pr);
				check=true;
				System.out.println("Product with Barcode" + bc + " has been deleted.");
			}
		}
		if(check==false)System.out.println("Product with Barcode" + bc + " was not found in the list.");
	}


	public static void displayProduct() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nList of Product:");
		System.out.println("------------------");

		for (Product pr : prodList) {
			System.out.println(pr.toString());
		}
	}

	//Category//
	public static void addCategory() {
		Scanner scan = new Scanner(System.in);

		System.out.println("\nAdding a new Category:");

		System.out.print("Enter by order Category ID number and Description: ");
		int caid = scan.nextInt();  String desc = scan.next(); 
		boolean check=true;

		for (Product_Category ctpr : categList) {
			if (ctpr.getCatID()==caid) {
				check=false;
			}
		}
		if(check==true) {
			Product_Category ctg= new Product_Category(caid,desc);
			categList.add(ctg);
			System.out.println("Category added successfully.");}
		else System.out.println("Category ID Used!");
	}

	public static void searchCategory() {
		Scanner scan = new Scanner(System.in);

		System.out.println("\nSearching for Category:");

		System.out.print("Enter Category ID number: ");
		int caid = scan.nextInt();
		boolean check=false;

		for (Product_Category ctpr : categList) {
			if (ctpr.getCatID()==caid) {
				System.out.println(ctpr.toString());
				check=true;}
		}

		if(check==false) 
			System.out.println("Category not found.");		
	}

	public static void updateCategory() {
		Scanner scan = new Scanner(System.in);

		int choice;
		System.out.println("\nUpdating Category:");

		System.out.print("Enter Category ID number: ");
		int caid = scan.nextInt();
		boolean check=false;

		for (Product_Category ctpr : categList) {
			if (ctpr.getCatID()==caid) {
				do {
					System.out.println("1)Change Category ID"
							+ "\n2)Change Category Description"
							+ "\n3)Exit");
					choice = scan.nextInt();

					switch(choice) {
					case 1:
						System.out.print("Enter new ID number: ");
						int ncaid = scan.nextInt(); 
						boolean ch1=true;

						for (Product_Category ctp : categList) {
							if (ctp.getCatID()==ncaid) {
								ch1=false;
							}
						}
						if(check==true) {ctpr.setCatID(ncaid);}
						else System.out.println("Category ID Used!");

						break;
					case 2:
						System.out.print("Enter new Description: ");
						String desc = scan.next();
						ctpr.setDescription(desc);
						break;
					default:
						System.out.println("Option not available!");
					}

					System.out.println("Category updated successfully.");
				}while (choice!=3);
				check=true;
			}
		}
		if (check==false) System.out.println("Category not found.");
	}

	public static void deleteCategory() {
		Scanner scan = new Scanner(System.in);

		System.out.println("\nDeleting Category:");

		System.out.print("Enter Category ID number: ");
		int caid = scan.nextInt();
		boolean check=false;


		for (Product_Category ctpr : categList) {
			if (ctpr.getCatID()==caid) {
				prodList.remove(ctpr);
				check=true;
				System.out.println("Category with ID" + caid + " has been deleted.");
			}
		}
		if(check==false)System.out.println("Category with ID" + caid+ " was not found in the list.");
	}


	public static void displayCategoryProduct() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter Category ID number: ");
		int caid = scan.nextInt();
		Product_Category catdisp;
		boolean check=false;

		for (Product_Category ctpr : categList) {
			if (ctpr.getCatID()==caid) {
				catdisp=ctpr;

				System.out.println("\nList of Product in the Category:");
				System.out.println("------------------");
				for (Product pr : catdisp.getCatProdList()) {
					System.out.println(pr.toString());
				}
			}
		}
		if(check==false)System.out.println("Category with ID" + caid+ " was not found in the list.");
	}


	public static void addEmployee() {
		Scanner scan = new Scanner(System.in);

		System.out.println("\nAdding a new employee:");

		System.out.println("Is he an hourly or fixed employee? (h/f)");
		char type = scan.next().charAt(0);

		if(type == 'h') {
			System.out.print("Enter by order employee first name, last name, ID,  address and telephone number: ");
			String fname = scan.next();  String lname = scan.next(); String id = scan.next(); String address = scan.next(); String tel = scan.next();

			System.out.print("Enter employee speciality and pay rate: ");
			String spec = scan.next();	double payRate = scan.nextDouble();
			boolean ch=true;
			for(Hourly_Emp hemp: hemployeeList) {
				if(hemp.getNationalID().equals(id)) {
					ch=false;
				}
			}

			if(ch=true) {
				Hourly_Emp emp = new Hourly_Emp(fname, lname, id, address, tel, spec, payRate);
				hemployeeList.add(emp);
				System.out.println("Hourly Employee added successfully.");}
			else System.out.println("Employee National ID already used! This Employee cannot be created!");

		}else {
			System.out.print("Enter by order employee first name, last name, ID,  address and telephone number: ");
			String fname = scan.next();  String lname = scan.next(); String id = scan.next(); String address = scan.next(); String tel = scan.next();

			System.out.print("Enter employee speciality and monthly pay: ");
			String spec = scan.next(); double monthlyPay=scan.nextDouble();
			boolean ch=true;
			for(Fixed_Emp femp: femployeeList) {
				if(femp.getNationalID().equals(id)) {
					ch=false;
				}
			}

			if(ch=true) {
				Fixed_Emp emp = new Fixed_Emp(fname, lname, id, address, tel, spec, monthlyPay);
				femployeeList.add(emp);
				System.out.println("Fixed Employee added successfully.");}
			else System.out.println("Employee National ID already used!");
		}
	}


	public static void searchEmployee() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Is he an hourly or fixed employee? (h/f)");
		char type = scan.next().charAt(0);

		if(type == 'h') {
			System.out.println("\nSearching for an employee:");

			System.out.print("Enter employee ID: ");
			String id = scan.next();
			boolean check=false;

			for (Hourly_Emp emp : hemployeeList) {
				if (emp.getNationalID().equals(id)) {
					System.out.println(emp.toString());
					check=true;}
			}
			if(check==false) {
				System.out.println("Employee not found.");
			}

		}
		else {
			System.out.println("\nSearching for an employee:");

			System.out.print("Enter employee ID: ");
			String id = scan.next();
			boolean check=false;

			for (Fixed_Emp emp : femployeeList) {
				if (emp.getNationalID().equals(id)) {
					System.out.println(emp.toString());
					check=true;}
			}
			if(check==false) {
				System.out.println("Employee not found.");
			}
		}
	}

	public static void updateEmployee() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Is he an hourly or fixed employee? (h/f)");
		char type = scan.next().charAt(0);

		if(type == 'h') {
			int choice;
			System.out.println("\nUpdating an employee:");

			System.out.print("Enter employee ID: ");
			String id = scan.next();
			boolean check=false;

			for (Hourly_Emp emp : hemployeeList) {
				if (emp.getNationalID().equals(id)) {
					do {
						System.out.println("1)Change employee name"

							+ "\n2)Change employee Address"
							+ "\n3)Change employee Telephone number"
							+ "\n4)Change employee Specialty"
							+ "\n5)Change employee Pay Rate"
							+ "\n6)Change employee Work Hours"
							+ "\n7)Exit");
						choice = scan.nextInt();

						switch(choice) {
						case 1:
							System.out.print("Enter new first name and last name: ");
							String fname = scan.next(); String lname = scan.next();
							emp.setFirstName(fname); emp.setLastName(lname);
							break;
						case 2:
							System.out.print("Enter new address: ");
							String address = scan.next();
							emp.setAddress(address);
							break;
						case 3:
							System.out.print("Enter new Telephone number: ");
							String Tel = scan.next();
							emp.setTel(Tel);
							break;
						case 4:
							System.out.print("Enter new speciality: ");
							String spec = scan.next();
							emp.setSpecialty(spec);							
							break;
						case 5:
							System.out.print("Enter new pay rate: ");
							double payRate = scan.nextDouble();
							emp.setPay_Rate(payRate);
							break;
						case 6 :
							System.out.print("Enter new work hours: ");
							double workHours = scan.nextDouble();
							emp.setWork_Hours(workHours);
							break;
						default:
							System.out.println("Option not available!");
						}

						System.out.println("Employee updated successfully.");
					}while (choice!=7);
					check=true;
				}
			}
			if (check==false) System.out.println("Employee not found.");
		}
		else {
			int choice;
			System.out.println("\nUpdating an employee:");

			System.out.print("Enter employee ID: ");
			String id = scan.next();
			boolean check=false;

			for (Fixed_Emp emp : femployeeList) {
				if (emp.getNationalID().equals(id)) {
					do {
						System.out.println("1)Change employee name"

							+ "\n2)Change employee Address"
							+ "\n3)Change employee Telephone number"
							+ "\n4)Change employee Specialty"
							+ "\n5)Change employee Monthly salary"
							+ "\n7)Exit");
						choice = scan.nextInt();

						switch(choice) {
						case 1:
							System.out.print("Enter new first name and last name: ");
							String fname = scan.next(); String lname = scan.next();
							emp.setFirstName(fname); emp.setLastName(lname);
							break;
						case 2:
							System.out.print("Enter new address: ");
							String address = scan.next();
							emp.setAddress(address);
							break;
						case 3:
							System.out.print("Enter new Telephone number: ");
							String Tel = scan.next();
							emp.setTel(Tel);
							break;
						case 4:
							System.out.print("Enter new speciality: ");
							String spec = scan.next();
							emp.setSpecialty(spec);
							break;
						case 5:
							System.out.print("Enter new Monthly Salary: ");
							double mpay = scan.nextDouble();
							emp.setMonthly_Pay(mpay);
							break;
						default:
							System.out.println("Option not available!");
						}

						System.out.println("Employee updated successfully.");
					}while (choice!=6);
					check=true;
				}
			}
			if (check==false) System.out.println("Employee not found.");
		}
	}

	public static void deleteEmployee() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Is he an hourly or fixed employee? (h/f)");
		char type = scan.next().charAt(0);

		if(type == 'h') {

			System.out.println("\nDeleting an employee:");

			System.out.print("Enter employee ID: ");
			String id = scan.next();
			boolean check=false;

			for (Hourly_Emp emp : hemployeeList) {
				if (emp.getNationalID().equals(id)) {
					hemployeeList.remove(emp);
					check=true;
					System.out.println("Employee with ID " + id + " has been deleted.");
				}
			}
			if(check==false)System.out.println("Employee with ID " + id + " was not found in the list.");
		}
		else {
			System.out.println("\nDeleting an employee:");

			System.out.print("Enter employee ID: ");
			String id = scan.next();
			boolean check=false;

			for (Fixed_Emp emp : femployeeList) {
				if (emp.getNationalID().equals(id)) {
					femployeeList.remove(emp);
					check=true;
					System.out.println("Employee with ID " + id + " has been deleted.");
				}
			}
			if(check==false)System.out.println("Employee with ID " + id + " was not found in the list.");
		}
	}

	public static void displayEmployeeList() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Is he an hourly or fixed employee? (h/f)");
		char type = scan.next().charAt(0);

		if(type == 'h') {
			System.out.println("\nList of Employees:");
			System.out.println("------------------");

			for (Hourly_Emp emp : hemployeeList) {
				System.out.println(emp.toString());
			}
		}
		else {
			System.out.println("\nList of Employees:");
			System.out.println("------------------");

			for (Fixed_Emp emp : femployeeList) {
				System.out.println(emp.toString());
			}
		}
	}

	public static void addSupplier() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Adding New Supplier");
		System.out.print("Enter Supplier ID, Name, Address and Telephone: ");
		String supID = scan.next(); String supName = scan.next(); String supAddress = scan.next(); String supTel = scan.next();
		boolean check = true;
		for (Supplier supplier : suppliersList) {
			if (supplier.getSupID().equals(supID)) {
				check=false;
				break;
			} }
		if(check==true) {
			Supplier supplier = new Supplier(supID, supName, supAddress, supTel);
			suppliersList.add(supplier);
			System.out.println("Supplier added successfully.");}
		else System.out.println("Supplier ID already in Use! This Supplier cannot be created!");
	}

	public static void searchSupplier() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Searching for a Supplier");
		System.out.print("Enter Supplier ID: ");
		String supID = scan.next();

		boolean check = false;
		for (Supplier supplier : suppliersList) {
			if (supplier.getSupID().equals(supID)) {
				System.out.println(supplier.toString());
				check = true;
				return;
			}
		}
		if(check == false) {
			System.out.println("Supplier with ID " + supID + " not found.");
		}
	}

	public static void updateSupplier() {
		Scanner scan = new Scanner(System.in);
		int choice;
		System.out.println("\nUpdating a supplier:");

		System.out.print("Enter Supplier ID: ");
		String id = scan.next();
		boolean check=false;

		for (Supplier sup : suppliersList) {
			if (sup.getSupID().equals(id)) {
				do {
					System.out.println("1)Change Supplier name"
							+ "\n2)Change Supplier Address"
							+ "\n3)Change Supplier Telephone number"
							+ "\n4)Exit");
					choice = scan.nextInt();

					switch(choice) {
					case 1:
						System.out.print("Enter new name: ");
						String name = scan.next();
						sup.setSupName(name);
						break;
					case 2:
						System.out.print("Enter new address: ");
						String address = scan.next();
						sup.setSupAddress(address);
						break;
					case 3:
						System.out.print("Enter new Telephone number: ");
						String Tel = scan.next();
						sup.setSupTel(Tel);
						break;
					default:
						System.out.println("Option not available!");
					}

					System.out.println("Supplier updated successfully.");
				}while (choice != 4);
				check=true;
			}
		}
		if (check==false) System.out.println("Supplier not found.");
	}

	public static void deleteSupplier() {
		Scanner scan = new Scanner(System.in);

		System.out.println("\nDeleting a supplier:");

		System.out.print("Enter supplier ID: ");
		String id = scan.next();
		boolean check=false;

		for (Supplier sup : suppliersList) {
			if (sup.getSupID().equals(id)) {
				suppliersList.remove(sup);
				check=true;
				System.out.println("Supplier with ID " + id + " has been deleted.");
				break;
			}
		}
		if(check==false)System.out.println("Supplier with ID " + id + " was not found in the list.");
	}

	public static void displaySupplierList() {
		System.out.println("\nList of Suppliers:");
		System.out.println("------------------");

		for (Supplier sup : suppliersList) {
			System.out.println(sup.toString());
		}
	}

	public static void addAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.println("\nAdding a new addAccount:");

		System.out.print("Enter by order Account ID and Date: ");
		String acid = scan.next();  String dt = scan.next(); 
		boolean check=true;

		for (Accounting acc : accList) {
			if (acc.getAccount_ID().equals(acid)) {
				check=false;
			}
		}
		if(check==true) {
			Accounting acc = new Accounting (acid , dt);
			accList.add(acc);
			System.out.println("Account added successfully.");}
		else System.out.println("Account ID already in use! This Account cannot be created!");
	}

	public static void updateAccount() {
		Scanner scan = new Scanner(System.in);

		int choice;
		System.out.println("\nUpdating Account:");

		System.out.print("Enter Account ID: ");
		String acid = scan.next();
		boolean check=false;

		for (Accounting acc : accList) {
			if (acc.getAccount_ID().equals(acid)) {
				do {
					System.out.println("1)Change Account Date"
							+ "\n2)Exit");
					choice = scan.nextInt();

					switch(choice) {
					case 1:
						System.out.print("Enter new Account Date: ");
						String nd = scan.next();
						acc.setDate(nd);
						break;
					case 2:
						System.out.println("Returning to previous menu...");
						break;
					default:
						System.out.println("Option not available!");
					}

					System.out.println("Account updated successfully.");
				}while (choice!=2);
				check=true;
			}
		}
		if (check==false) System.out.println("Account not found.");
	}

	public static void displayAccInf() {
		Scanner scan = new Scanner(System.in);
		int choice;
		System.out.println("\nAccounting Report Details:");

		System.out.print("Enter Account ID: ");
		String acid = scan.next();
		boolean check=false;

		for (Accounting acc : accList) {
			if (acc.getAccount_ID().equals(acid)) {
				check=true;
				System.out.println(acc.toString());
			}
		}
		if (check==false) System.out.println("Account not found.");

	}
	public static void AddPayment() {
		Scanner scan = new Scanner(System.in);
		int choice;
		System.out.println("\nAccounting Report Details:");

		System.out.print("Enter Account ID: ");
		String acid = scan.next();
		boolean check=false;

		for (Accounting acc : accList) {
			if (acc.getAccount_ID().equals(acid)) {
				System.out.println(acc.toString());

				System.out.print("Enter Ammount to pay: ");
				double pay=scan.nextDouble();
				acc.Payments(pay);
				System.out.print("Payment Done!");
			}
		}
		if (check==false) System.out.println("Account not found.");

	}


	public static void addPurchase() {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the purchase ID, supplier id:");
		String pID = scan.next(); String sID = scan.next(); 
		boolean check = false, check2=true;
		for (Supplier supplier : suppliersList) {
			if (supplier.getSupID().equals(sID)) {
				check = true;
				break;
			}
		}
		for (Purchase purchase : purchases) {
			if (purchase.getSupID().equals(pID)) {
				check2 = false;
				break;
			}
		}
		int choice2;
		boolean check3=false;

		if(check==true && check2==true) {
			Accounting acc = null;
			System.out.print("Enter the Accounting report ID");
			String aID = scan.next();

			for(int i=0; i<accList.size(); i++) {
				if(accList.get(i).getAccount_ID().equals(aID)) {
					acc = accList.get(i);
					check3=true;
					break;
				}
			}

			if(check3 == true) {
				Purchase pr = new Purchase(pID, sID, acc);
				do {
					System.out.println("1)Update Purchase List"
							+ "\n2)Exit");
					choice2 = scan.nextInt();
					switch(choice2) {
					case 1:
						System.out.print("Do you want to Add to Purchase (1)Or Delete from it (2)");
						int subch=scan.nextInt();
						if(subch==1) {
							System.out.print("Enter Product Barcode and the number of items purchased");
							String bc =scan.next(); int itp=scan.nextInt();
							for(Product prd : prodList) {
								if(prd.BarCode.equals(bc)) {
									if(prd.getSupID().equals(sID)) {
										pr.AddPurProduct(prd, itp);
										System.out.println("Product added succesfuly");
										break;
										}else System.out.println("The specified supplier does not offer this product.");
								}
							}
							purchases.add(pr);
						}
						else if(subch==2) {
							System.out.print("Enter Product Barcode to delete");
							String bcd =scan.next(); 
							boolean ch1=false, ch2=false;
							
							for(Product prd:prodList) {
								if(prd.BarCode.equals(bcd)) {
									ch1=true;
									if(prd.getSupID().equals(sID)) {
										ch2=true;
										pr.DelPurProduct(prd);
										System.out.println("Product deleted succesfuly");
										break;
									}
									break;
								}
							}
							
							if(ch2==false) System.out.println("The specified supplier does not offer this product!");
							if(ch1==false) System.out.println("The specified Barcode does not exist!");
						}else System.out.println("Invalid option!");
						break;
					case 2:
						System.out.println("Exiting..");
						break;
					default:
						System.out.println("Option not available!");
					}	
				} while(choice2 != 2);

				pr.CalcTotal(); pr.AddStock();pr.AddAcoounting();
			}else System.out.print("Accounting report not Found!\nPurchase cannot be created!");
		} else System.out.print("Credentials purchase ID or Supplier ID are wrong!\nPurchase cannot be created!");

	}

	public static void searchPurchase() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the supplier ID: ");
		String searchSupID = scan.next();
		boolean found = false;
		for (Purchase purchase : purchases) {
			if (purchase.getSupID().equals(searchSupID)) {
				System.out.println(purchase.DisplayInv());
				found = true;
				break;
			}
		}
		if (found == false) {
			System.out.println("No purchases found for specified supplier ID.");
		}
	}

	public static void updatePurchase() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter purchase ID to update:");
		String updatePurID = scan.next();

		boolean found = false;
		int choice;
		for (Purchase purchase : purchases) {
			if (purchase.getPurID().equals(updatePurID)) {
				do {
					System.out.println("1)Change purchase date"
							+ "\n2)Change supplier ID"
							+ "\n3)Exit");
					choice = scan.nextInt();

					switch(choice) {
					case 1:
						System.out.print("Enter new purchase date: ");
						String date = scan.next();
						date = new SimpleDateFormat("yyyy_MM_dd").format(Calendar.getInstance().getTime());
						purchase.setDate(date);
						break;
					case 2:
						System.out.print("Enter new supplier ID: ");
						String supID = scan.next();
						purchase.setSupID(supID);
						break;
					default:
						System.out.println("Option not available!");
					}

					System.out.println("Purchase updated successfully.");
				}while (choice != 2);
				found = true;
			}
		}
		if (found==false) System.out.println("Purchase not found.");	
	}

	public static void deletePurchase() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter purchase ID to delete:");
		String id = scan.nextLine();
		boolean deleted = false;
		for (Purchase pr:purchases) {
			if (pr.getPurID().equals(id)) {
				pr.DeleteStock();
				pr.DeleteAcoounting();
				purchases.remove(pr);
				deleted = true;
				System.out.println("Purchase deleted successfully.");
				break;
			}
		}
		if (!deleted) {
			System.out.println("No purchase found for specified purchase ID.");
		}
	}

	public static void DisplayPurchaseList() {
		if (purchases.size() == 0) {
			System.out.println("No purchases found.");
		} else {
			System.out.println("List of all purchases:");
			for (Purchase purchase : purchases) {
				System.out.println(purchase.DisplayInv());
			}
		}
	}

	public static void addSold() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Accounting report ID");
		String aID = scan.next();
		boolean check=false;
		int choice;
		for(int i=0; i<accList.size(); i++) {
			if(accList.get(i).getAccount_ID().equals(aID)) {
				Accounting acc=accList.get(i);
				check=true;
				Sold sl = new Sold(acc);
				do {
					System.out.println("1)Add Product to the Sale"
							+ "\n2)Delete Product from Sale"
							+ "\n3)Exit");
					choice = scan.nextInt();
					switch(choice) {
					case 1:
						System.out.print("Enter Product Barcode and the number of items Sold");
						String bc=scan.next(); int itp=scan.nextInt();
						boolean ch=false;
						for(Product prd:prodList) {
							if(prd.BarCode.equals(bc)) {
								ch=true;
								sl.AddSoldProduct(prd, itp);
								break;
							}
						}
						if(ch==false)System.out.print("The Barcode given does not exist!");
						else System.out.print("Product added to the sale.");
						soldList.add(sl);
						break;
					case 2:
						System.out.print("Enter Product Barcode to delete");
						String bcd =scan.next(); 
						for(Product prd:prodList) {
							if(prd.BarCode.equals(bcd)) {
								sl.DelSoldProduct(prd);
								break;
							}
						}
						break;
					case 3:
						System.out.println("Exit..");
						break;
					default:
						System.out.println("Option not available!");
					} 
				} while(choice!=3);

				sl.CalcTotal(); sl.AddStock();sl.AddAcoounting();
				break;
			}
		}
		if(check==false)System.out.print("Accounting report not Found!\nPurchase cannot be created!");
	}

	public static void searchSold() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Sale ID: ");
		String said = scan.next();
		boolean found = false;
		for (Sold sl : soldList) {
			if (sl.getSoID().equals(said)) {
				System.out.println(sl.DisplayInv());
				found = true;
			}
		}
		if (!found) {
			System.out.println("No Sale found for specified supplier ID.");
		}
	}

	public static void deleteSold() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter Sale ID to delete:");
		String said = scan.nextLine();
		boolean deleted = false;
		for (Sold sl:soldList) {
			if (sl.getSoID().equals(said)) {
				sl.DeleteStock();
				sl.DeleteAcoounting();
				soldList.remove(sl);
				deleted = true;
				System.out.println("Sale deleted successfully.");
				break;
			}
		}
		if (!deleted) {
			System.out.println("No purchase found for specified purchase ID.");
		}
	}

	public static void DisplaySoldList() {
		if (soldList.size() == 0) {
			System.out.println("No Sales found.");
		} else {
			System.out.println("List of all Sales:");
			for (Sold sl : soldList) {
				System.out.println(sl.DisplayInv());
			}
		}
	}


	public static void addReturn() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Accounting report ID: ");
		String aID = scan.next();
		boolean check=true, ch2=false, ch3=false;
		System.out.print("Enter the return ID , Product Barcode and the number of items Returned: ");
		String id=scan.next(); String bc=scan.next(); int itr=scan.nextInt();
		for(Return ret:returnList) {
			if(ret.getRetID().equals(id)) {
				check=false; break;}}

		for(Accounting acc :accList) {
			if(acc.getAccount_ID().equals(aID)) {
				for(Product prd:prodList) {
					if(prd.BarCode.equals(bc)) {
						Return rt=new Return(id,prd,itr,acc);
						returnList.add(rt);
						rt.CalcTotal(); rt.AddStock();rt.AddAcoounting();
						ch3=true;
						break;
					}
				}
				ch2=true;
				break;
			}
		}

		if(check==false)System.out.print("ID already used!\nReturn cannot be created!");
		if(ch2==false)System.out.print("Accounting report not found!\nReturn cannot be created!");
		if(ch3==false)System.out.print("Product not found!\nReturn cannot be created!");
	}

	public static void searchReturn() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Return ID: ");
		String reid = scan.next();
		boolean found = false;
		for (Return ret :returnList) {
			if (ret.getRetID().equals(reid)) {
				ret.DisplayReturn();
				found = true;
			}
		}
		if (!found) {
			System.out.println("Return not found for the specified ID!");
		}
	}

	public static void deleteReturn() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Please enter Return ID to delete:");
		String reid = scan.nextLine();
		boolean deleted = false;
		for (Return rt : returnList)  {
			if (rt.getRetID().equals(reid)) {
				rt.DeleteStock();
				rt.DeleteAcoounting();
				soldList.remove(rt);
				deleted = true;
				System.out.println("Return deleted successfully.");
				break;
			}
		}
		
		if (!deleted) {
			System.out.println("No Return found for the specified ID!");
		}
	}

	public static void DisplayReturnList() {
		if (returnList.size() == 0) {
			System.out.println("No Returns found.");
		} else {
			System.out.println("List of all Returns:");
			for (Return rt : returnList) {
				rt.DisplayReturn();
			}
		}
	}

}