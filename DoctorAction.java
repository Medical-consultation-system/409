package pers.cyz.controller;

import java.util.List;

import javax.swing.JTable;

import pers.cyz.dao.DoctorDao;
import pers.cyz.model.Doctor;


public class DoctorAction {

	
	DoctorDao borrowerDao;
    
	
	@SuppressWarnings("rawtypes")
	public Object[][] initializTable(String[] columnNames) throws Exception{
		borrowerDao = new DoctorDao();
		List list = borrowerDao.borrowQuery();
		Object[][] results = new Object[list.size()][columnNames.length];
		
		for(int i = 0; i < list.size(); i++) {		
			Doctor doctor = (Doctor)list.get(i);
			
			results[i][0] = doctor.getID();

			results[i][1] = doctor.getBookName();
			results[i][2] = doctor.getBorrowerName();
			results[i][3] = doctor.getBorrowerPhone();
		}	   	
		return results;
	}
	
	
	
	public void BorrowBook (JTable table) throws Exception{
		
        borrowerDao=new DoctorDao();
        Doctor doctor =new Doctor();
       
		int selRow = table.getSelectedRow();
		int ID = Integer.parseInt(table.getValueAt(selRow, 0).toString());	
	
        doctor.setID(ID);
        doctor.setBorrowerName(null);
        doctor.setBorrowerPhone(null);
        
      
        borrowerDao.returnBook(doctor);
	}
	
	
	
}
