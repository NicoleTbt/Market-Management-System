import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Hourly_Emp extends Employee {
	
	private String Specialty;
	private double Work_Hours;
	private double Pay_Rate;


	public Hourly_Emp(String firstName, String lastName, String nationalID, String address, String tel,String specialty, double pay_Rate) {
		super(firstName, lastName, nationalID, address, tel);
		this.Specialty = specialty;
		this.Work_Hours = 0;
		this.Pay_Rate = pay_Rate;
	}

	public String getSpecialty() {
		return Specialty;
	}

	public void setSpecialty(String specialty) {
		Specialty = specialty;
	}

	public double getWork_Hours() {
		return Work_Hours;
	}

	public void setWork_Hours(double work_Hours) {
		Work_Hours = work_Hours;
	}

	public double getPay_Rate() {
		return Pay_Rate;
	}

	public void setPay_Rate(double pay_Rate) {
		Pay_Rate = pay_Rate;
	}
	
	public void HEmpwriteFile(FileManip fm) throws IllegalAccessException {
	    try {
	        PrintWriter writer = new PrintWriter(new FileWriter(fm.getFilename(), true));
	        writer.println(this.FirstName+"\n"+this.NationalID+"\n"+this.LastName+"\n"+this.Address+"\n"+this.Tel+"\n"+this.Specialty+"\n"+this.Pay_Rate);
	        writer.close();
	    } catch (IOException e) {
	        System.out.println("Error writing to file: " + fm.getFilename());
	        e.printStackTrace();
	    }
	}
	
	public String toString() {
		return "Hourly_Emp [Specialty=" + Specialty + ", Work_Hours=" + Work_Hours + ", Pay_Rate=" + Pay_Rate
				+ ", FirstName=" + FirstName + ", LastName=" + LastName + ", NationalID=" + NationalID + ", Address="
				+ Address + ", Tel=" + Tel + "]";
	}

}
