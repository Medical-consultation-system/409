package pers.cyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pers.cyz.model.Doctor;
import pers.cyz.util.DBUtil;
public class DoctorDao {
    public void addBook(Doctor doctor) throws Exception{
        Connection con = DBUtil.getConnection();
        String sql="insert into tb_books"
        		+ "(ISBN, book_name, book_price, book_author, published_house,"
        		+ "book_category, borrower_name, borrower_phone) "
        		+ "values("
        		+ "?,?,?,?,?,?,?,?)";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, doctor.getISBN());
        psmt.setString(2, doctor.getBookName());
        psmt.setFloat(3, doctor.getPrice());
        psmt.setString(4, doctor.getAuthor());
        psmt.setString(5, doctor.getPublishHouse());
        psmt.setString(6, doctor.getBookCategory());
        
        if (doctor.getBorrowerName() == null || doctor.getBorrowerName() == "") {
        	psmt.setString(7, null);
        }
        else {
        	  psmt.setString(7, doctor.getBorrowerName());
        }
      
        if (doctor.getBorrowerPhone() == null || doctor.getBorrowerPhone() == "") {
        	 psmt.setString(8, null);  
        }
        else {
        	psmt.setString(8, doctor.getBorrowerPhone());
        }
        //执行SQL语句
        psmt.execute();
    }
      public void delBook(int ID) throws SQLException{
          Connection con=DBUtil.getConnection();
          String sql="" + 
                  "DELETE FROM tb_books "+
                  "WHERE ID = ?";
          PreparedStatement psmt = con.prepareStatement(sql);
          psmt.setInt(1, ID);
          // 执行SQL语句
          psmt.execute();    
      }
    public void changeBook(Doctor doctor) throws SQLException{
    	// 首先拿到数据库的连接
        Connection con=DBUtil.getConnection();
        String sql="update tb_books "
        		+ "set ISBN = ?, book_name = ?, book_price = ?, book_author = ?"
                + ",published_house = ?, book_category = ?, borrower_name = ?, borrower_phone = ? "
                // 参数用?表示，相当于占位符 
        		+ "where ID = ?";
        // 预编译sql语句
        PreparedStatement psmt = con.prepareStatement(sql);
        // 先对应SQL语句，给SQL语句传递参数
        psmt.setString(1, doctor.getISBN());
        psmt.setString(2, doctor.getBookName());
        psmt.setFloat(3, doctor.getPrice());
        psmt.setString(4, doctor.getAuthor());
        psmt.setString(5, doctor.getPublishHouse());
        psmt.setString(6, doctor.getBookCategory());
        if (doctor.getBorrowerName().equals("")) {
        	psmt.setString(7, null);
        }
        else {
        	 psmt.setString(7, doctor.getBorrowerName());
        }
       
        if (doctor.getBorrowerPhone().equals("")) {
        	psmt.setString(8, null);
        }
        else {
        	 psmt.setString(8, doctor.getBorrowerPhone());
        }
        psmt.setInt(9, doctor.getID());
        // 执行SQL语句
        psmt.execute();    
    }
	public List<Doctor> query() throws Exception{
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("select "
				+ "ID, ISBN, book_name, book_author, book_price, published_house, "
				+ "book_category, borrower_name, borrower_phone "
				+ "from tb_books");	      
		List<Doctor> doctorList = new ArrayList<Doctor>();
		Doctor doctor = null;
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	           
			doctor = new Doctor();
			doctor.setID(rs.getInt("ID"));
			doctor.setISBN(rs.getString("ISBN"));
			doctor.setBookName(rs.getString("book_name"));
			doctor.setAuthor(rs.getString("book_author"));
			doctor.setPrice(rs.getFloat("book_price"));
			doctor.setPublishHouse(rs.getString("published_house"));
			doctor.setBookCategory(rs.getString("book_category"));
			doctor.setBorrowerName(rs.getString("borrower_name"));
			doctor.setBorrowerPhone(rs.getString("borrower_phone"));
			doctorList.add(doctor);
		}	       
		return doctorList;
	}
	public List<Doctor> borrowQuery() throws Exception{
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery(""

				+ "SELECT ID, book_name, borrower_name, borrower_phone "
				+ "FROM tb_books "
				+ "WHERE borrower_name IS NOT NULL"
				);	      
		List<Doctor> doctorList = new ArrayList<Doctor>();
		Doctor doctor = null;
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	           
			doctor = new Doctor();
			doctor.setID(rs.getInt("ID"));
			doctor.setBookName(rs.getString("book_name"));
			doctor.setBorrowerName(rs.getString("borrower_name"));
			doctor.setBorrowerPhone(rs.getString("borrower_phone"));
			doctorList.add(doctor);
		}	       
		return doctorList;
	}
    public void returnBook(Doctor doctor) throws SQLException{
    	// 首先拿到数据库的连接
        Connection con=DBUtil.getConnection();
        String sql="UPDATE tb_books "
        		+ "SET "
        		+ "borrower_name = ?, borrower_phone = ? "
        		+ "WHERE ID = ?";
        // 预编译sql语句
        PreparedStatement psmt = con.prepareStatement(sql);
        // 先对应SQL语句，给SQL语句传递参数
        psmt.setString(1, doctor.getBorrowerName());
        psmt.setString(2, doctor.getBorrowerPhone());
        psmt.setInt(3, doctor.getID());
        // 执行SQL语句
        psmt.execute();    
    }
}
