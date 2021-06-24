package pers.cyz.model;
public class User {
	
	private int ID;
	private String userName;
	private String passwd;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUser() {
		return userName;
	}
	public void setUser(String userName) {
		this.userName = userName;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
