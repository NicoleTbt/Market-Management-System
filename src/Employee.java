public class Employee {

	protected String FirstName;
	protected String LastName;
	protected String NationalID;
	protected String Address;
	protected String Tel;


	public Employee(String firstName, String lastName, String nationalID, String address, String tel) {
		this.FirstName = firstName;
		this.LastName = lastName;
		this.NationalID = nationalID;
		this.Address = address;
		this.Tel = tel;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getNationalID() {
		return NationalID;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String toString() {
		return "Employee [FirstName=" + FirstName + ", LastName=" + LastName + ", NationalID=" + NationalID
				+ ", Address=" + Address + ", Tel=" + Tel + "]";
	}


}
