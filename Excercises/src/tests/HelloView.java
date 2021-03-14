package tests;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HelloView {
	public HelloView() {
		SwingUtilities.invokeLater(() -> createWindow());
	}
	
	private void createWindow() {
		JFrame frame = new JFrame("Hello");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		
		JLabel label = new JLabel("Hello world!");
		pane.add(label);
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new HelloView();
	}
}
