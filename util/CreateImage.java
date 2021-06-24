package pers.cyz.util;

import javax.swing.ImageIcon;
public class CreateImage {
	
	public static ImageIcon add(String ImageName) {	
		// 加载图片
		ImageIcon icon= new ImageIcon("res/" + ImageName);	
		return icon;
	}
	

}
