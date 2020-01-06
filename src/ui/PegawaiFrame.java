package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.Pegawai;
import services.AppService;
import services.FrameService;
import services.PegawaiService;
import services.ServiceManager;

public class PegawaiFrame extends JFrame implements ActionListener {
	
//	private FrameService pegawaiService;
	private JButton btnGotoMain;
	private JTextArea txtDataContainer;
	
	public PegawaiFrame() {
		super("Pegawai Frame");
		
//		pegawaiService = 
//			ServiceManager.get(PegawaiService.class);
		
		configureFrame();
		initComponents();
	}
	
	private void configureFrame() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(640, 480));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	private void initComponents() {
		btnGotoMain = new JButton("Back to Main");
		btnGotoMain.addActionListener(this);
		
		txtDataContainer = new JTextArea();
		addDataToContainer();
		
		add(txtDataContainer, BorderLayout.CENTER);
		add(btnGotoMain, BorderLayout.NORTH);
		
		pack();
	}
	
	private void addDataToContainer() {
		StringBuffer pegawaiList = new StringBuffer();
//		FrameService service = ServiceManager.get(PegawaiService.class);
				
//		FrameService service = ServiceManager
//			.get(PegawaiService.class);
		
		for (Pegawai pegawai : ServiceManager.getPegawaiService().getData()) {
			pegawaiList.append(pegawai);
		}
		
		txtDataContainer.setText(pegawaiList.toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(btnGotoMain.getText())) {
			ServiceManager.getPegawaiService().hideFrame();
			ServiceManager.getAppService().showFrame();
			
//			ServiceManager.get(PegawaiService.class).hideFrame();
//			ServiceManager.get(AppService.class).showFrame();
		}
	}
}
