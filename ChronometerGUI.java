

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class ChronometerGUI extends JFrame {
	
	private static final int WIDTH = 600;
	private static final int HEIGHT = 300;
	private JLabel elapseTimeLabel;
	private JButton startButton;
	private JButton finishButton;
	private Chronometer chronometer;
	private Timer timer;
	
	public ChronometerGUI() {
		setTitle("Chronometer GUI Test");
		setSize(WIDTH, HEIGHT);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createContents();
		setVisible(true);
	}
	
	public void createContents() {
		elapseTimeLabel = new JLabel("0:00.00");
		elapseTimeLabel.setFont(new Font("Arial", Font.PLAIN, 140));
		startButton = new JButton("Start");
		startButton.setPreferredSize(new Dimension(480, 50));
		finishButton = new JButton("Finish");
		finishButton.setPreferredSize(new Dimension(480, 50));
		
		add(elapseTimeLabel);
		add(startButton);
		add(finishButton);
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				chronometer = new Chronometer();
				
				timer = new Timer(10, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						elapseTimeLabel.setText(chronometer.getCurrentTime());
					}	
				});
				
				timer.start();
				chronometer.start();
			}
		});
		finishButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chronometer.finish();
				timer.stop();
				elapseTimeLabel.setText(chronometer.getFinishTime());
			}
			
		});
	}
	
}
