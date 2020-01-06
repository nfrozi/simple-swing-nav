package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import services.AppService;
import services.PegawaiService;
import services.ServiceManager;

public class MainFrame extends JFrame implements ActionListener {

	private JLabel titleLabel;
	private JButton btnEnter;
	
	public MainFrame() {
		super("Aplikasi Oke v1.0");
		
		configure();
		initComponents();
	}
	
	private void configure() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(320, 240));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void initComponents() {
		titleLabel = new JLabel(getTitle());
		titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(this);
		
		add(titleLabel, BorderLayout.CENTER);
		add(btnEnter, BorderLayout.SOUTH);
		pack();
	}
	// 166

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Enter")) {
			ServiceManager.getAppService().hideFrame();
			ServiceManager.getPegawaiService().showFrame();
			
//			ServiceManager.get(AppService.class).hideFrame();
//			ServiceManager.get(PegawaiService.class).showFrame();
		}
	}
}
