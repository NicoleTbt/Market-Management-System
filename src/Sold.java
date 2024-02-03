import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;

public class Sold implements Stock{

	static int Scount = 1;
	private String SoID;
	private String Date;
	private ArrayList<Product> SoldProd = new ArrayList <Product> ();
	private ArrayList<Integer> NbSoldItems = new ArrayList <Integer> ();
	private double Total;
	private Accounting Acc_Report;
	private final double Profit=0.20;

	public Sold (Accounting accRep) {
		this.SoID="So/"+Sold.Scount;
		Sold.Scount++;
		String date=new SimpleDateFormat("yyyy_MM_dd").format(Calendar.getInstance().getTime());
		this.Date=date;
		this.Acc_Report=accRep;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public static int getScount() {
		return Scount;
	}

	public String getSoID() {
		return SoID;
	}
	
	public void setSoID(String soID) {
		SoID = soID;
	}

	public void AddSoldProduct( Product pr , int nbOfIt) {
		if (pr.getStockQtt()>= nbOfIt && nbOfIt>0) {
			this.SoldProd.add(pr);
			this.NbSoldItems.add(nbOfIt);
		}else {System.out.println("Qantity not available! \nQuantity left: "+pr.getStockQtt());}
	}

	@Override
	public void CalcTotal() {
		for(int i=0 ; i<this.NbSoldItems.size() ;i++) {
			double stot=(this.SoldProd.get(i).getPrice())*(this.NbSoldItems.get(i));
			this.Total+=stot+(stot*this.Profit);
		}
	}

	@Override
	public void AddStock() {
		for(int i=0 ; i<SoldProd.size() ;i++) {
			SoldProd.get(i).setStockQtt(SoldProd.get(i).getStockQtt()-NbSoldItems.get(i) );
		}
	}
	@Override
	public void AddAcoounting() {
		this.Acc_Report.setSales_Money(this.Acc_Report.getSales_Money()+this.Total);

		this.Acc_Report.setPayment_Money(this.Acc_Report.getPayment_Money()+(this.Total-(this.Total*this.Profit)));

		this.Acc_Report.setProfit(this.Acc_Report.getProfit()+(this.Total-(this.Total-(this.Total*this.Profit))));

	}
	@Override
	public void DeleteAcoounting() {
		this.Acc_Report.setSales_Money(this.Acc_Report.getSales_Money()-this.Total);

		this.Acc_Report.setPayment_Money(this.Acc_Report.getPayment_Money()-(this.Total-(this.Total*this.Profit)));

		this.Acc_Report.setProfit(this.Acc_Report.getProfit()-(this.Total-(this.Total-(this.Total*this.Profit))));

	}

	public String DisplayInv () {
		String S="";
		for(int i=0 ; i<SoldProd.size() ;i++) {
			S+=this.SoldProd.get(i).getBarCode()+"\t"+this.SoldProd.get(i).getPrice()+"\t"+this.NbSoldItems.get(i)+"\n";
		}
		return "Date: " +Date +"\nInvoice: "+SoID+"\nProduct\tPrice\tItems\n"+S+"\n\tTotal: "+this.Total + "\n\nThank You For Your Purchase!";

	}

	public void DeleteStock() {
		for(int i=0 ; i<SoldProd.size() ;i++) {
			SoldProd.get(i).setStockQtt(SoldProd.get(i).getStockQtt()+NbSoldItems.get(i) );
		}
	}

	public void DelSoldProduct( Product pr ) {
		boolean check=false;
		for(Product prd : SoldProd) {
			if(prd.getBarCode().equals(pr.getBarCode())){
				check=true;
			}}
		if(check==true) {
			this.SoldProd.remove(pr);
			this.NbSoldItems.remove(SoldProd.indexOf(pr));}
		else System.out.print("Product not in the Sales list!");
	}

	public void SoldwriteFile(FileManip fm) throws IllegalAccessException {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(fm.getFilename(), true));
			int nbofprd=this.SoldProd.size();
			writer.println(this.SoID+"\n"+this.Date+"\n"+this.Acc_Report.getAccount_ID()+"\n"+nbofprd);
			for(Product pr : SoldProd) {
				writer.print(pr.getBarCode()+",");
			}
			writer.println();
			for(Integer inte : NbSoldItems) {
				writer.print(inte + ",");
			}
			writer.println();
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to file: " + fm.getFilename());
			e.printStackTrace();
		}
	}



}