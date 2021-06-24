package pers.cyz.model;
public class Doctor {
	private int ID;
	private String bookName;
	private float price;
	private String author;
	private String publishedHouse;
	private String bookCategory;
	private String borrowerName;
	private String borrowerPhone;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	public String getPublishHouse() {
		return publishedHouse;
	}
	
	public void setPublishHouse(String publishedHouse) {
		this.publishedHouse = publishedHouse;
	}
	
	
	
	public String getBookCategory() {
		return bookCategory;
	}
	
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	
	
	public String getBorrowerName() {
		return borrowerName;
	}
	
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	
	
	public String getBorrowerPhone() {
		return borrowerPhone;
	}
	
	public void setBorrowerPhone(String borrowerPhone) {
		this.borrowerPhone = borrowerPhone;
	}


}
