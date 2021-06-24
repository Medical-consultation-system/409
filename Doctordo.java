package pers.cyz.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pers.cyz.controller.DoctorAction;
import pers.cyz.util.BackgroundImage;
import pers.cyz.util.FrameOption;
import pers.cyz.util.MenuBar;
import pers.cyz.util.SetTableColumnCenter;

/**
 * 图书借阅窗体类
 * 
 * @author 1651200111 陈彦志
 */
public class Doctordo {

	JFrame frame = new JFrame("医疗问诊系统");
	Container container = frame.getContentPane();
	
	
	// 表格
	JTable table;
	// 显示表格的滚动面板
	JScrollPane scrollPane;
	// 归还图书按钮
	JButton buttonReturn;
	
	DoctorAction doctorAction;

	public Doctordo() {

		frame.setLayout(null);
		
		// 设置背景图片
		new BackgroundImage(frame,container,"BookBorrow.jpg");
		// 添加工具栏以及各组件和监听事件
		new MenuBar(frame);
	
		// 设置表格
		setTable();
	
		// 归还图书按钮
		buttonReturn = new JButton();
		setButtonReturn();
		
		container.add(buttonReturn);
		container.add(scrollPane);
		// 设置窗口大小、位置、可视、默认关闭方式等			
		new FrameOption(frame);
	}


	
	
	/**
	 * 设置归还图书按钮
	 */
	private void setButtonReturn() {
		buttonReturn.setBounds(580,390,100,25);
		buttonReturn.setIcon(new ImageIcon("res/button_return.jpg"));
		buttonReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					doctorAction = new DoctorAction();
					doctorAction.BorrowBook(table);
					frame.setVisible(false);	
					new Doctordo();
				} catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"请先选中要归还的表格项","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}			
			}
		});
	}

	
	/**
	 * 设置表格
	 */
	private void setTable() {
		String[] columnNames = {"医生ID", "医生姓名", "医生回复", "咨询内容"};
		try {
			DoctorAction doctorAction = new DoctorAction();
			Object[][] results = doctorAction.initializTable(columnNames);
					
			table = new JTable(results,columnNames);
			new SetTableColumnCenter(table);
			scrollPane = new JScrollPane(table);
			scrollPane.setViewportView(table);
			scrollPane.setBounds(20,80,760,190);			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
