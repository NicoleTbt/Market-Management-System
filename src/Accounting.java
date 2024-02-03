import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Accounting {

	private String Account_ID;	
	private String Date;
	private double Account_Payable=0;
	private double Sales_Money=0;
	private double Profit=0;
	private double Payment_Money=0;
	private double Debt=0;
	private double Payed=0;

	public Accounting(String accId , String dt) {
		this.Account_ID = accId;
		this.Date=dt;
	}

	public void Payments(double Ammount ) {
		if(Ammount>0) {
			this.Payed+=Ammount;
			this.Debt=this.Account_Payable-this.Payed;
		}else System.out.println("Ammount cannot be negative");
	}

	public void Employee_Payable(Fixed_Emp emp) {
		this.Account_Payable+=emp.getMonthly_Pay();
		this.Debt=this.Account_Payable-this.Payed;
	}
	public void Employee_Payable(Hourly_Emp emp) {
		this.Account_Payable+=(emp.getPay_Rate()*emp.getPay_Rate());
		this.Debt=this.Account_Payable-this.Payed;
	}

	public String toString() {
		String s="";
		s+="Report sheet of month:" +this.Account_ID+"\n Account Payable: "+this.Account_Payable+"\n Total Sales : "+this.Sales_Money+"\n Net Sales: "+this.Payment_Money+"\n Ammount Payed : "+this.Payed+
				"\n Debt left :"+this.Debt+"\n Profit : "+this.Profit;
		return s;
	}

	public double getAccount_Payable() {
		return Account_Payable;
	}

	public void setAccount_Payable(double account_Payable) {
		Account_Payable = account_Payable;
	}

	public double getSales_Money() {
		return Sales_Money;
	}

	public void setSales_Money(double sales_Money) {
		Sales_Money = sales_Money;
	}

	public double getProfit() {
		return Profit;
	}

	public void setProfit(double profit) {
		Profit = profit;
	}

	public double getPayment_Money() {
		return Payment_Money;
	}

	public void setPayment_Money(double payment_Money) {
		Payment_Money = payment_Money;
	}

	public String getAccount_ID() {
		return Account_ID;
	}

	public void setAccount_ID(String account_ID) {
		Account_ID = account_ID;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public double getDebt() {
		return Debt;
	}

	public void setDebt(double debt) {
		Debt = debt;
	}

	public double getPayed() {
		return Payed;
	}

	public void setPayed(double payed) {
		Payed = payed;
	}

	public void AccwriteFile(FileManip fm) throws IllegalAccessException {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(fm.getFilename(), true));
			writer.println(this.Account_ID+"\n"+this.Date+"\n"+this.Account_Payable+"\n"+this.Sales_Money+"\n"+this.Profit+"\n"+this.Payment_Money+"\n"+this.Debt+"\n"+this.Payed);
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to file: " + fm.getFilename());
			e.printStackTrace();
		}
	}

	

}
