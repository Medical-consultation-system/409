package pers.cyz.controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;

import pers.cyz.dao.DoctorDao;
import pers.cyz.model.Doctor;


public class RootAction {
	
 
        
	/**
	 * 初始化窗体表格
	 * @return
	 * 		results
	 */
	@SuppressWarnings("rawtypes")
	public Object[][] initializTable(String[] columnNames) throws Exception{
		DoctorDao doctorDao = new DoctorDao();
		List list = doctorDao.query();
		Object[][] results = new Object[list.size()][columnNames.length];
		
		for(int i = 0; i < list.size(); i++) {
			Doctor doctor = (Doctor)list.get(i);
	
			results[i][0] = doctor.getID();
			results[i][1] = doctor.getBookName();
			results[i][2] = doctor.getAuthor();
			results[i][3] = doctor.getPrice();
			results[i][4] = doctor.getISBN();
			results[i][5] = doctor.getPublishHouse();
			results[i][6] = doctor.getBookCategory();
	
			String borrowerName =  doctor.getBorrowerName();
			if (borrowerName == null) {	
				borrowerName = "";	
				results[i][7] = borrowerName;
			}
			else {	
				results[i][7] = borrowerName;
			}
			
			String borrowerPhone = doctor.getBorrowerPhone();
			if (borrowerPhone == null) {		
				borrowerPhone = "";	
				results[i][8] = borrowerPhone;
			}	
			else {	
				results[i][8] = borrowerPhone;
			}
		}	   	
		return results;
}
	
	
 	
	public void addBookInformation (JTextField textFieldISBN, JTextField textFieldName
			,JTextField textFieldPrice, JTextField textFieldAuthor, JTextField textFieldPublishedHouse
			, JTextField textFieldBookCategory, JTextField textFieldBorrowName
			, JTextField textFieldBorrowPhone) throws Exception {
	
        DoctorDao doctorDao =new DoctorDao();
        Doctor doctor =new Doctor();
        
        doctor.setISBN(textFieldISBN.getText());
        doctor.setBookName(textFieldName.getText());
        float price = Float.parseFloat(textFieldPrice.getText());
        doctor.setPrice(price);
        doctor.setAuthor(textFieldAuthor.getText());
        doctor.setPublishHouse(textFieldPublishedHouse.getText());
        doctor.setBookCategory(textFieldBookCategory.getText());
        
        if (textFieldBorrowName.getText() == null ||textFieldBorrowName.getText() == "" ) {
        	doctor.setBorrowerName(null);
        }
        else {
        	 doctor.setBorrowerName(textFieldBorrowName.getText());
        }
       
        if (textFieldBorrowPhone.getText() == null || textFieldBorrowPhone.getText() == "") {
        	doctor.setBorrowerPhone(null);
        }
        else {
        	doctor.setBorrowerPhone(textFieldBorrowPhone.getText());
        }
        
     
        doctorDao.addBook(doctor);
	}
	
	

	public void delBookInformation (JTable table) throws Exception {
	
		int selRow = table.getSelectedRow();
		int ID = Integer.parseInt(table.getValueAt(selRow, 0).toString());
		
        DoctorDao doctorDao =new DoctorDao();
        Doctor doctor =new Doctor();
        
        doctor.setID(ID);
   
       
        doctorDao.delBook(ID);
	}
	
	
	
	public void changeBookInformation (JTextField textFieldISBN, JTextField textFieldName
			,JTextField textFieldPrice, JTextField textFieldAuthor, JTextField textFieldPublishedHouse
			, JTextField textFieldBookCategory, JTextField textFieldBorrowerName
			, JTextField textFieldBorrowerPhone, JTable table) throws Exception{
		
        DoctorDao doctorDao =new DoctorDao();
        Doctor doctor =new Doctor();
       
		int selRow = table.getSelectedRow();
		int ID = Integer.parseInt(table.getValueAt(selRow, 0).toString());	
        doctor.setID(ID);
        
        doctor.setISBN(textFieldISBN.getText());
        doctor.setBookName(textFieldName.getText());
        doctor.setAuthor(textFieldAuthor.getText());
        float price = Float.parseFloat(textFieldPrice.getText());
        doctor.setPrice(price);
        doctor.setPublishHouse(textFieldPublishedHouse.getText());
        doctor.setBookCategory(textFieldBookCategory.getText());
        doctor.setBorrowerName(textFieldBorrowerName.getText());
    	doctor.setBorrowerPhone(textFieldBorrowerPhone.getText());
      
        doctorDao.changeBook(doctor);
	}
	
	
}
    
    
    



