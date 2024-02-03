import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManip{

	private String filename;

	public FileManip(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public ArrayList<Fixed_Emp> readFempFile() {
		ArrayList<Fixed_Emp> result = new ArrayList<>();
		try {
			File file = new File(this.filename);
			if (file.length() == 0) {
				System.out.println("File is empty.");
				return result;
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String firstName = line;
				String lastName = reader.readLine();
				String nationalID = reader.readLine();
				String address = reader.readLine();
				String tel = reader.readLine();
				String specialty = reader.readLine();
				double monthlyPay = Double.parseDouble(reader.readLine());
				Fixed_Emp fixedEmp = new Fixed_Emp(firstName, lastName, nationalID, address, tel, specialty, monthlyPay);
				result.add(fixedEmp);
			}
			reader.close();
			System.out.println("File read successfully.");
		} catch (IOException e) {
			System.out.println("Error reading file: " + this.filename);
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Hourly_Emp> readHempFile() {
		ArrayList<Hourly_Emp> result = new ArrayList<>();
		try {
			File file = new File(this.filename);
			if (file.length() == 0) {
				System.out.println("File is empty.");
				return result;
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String firstName = line;
				String lastName = reader.readLine();
				String nationalID = reader.readLine();
				String address = reader.readLine();
				String tel = reader.readLine();
				String specialty = reader.readLine();
				double payRate = Double.parseDouble(reader.readLine());
				Hourly_Emp hourlyEmp = new Hourly_Emp(firstName, lastName, nationalID, address, tel, specialty, payRate);
				result.add(hourlyEmp);
			}
			reader.close();
			System.out.println("File read successfully.");
		} catch (IOException e) {
			System.out.println("Error reading file: " + this.filename);
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Supplier> readSupFile() {
		ArrayList<Supplier> result = new ArrayList<>();
		try {
			if (new File(this.filename).length() == 0) {
			    System.out.println("The file is empty.");
			    return result;
			}
			BufferedReader reader = new BufferedReader(new FileReader(this.filename));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] attributes = line.split("\n");
				String supID = attributes[0];
				line = reader.readLine(); // read next line for supplier name
				String supName = line;
				line = reader.readLine(); // read next line for supplier address
				String supAddress = line;
				line = reader.readLine(); // read next line for supplier telephone
				String supTel = line;
				Supplier supplier = new Supplier(supID, supName, supAddress, supTel);
				result.add(supplier);
			}
			reader.close();
			System.out.println("File read successfully.");
		} catch (IOException e) {
			System.out.println("Error reading file: " + this.filename);
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Accounting> readAccFile() {
		ArrayList<Accounting> result = new ArrayList<>();
		try {
			if (new File(this.filename).length() == 0) {
			    System.out.println("The file is empty.");
			    return result;
			}
			BufferedReader reader = new BufferedReader(new FileReader(this.filename));
			String line;
			while ((line = reader.readLine()) != null) {
				String accId = line;
				String dateStr = reader.readLine();
				double accPayable = Double.parseDouble(reader.readLine());
				double salesMoney = Double.parseDouble(reader.readLine());
				double profit = Double.parseDouble(reader.readLine());
				double paymentMoney = Double.parseDouble(reader.readLine());
				double debt = Double.parseDouble(reader.readLine());
				double payed = Double.parseDouble(reader.readLine());
				Accounting acc = new Accounting(accId, dateStr);
				acc.setAccount_Payable(accPayable);
				acc.setSales_Money(salesMoney);
				acc.setProfit(profit);
				acc.setPayment_Money(paymentMoney);
				acc.setDebt(debt);
				acc.setPayed(payed);
				result.add(acc);
			}
			reader.close();
			System.out.println("File read successfully.");
		} catch (IOException e) {
			System.out.println("Error reading file: " + this.filename);
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Product_Category> readCatFile() {
		ArrayList<Product_Category> result = new ArrayList<>();
		try {
			File file = new File(this.filename);
			if (file.length() == 0) {
				System.out.println("File is empty.");
				return result;
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				int catID = Integer.parseInt(line);
				String description = reader.readLine();
				Product_Category cat = new Product_Category(catID, description);
				result.add(cat);
			}
			reader.close();
			System.out.println("File read successfully.");
		} catch (IOException e) {
			System.out.println("Error reading file: " + this.filename);
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Error parsing integer in file: " + this.filename);
			e.printStackTrace();
		}
		return result;
	}


	public ArrayList<Product> readPrdFile() {
		ArrayList<Product> result = new ArrayList<>();
		try {
			File file = new File(this.filename);
			if (file.length() == 0) {
				System.out.println("File is empty.");
				return result;
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String barCode = line.trim();
				String supID = reader.readLine().trim();
				int catID = Integer.parseInt(reader.readLine().trim());
				double price = Double.parseDouble(reader.readLine().trim());
				int qt = Integer.parseInt(reader.readLine());
				String description = reader.readLine();
				Product_Category c = new Product_Category(catID,description);
				Product pr = new Product(barCode, supID, c, price);
				result.add(pr);
			}
			reader.close();
			System.out.println("File read successfully.");
		} catch (IOException e) {
			System.out.println("Error reading file: " + this.filename);
			e.printStackTrace();
		}
		return result;
	}


	public ArrayList<Return> readRetFile(ArrayList<Accounting> accList, ArrayList<Product> prodList) {
		ArrayList<Return> result = new ArrayList<>();
		try {
			File file = new File(this.filename);
			if (file.length() == 0) {
				System.out.println("File is empty.");
				return result;
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String retID = line;
				String bc = reader.readLine();
				int numOfit = Integer.parseInt(reader.readLine());
				float total = Float.parseFloat(reader.readLine());
				String accID = reader.readLine();

				if(bc != null && accID != null) {
					bc = bc.trim();
					for (Accounting acc : accList) {
						if (acc.getAccount_ID().equals(accID)) {
							for (Product pr : prodList) {
								if (pr.getBarCode().equals(bc)) {
									Return rt = new Return(retID, pr, numOfit, acc);
									rt.CalcTotal();
									rt.AddAcoounting();
									rt.AddStock();
									result.add(rt);
								}
							}
						}
					}
				} else {
					System.out.println("Invalid file format in " + this.filename);
					break;
				}
			}
			reader.close();
			System.out.println("File read successfully.");
		} catch (IOException e) {
			System.out.println("Error reading file: " + this.filename);
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Invalid file format in " + this.filename);
			e.printStackTrace();
		}
		return result;
	}

	public ArrayList<Purchase> readPurFile(ArrayList<Accounting> accList, ArrayList<Product> prodList) {
		ArrayList<Purchase> result = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(this.filename));

			// Check if file is empty
			File file = new File(this.filename);
			if (file.length() == 0) {
				System.out.println("File is empty.");
				return result;
			}
			String line;
			while ((line = reader.readLine()) != null) {
			String purID = line;
			String date = reader.readLine();
			String supID = reader.readLine();
			String accID = reader.readLine();
			int numOfProd = Integer.parseInt(reader.readLine());
			Accounting acc = null;
			for (Accounting a : accList) {
				if (a.getAccount_ID().equals(accID)) {
					acc = a;
					break;
				}
			}
			if (acc == null) {
				System.out.println("Error: Accounting with ID " + accID + " not found.");
				reader.close();
				return result;
			}
			Purchase pur = new Purchase(purID, supID, acc);
			pur.setDate(date);
			String[] prodAttributes = reader.readLine().split(",");
			String[] nbofit = reader.readLine().split(",");
			for (int i = 0; i < numOfProd; i++) {
				String barCode = prodAttributes[i];
				int nbOfIt = Integer.parseInt(nbofit[i]);
				for (Product pr : prodList) {
					if (pr.getBarCode().equals(barCode)) {
						pur.AddPurProduct(pr, nbOfIt);
					}
				}
			}
			pur.CalcTotal();
			pur.AddAcoounting();
			pur.AddStock();
			result.add(pur);
			}
			reader.close();
			System.out.println("File read successfully.");
		} catch (IOException e) {
			System.out.println("Error reading file: " + this.filename);
			e.printStackTrace();
		}
		return result;
	}


	public ArrayList<Sold> readSoldFile(ArrayList<Accounting> accList, ArrayList<Product> prodList) {
		ArrayList<Sold> result = new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(this.filename));
			File file = new File(this.filename);
			if (file.length() == 0) {
				System.out.println("File is empty.");
				return result;
			}
			String line;
			while ((line = reader.readLine()) != null) {
				String soID = line;
				String date = reader.readLine();
				String accID = reader.readLine();
				int numOfProd = Integer.parseInt(reader.readLine());
				if (numOfProd <= 0) { // Check if numOfProd is greater than 0
					throw new IllegalArgumentException("Invalid number of products");
				}
				for (Accounting acc : accList) {
					if (acc.getAccount_ID().equals(accID)) {
						Sold sl = new Sold(acc);
						sl.setDate(date);
						sl.setSoID(soID);
						String line2 = reader.readLine();
						while (line2 != null) {
							String[] prodAttributes = line2.split(",");
							if (prodAttributes.length != numOfProd) { // Check if the number of attributes is equal to numOfProd
								throw new IllegalArgumentException("Invalid number of product attributes");
							}
							String[] nbofit = reader.readLine().split(",");
							if (nbofit.length != numOfProd) { // Check if the number of nb of items is equal to numOfProd
								throw new IllegalArgumentException("Invalid number of nb of items");
							}
							for (int i = 0; i < numOfProd; i++) {
								String barCode = prodAttributes[i];
								int nbOfIt = Integer.parseInt(nbofit[i]);
								for (Product pr : prodList) {
									if (pr.getBarCode().equals(barCode)) {
										sl.AddSoldProduct(pr, nbOfIt);
									}
								}
							}
							line2 = reader.readLine();
						}
						sl.CalcTotal();
						sl.AddAcoounting();
						sl.AddStock();
						result.add(sl);
					}
				}
			}
			reader.close();
			System.out.println("File read successfully.");
		} catch (IOException e) {
			System.out.println("Error reading file: " + this.filename);
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Invalid file format in " + this.filename);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}


	public void clearCSVFile() {
		try {
			FileWriter writer = new FileWriter(this.filename);
			writer.write("");
			writer.flush();
			writer.close();
			System.out.println("File cleared successfully.");
		} catch (IOException e) {
			System.out.println("Error clearing file: " + this.filename);
			e.printStackTrace();
		}
	}

}
