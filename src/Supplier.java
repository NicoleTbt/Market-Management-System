import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Supplier {

	private String SupID;
	private String SupName;
	private String SupAddress;
	private String SupTel;

	public Supplier(String supID, String supName, String supAddress, String supTel) {
		this.SupID = supID;
		this.SupName = supName;
		this.SupAddress = supAddress;
		this.SupTel = supTel;
	}

	public String getSupID() {
		return SupID;
	}

	public String getSupName() {
		return SupName;
	}

	public void setSupName(String supName) {
		SupName = supName;
	}

	public String getSupAddress() {
		return SupAddress;
	}

	public void setSupAddress(String supAddress) {
		SupAddress = supAddress;
	}

	public String getSupTel() {
		return SupTel;
	}

	public void setSupTel(String supTel) {
		SupTel = supTel;
	}

	public void setSupID(String supID) {
		SupID = supID;
	}

	public void SupwriteFile(FileManip fm) throws IllegalAccessException {
		try {
			PrintWriter writer = new PrintWriter(new FileWriter(fm.getFilename(), true));
			writer.println(this.SupID+"\n"+this.SupName+"\n"+this.SupAddress+"\n"+this.SupTel);
			writer.close();
		} catch (IOException e) {
			System.out.println("Error writing to file: " + fm.getFilename());
			e.printStackTrace();
		}
	}

	public String toString() {
		return "Supplier [SupID=" + SupID + ", SupName=" + SupName + ", SupAddress=" + SupAddress + ", SupTel=" + SupTel
				+ "]";
	}


}