import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar implements ActionListener{

	protected JMenu file;
	protected JMenuItem newFile;
	protected JMenuItem edit;
	protected JMenuItem exit;
	protected JMenuItem load;
	protected JMenuItem save;
	protected JMenuItem saveAs;
	protected JMenuItem test;
	
	public MenuBar(){
		init();
	}
	
	public void init(){
		file = new JMenu("File");
		file.setMnemonic('f');
		add(file);
		
		
		newFile = new JMenuItem("New File");
		newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newFile.addActionListener(this);
		edit = new JMenuItem("Edit File Properties");
		edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		edit.addActionListener(this);
		load = new JMenuItem("Load Config");
		load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
		load.addActionListener(this);
		save = new JMenuItem("Save Config");
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		save.addActionListener(this);
		saveAs = new JMenuItem("Save As...");
		saveAs.addActionListener(this);
		test = new JMenuItem("Create Test File");
		test.addActionListener(this);
		exit = new JMenuItem("Exit");
		exit.setMnemonic('e');
		exit.addActionListener(this);

		
		file.add(newFile);
		file.add(edit);
		file.addSeparator();
		file.add(load);
		file.add(save);
		file.add(saveAs);
		file.addSeparator();
		file.add(test);
		file.addSeparator();
		file.add(exit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if(s.equals(exit)){
			System.exit(0);
		}else if(s.equals(load)){
			Main.load();
		}else if(s.equals(save)){
			Main.save();
		}else if(s.equals(saveAs)){
			Main.saveAs();
		}else if(s.equals(test)){
			Main.CreateTest();
		}else if(s.equals(newFile)){
			Main.newFile();
		}else if(s.equals(edit)){
			Main.editFile();
		}else{
			System.out.println("wat");
		}
	}
}
