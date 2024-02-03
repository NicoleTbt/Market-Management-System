import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

public class Purchase implements Stock{

	private String PurID;
	private String Date;
	private String SupID;
	private ArrayList<Product> PurProd=new ArrayList <Product> ();
	private ArrayList<Integer> NbPurItems=new ArrayList <Integer> ();
	private double Total=0;
	private Accounting Acc_Report;

	public Purchase (String ID ,String sId, Accounting acc) {
		this.PurID=ID;
		String date=new SimpleDateFormat("yyyy_MM_dd").format(Calendar.getInstance().getTime());
		this.Date=date;
		this.Acc_Report=acc;
		this.SupID=sId;
	}

	public String getPurID() {
		return PurID;
	}

	public String getSupID() {
		return SupID;
	}

	public void setSupID(String supID) {
		SupID = supID;
	}

	public void setPurID(String purID) {
		PurID = purID;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public void AddPurProduct( Product pr , int nbOfIt) {
		if(nbOfIt>0) {
			this.PurProd.add(pr);
			this.NbPurItems.add(nbOfIt);
		}else{System.out.println("Quantity cannot be purchased.");}
	}

	public void DelPurProduct(Product pr) {
		this.PurProd.remove(pr);
		this.NbPurItems.remove(PurProd.indexOf(pr));
	}

	@Override
	public void CalcTotal() {
		for(int i=0 ; i<this.NbPurItems.size() ;i++) {
			this.Total+=(this.PurProd.get(i).getPrice())*(this.NbPurItems.get(i));
		}
	}

	@Override
	public void AddStock() {
		for(int i=0 ; i<PurProd.size() ;i++) {
			PurProd.get(i).setStockQtt(PurProd.get(i).getStockQtt()+NbPurItems.get(i) );
		}
	}
	@Override
	public void DeleteStock() {
		for(int i=0 ; i<PurProd.size() ;i++) {
			PurProd.get(i).setStockQtt(PurProd.get(i).getStockQtt()-NbPurItems.get(i) );
		}
	}
	@Override
	public void AddAcoounting() {
		this.Acc_Report.setAccount_Payable(this.Acc_Report.getAccount_Payable()+this.Total);
	}
	@Override
	public void DeleteAcoounting() {
		this.Acc_Report.setAccount_Payable(this.Acc_Report.getAccount_Payable()-this.Total);
	}

	public String DisplayInv () {
		String S="";
		for(int i=0 ; i<PurProd.size() ;i++) {
			S+=this.PurProd.get(i).getBarCode()+"\t"+this.PurProd.get(i).getPrice()+"\t"+this.NbPurItems.get(i)+"\n";
		}
		return "Date: " +Date +"\n"+"Invoice: "+PurID+"\nProduct\tPrice\tItems\n"+S+"\n\tTotal To Pay: "+this.Total ;
	}

	public void PurchwriteFile(FileManip fm) throws IllegalAccessException {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(fm.getFilename(), true));
			int nbofprd = this.PurProd.size();
			writer.println(this.PurID+"\n"+this.Date+"\n"+this.SupID+"\n"+this.Acc_Report.getAccount_ID()+"\n"+nbofprd);
			for(Product pr:PurProd) {
				writer.print(pr.getBarCode()+",");
			}
			writer.println();
			for(Integer inte : NbPurItems) {
				writer.print(inte + ",");
			}
			writer.println();
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to file: " + fm.getFilename());
			e.printStackTrace();
		}
	}



	public String PrintListOfProd() {
		int nbofprd = this.PurProd.size();
		String prds = "";
		System.out.println(this.PurID+","+this.Date+","+this.SupID+","+nbofprd);
		for(Product pr:PurProd) {
			prds += pr.getBarCode() + " ";
		}
		return prds;
	}

	public String PrintNumOfProd() {
		String prds = "";
		for(Integer inte : NbPurItems) {
			prds += inte + " ";
		}
		return prds;
	}


	public String toString() {
		String prds = PrintListOfProd();
		String NbOfPrds = PrintNumOfProd();
		return "Purchase [PurID=" + PurID + ", Date=" + Date + ", SupID=" + SupID + ", PurProd=" + prds
				+ ", NbPurItems=" + NbOfPrds + ", Total=" + Total + ", Acc_Report=" + Acc_Report + "]";
	}


}

