package NewProject;


public class EmpData {
	private int empNo;
	private String name;
	private String nation;
	private String birth;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private int empCd;
	private String school;
	private String empType;
	private String empLoc;
	private String note;
	private int salary;
	private int available;
	private String estYearMonth;
	

	
	public EmpData(int empNo, String name, String nation, String birth, String gender, String address, String tel, String email, int empCd, String school, String empType, String empLoc, String note, int salary, int available, String estYearMonth) {
		this.empNo = empNo;
		this.name = name;
		this.nation = nation;
		this.birth = birth;
		this.gender = gender;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.empCd = empCd;
		this.school = school;
		this.empType = empType;
		this.empLoc = empLoc;
		this.note = note;
		this.salary = salary;
		this.available = available;
		this.estYearMonth = estYearMonth;
	}
	
	

	public int getEmpNo() {
		return this.empNo;
	}
	public String getName() {
		return this.name;
	}
	public String getNation() {
		return this.nation;
	}
	public String getGender() {
		return this.gender;
	}
	public String getAdress() {
		return this.name;
	}
	public String getTel() {
		return this.tel;
	}
	public String getEmail() {
		return this.email;
	}
	public int getEmpCd() {
		return this.empCd;
	}
	public String getBirth() {
		return this.birth;
	};
	public String getSchool() {
		return this.school;
	};
	public String getEmpType() {
		return this.empType;
	};
	public String getEmpLoc() {
		return this.empLoc;
	};
	public String getNote() {
		return this.note;
	};
	public String getAddress() {
		return this.address;
	}
	public int getSalary() {
		return this.salary;
	}
	public int getAvailable() {
		return this.available;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String gender) {
		this.gender = gender;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCd(int empCd) {
		this.empCd = empCd;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	};
	public void setSchool(String school) {
		this.school = school;
	};
	public void setEmpType(String empType) {
		this.empType = empType;
	};
	public void setEmpLoc(String empLoc) {
		this.empLoc = empLoc;
	};
	public void setNote(String note) {
		this.note = note;
	};
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public void setAvailable(int available) {
		this.available = available;
	}



	public String getEstYearMonth() {
		return estYearMonth;
	}



	public void setEstYearMonth(String estYearMonth) {
		this.estYearMonth = estYearMonth;
	}



	public void setNation(String nation) {
		this.nation = nation;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public void setEmpCd(int empCd) {
		this.empCd = empCd;
	}
	
	
}

