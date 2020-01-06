package ui;

import java.util.Hashtable;

import javax.swing.JFrame;

public class App {

	private static Hashtable<Class, JFrame> myFrameTable = new Hashtable<>();
	
	public static void main(String[] args) {
		JFrame mainFrame = new MainFrame();
		
		myFrameTable.put(MainFrame.class, mainFrame);
		myFrameTable.put(PegawaiFrame.class, new PegawaiFrame());
		
		mainFrame.setVisible(true);
	}
	
	public static void switchFrame(JFrame originatingFrame, Class nextFrame) {
		originatingFrame.setVisible(false);
	    myFrameTable.get(nextFrame).setVisible(true);
	}
}
