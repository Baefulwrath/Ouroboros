import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class UI extends JPanel implements ActionListener {
	
	public JTable table = new JTable();
	public JScrollPane scrollPane = new JScrollPane();
	public int width = 400;
	public int height = 300;
	
	public UI(){
		init(Main.props);
	}
	
	public void init(ArrayList<Setting> p){
		if(getComponentCount() > 0){
			remove(0);
		}
		String[] columnNames = {"Key", "Value"};
		Object[][] data = new Object[p.size()][2];
		for(int i = 0; i < data.length; i++){
			data[i][0] = p.get(i).key;
			data[i][1] = p.get(i).value;
		}
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, width, height);
		scrollPane.setSize(width, height);
		scrollPane.setMinimumSize(new Dimension(width, height));
		scrollPane.setMaximumSize(new Dimension(width, height));
		scrollPane.setPreferredSize(new Dimension(width, height));
		add(scrollPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
