package services;

import javax.swing.JFrame;

public abstract class FrameService {

	protected JFrame frame;
	
	public FrameService(JFrame frame) {
		this.frame = frame;
	}
	
	/**
	 * Showing the frame
	 */
	public void showFrame() {
		frame.setVisible(true);
	}
	
	public void hideFrame() {
		frame.setVisible(false);
	}
	
	public void disposeFrame() {
		frame.dispose();
	}
}
