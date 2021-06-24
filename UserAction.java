package pers.cyz.controller;

import javax.swing.JTextField;

import pers.cyz.dao.UserDao;
import pers.cyz.model.User;

=
public class UserAction {
    

	   /**
	    * 修改用户名密码
	    */
	    public void edit(JTextField username,JTextField passwd) throws Exception{
	    	User user = new User();
	        UserDao userdao=new UserDao();
	        userdao.updateUser(user,username.getText(),passwd.getText());
	    }
	        

}
