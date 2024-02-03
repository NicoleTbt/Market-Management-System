import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Return implements Stock {

	private String RetID;
	private Product prd;
	private int nbOfItems;
	private float Total; 
	private Accounting Acc_Report;

	public Return (String rid,Product pr , int nbOfItems , Accounting accRep) {
		this.RetID=rid;
		this.Acc_Report=accRep;
		this.prd=pr;

		if (pr.getStockQtt()>= nbOfItems && nbOfItems>=0) {
			this.nbOfItems=nbOfItems;
		}else {
			System.out.println("Quantity not available to be returned. \n Returned quantity registered as 0.");
			this.nbOfItems=0;
		}

	}

	public String getRetID() {
		return RetID;
	}

	public void setRetID(String retID) {
		RetID = retID;
	}

	public Product getPrd() {
		return prd;
	}

	public void setPrd(Product prd) {
		this.prd = prd;
	}

	public int getNbOfItems() {
		return nbOfItems;
	}

	public void setNbOfItems(int nbOfItems) {
		this.nbOfItems = nbOfItems;
	}

	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}

	public Accounting getAcc_Report() {
		return Acc_Report;
	}

	public void setAcc_Report(Accounting acc_Report) {
		Acc_Report = acc_Report;
	}

	public void RetwriteFile(FileManip fm) throws IllegalAccessException {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(fm.getFilename(), true));
			writer.println(this.RetID + "\n"+this.prd.BarCode + "\n"+this.nbOfItems + "\n"+this.Total + "\n"+ this.Acc_Report.getAccount_ID());

			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to file: " + fm.getFilename());
			e.printStackTrace();
		}
	}

	public void AddStock () {
		this.prd.setStockQtt(this.prd.getStockQtt()-this.nbOfItems);
	}

	public void DeleteStock () {
		this.prd.setStockQtt(this.prd.getStockQtt()+this.nbOfItems);
	}

	public void CalcTotal() {
		this.Total+=this.prd.getPrice()*this.nbOfItems*(-1);
	}

	public void AddAcoounting() {
		this.Acc_Report.setAccount_Payable(this.Acc_Report.getAccount_Payable()+this.Total);
	}

	public void DeleteAcoounting() {
		this.Acc_Report.setAccount_Payable(this.Acc_Report.getAccount_Payable()-this.Total);
	}

	public void DisplayReturn () {
		System.out.println("Returned Item:\nProduct\tPrice\tItems\n"+this.prd.getBarCode()+"\t"+this.prd.getPrice()+"\t"+this.nbOfItems+"\n Total: "+this.Total);

	}

}