package mayintarlasi;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Runner {

	public static void main(String[] args) {
		mayinnTarlasi oyun = new mayinnTarlasi();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		oyun.setBounds(100,100,(int)dim.getWidth(),(int)dim.getHeight());
		oyun.setResizable(false);
		oyun.setSize(940,650);
		oyun.setLocationRelativeTo(null);
		oyun.setTitle("MAYIN TARLASI");
		oyun.setVisible(true);
	}

}