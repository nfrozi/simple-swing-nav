package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import model.Pegawai;
import repo.PegawaiRepository;

public class PegawaiFrame extends JFrame implements ActionListener, ComponentListener {
	
	private PegawaiRepository pegawaiRepo;
	private JButton btnGotoMain;
	private JTextArea txtDataContainer;
	
	public PegawaiFrame() {
		super("Pegawai Frame");
		
		pegawaiRepo = new PegawaiRepository();
		
		configureFrame();
		initComponents();
	}
	
	private void configureFrame() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(640, 480));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	private void initComponents() {
		addComponentListener(this);
		
		btnGotoMain = new JButton("Back to Main");
		btnGotoMain.addActionListener(this);
		
		txtDataContainer = new JTextArea();
		txtDataContainer.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
		
		add(txtDataContainer, BorderLayout.CENTER);
		add(btnGotoMain, BorderLayout.NORTH);
		
		pack();
	}
	
	private void loadDataToContainer() {
		StringBuffer pegawaiList = new StringBuffer();

		int no = 1;
		for (Pegawai pegawai : pegawaiRepo.getData()) {
			pegawaiList.append(no + " " + pegawai);
			no++;
		}
		
		txtDataContainer.setText(pegawaiList.toString());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(btnGotoMain.getText())) {
			String baru = String.valueOf(Math.round(Math.random() * 100));
			
			pegawaiRepo.getData().add(new Pegawai(
				baru, 
				"Data Baru " + baru
			));
			App.switchFrame(this, MainFrame.class);
		}
	}

	@Override
	public void componentResized(ComponentEvent e) {}

	@Override
	public void componentMoved(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {
		loadDataToContainer();
	}

	@Override
	public void componentHidden(ComponentEvent e) {}
}
