package pers.cyz.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pers.cyz.view.BookBorrow;
import pers.cyz.view.BookInformation;
import pers.cyz.view.ChangeUserInformation;
import pers.cyz.view.Login;

public class MenuBar {
	
	JMenuBar menuBar;
	JMenuItem menuItemBookInformation;
	JMenuItem menuItemBorrowManage;
	JMenuItem menuItemChangUser;
	JMenuItem menuItemExit;
	
	
	public MenuBar(JFrame frame) {
		
		menuBar = new JMenuBar();
		
		// 图书信息管理菜单项
		menuItemBookInformation = new JMenuItem();	 
		setMenuItemBookInformationn(frame);
	
		// 图书借阅管理菜单项
		menuItemBorrowManage = new JMenuItem();
		setMenuItemBorrowManage(frame);
		
		// 用户信息更改菜单项
		menuItemChangUser = new JMenuItem();
		setMenuItemChangeUser(frame);
		
		// 退出系统菜单项
		menuItemExit = new JMenuItem();
		setMenuItemExit(frame);
			
		menuBar.add(menuItemBorrowManage);
		menuBar.add(menuItemBookInformation);
		menuBar.add(menuItemChangUser);
		menuBar.add(menuItemExit);
		
		frame.setJMenuBar(menuBar);
	}


	
	/**
	 * 设置退出系统菜单项
	 */
	private void setMenuItemExit(JFrame frame) {
		menuItemExit.setIcon(new ImageIcon("res/menuItemExit.jpg"));
		menuItemExit.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new Login();
			}
		});
	}


	private void setMenuItemChangeUser(JFrame frame) {
		menuItemChangUser.setIcon(new ImageIcon("res/menuItemChangePassword.jpg"));
		menuItemChangUser.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new ChangeUserInformation();
			}
		});
	}


	private void setMenuItemBorrowManage(JFrame frame) {
		menuItemBorrowManage.setIcon(new ImageIcon("res/bbb.png"));
		menuItemBorrowManage.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new BookBorrow();
			}
		});
	}


	private void setMenuItemBookInformationn(JFrame frame) {
		menuItemBookInformation.setIcon(new ImageIcon("res/bb.png"));
		menuItemBookInformation.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);	
				new BookInformation();
			}
		});
	}
	

}
