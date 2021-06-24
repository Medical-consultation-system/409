package pers.cyz.util;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class SetTableColumnCenter {
	
	/**
	 * 表格数据居中
	 * @param table
	 */
	public SetTableColumnCenter(JTable table) {		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);   
		table.setDefaultRenderer(Object.class, r);	
	}
	
}
