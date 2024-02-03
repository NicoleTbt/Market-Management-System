import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Product {

	protected String BarCode;
	protected String SupID;
	protected Product_Category Category;
	protected double price;
	protected int StockQtt;

	public Product(String barCode, String supID, Product_Category catID, double price) {

		this.BarCode = barCode;
		this.SupID = supID;
		this.Category = catID;
		this.price = price;
		this.StockQtt=0;
	}

	public String getBarCode() {
		return BarCode;
	}

	public void setBarCode(String barCode) {
		BarCode = barCode;
	}

	public String getSupID() {
		return SupID;
	}

	public void setSupID(String supID) {
		SupID = supID;
	}

	public Product_Category getCategory() {
		return Category;
	}

	public String DisplayCategory() {
		return Category.toString();
	}

	public void setCategory(Product_Category catID) {
		Category = catID;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setStockQtt (int qtt) {
		this.StockQtt=qtt;
	}

	public int getStockQtt () {
		return this.StockQtt;
	}
	
	public void ProdwriteFile(FileManip fm) throws IllegalAccessException {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(fm.getFilename(), true));
			writer.println(this.BarCode+"\n"+this.SupID+"\n"+this.Category.getCatID()+"\n"+this.price+"\n"+this.StockQtt+"\n"+this.Category.getDescription());
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to file: " + fm.getFilename());
			e.printStackTrace();
		}
	}

	public String toString() {
		return "Product BarCode: " + BarCode + "\tSupID: " + SupID + "\tCategory: " + this.Category.getCatID() + "\tprice: " + price
				+ "\tStockQtt:" + StockQtt ;
	}


}