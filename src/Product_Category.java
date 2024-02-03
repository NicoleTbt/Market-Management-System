import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Product_Category {
	private int CatID;
	private String description;
	private ArrayList<Product> CatProdList=new ArrayList<Product>();

	public Product_Category(int catID, String description) {
		this.CatID = catID;
		this.description = description;

	}

	public int getCatID() {
		return CatID;
	}

	public void setCatID(int catID) {
		CatID = catID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Product> getCatProdList() {
		return CatProdList;
	}

	public void setCatProdList(ArrayList<Product> catProdList) {
		CatProdList = catProdList;
	}

	public void CatwriteFile(FileManip fm) throws IllegalAccessException {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(fm.getFilename(), true));
			writer.println(this.CatID+"\n"+this.description);
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to file: " + fm.getFilename());
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return "Product_Category [CatID=" + CatID + ", description=" + description ;
	}


}