import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Fixed_Emp extends Employee {

	private String Specialty;
	private double Monthly_Pay;

	public Fixed_Emp(String firstName, String lastName, String nationalID, String address, String tel, String specialty, double monthly_Pay) {
		super(firstName, lastName, nationalID, address, tel);
		this.Specialty = specialty;
		this.Monthly_Pay = monthly_Pay;
	}

	public String getSpecialty() {
		return Specialty;
	}

	public void setSpecialty(String specialty) {
		Specialty = specialty;
	}

	public double getMonthly_Pay() {
		return Monthly_Pay;
	}

	public void setMonthly_Pay(double monthly_Pay) {
		Monthly_Pay = monthly_Pay;
	}

	public String getFirstname() {
		return super.FirstName;
	}

	public String getLastName() {
		return super.LastName;
	}

	public String getNatID() {
		return super.NationalID;
	}

	public String getAddress() {
		return super.Address;
	}

	public String getTel() {
		return super.Tel;
	}

	public void setFirstname(String fname) {
		super.FirstName=fname;
	}

	public void setLastName(String lname) {
		super.LastName=lname;
	}

	public void setNatID(String NID) {
		super.NationalID=NID;
	}

	public void setAddress(String Add) {
		super.Address=Add;
	}

	public void setTel(String Tel) {
		super.Tel=Tel;
	}
	
	public void FEmpwriteFile(FileManip fm) throws IllegalAccessException {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(fm.getFilename(), true));
			writer.println(this.FirstName+"\n"+this.NationalID+"\n"+this.LastName+"\n"+this.Address+"\n"+this.Tel+"\n"+this.Specialty+"\n"+this.Monthly_Pay);
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to file: " + fm.getFilename());
			e.printStackTrace();
		}
	}

	public String toString() {
		return "Fixed_Emp [Specialty=" + Specialty + ", Monthly_Pay=" + Monthly_Pay + ", FirstName=" + FirstName
				+ ", LastName=" + LastName + ", NationalID=" + NationalID + ", Address=" + Address + ", Tel=" + Tel
				+ "]";
	}


}
