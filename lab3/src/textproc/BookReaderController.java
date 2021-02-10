package textproc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BookReaderController {
	
	public BookReaderController(GeneralWordCounter counter) {
		SwingUtilities.invokeLater(() -> createWindow(counter, "Bookreader", 100, 300));	
	}
	
	private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		
		SortedListModel<Map.Entry<String, Integer>> list = new SortedListModel<>(counter.getWordList());
		JList<Map.Entry<String, Integer>> listView = new JList<>(list);
		JScrollPane scrollPane = new JScrollPane(listView);
		
		JPanel buttonPanel = new JPanel();
		JRadioButton frequency_button = new JRadioButton("Frequency");
		frequency_button.addActionListener(event -> {
			list.sort((e1, e2) -> e2.getValue() - e1.getValue());
		});
		
		JRadioButton alphabetic_button = new JRadioButton("Alphabetic");
		alphabetic_button.addActionListener(event -> {
			list.sort((e1, e2) -> e1.getKey().compareTo(e2.getKey()));
		});
		
		JTextField searchField = new JTextField(20);
		
		JButton find_button = new JButton("Find");
		
		ActionListener listener = (event -> {
			String search = searchField.getText().strip().toLowerCase();
			int i = 0;
			boolean found = false;
			while(i < list.getSize()) {
				if(search.equals(list.getElementAt(i).getKey())) {
					listView.ensureIndexIsVisible(i);
					found = true;
					break;
				}
			i++;
			}
			if(found) {
				listView.setSelectedIndex(i);	
			} else {
				JOptionPane.showMessageDialog(pane, "Cannot find " + search);
			}
		});
		
		searchField.addActionListener(listener);
		find_button.addActionListener(listener);
		
		ButtonGroup btngroup = new ButtonGroup();
		btngroup.add(frequency_button);
		btngroup.add(alphabetic_button);
	
		buttonPanel.add(alphabetic_button);
		buttonPanel.add(frequency_button);
		buttonPanel.add(searchField);
		buttonPanel.add(find_button);
		
		pane.add(scrollPane);
		pane.add(buttonPanel, BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);	
	}
}
