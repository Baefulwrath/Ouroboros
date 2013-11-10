import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Main {

	/**
	 * @param args
	 */
	
	public static JFrame frame = new JFrame();
	public static ArrayList<Setting> props = new ArrayList<Setting>();
	public static MenuBar menuBar = new MenuBar();
	public static UI ui = new UI();
	public static final int width = 480;
	public static final int height = 370;
	public static JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
	public static boolean fcUsed = false;
	
	public static void main(String[] args) {
		init();
		run();
	}
	
	public static void init(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setTitle("Config Editor");
		frame.setAlwaysOnTop(true);
		frame.setJMenuBar(menuBar);
		frame.add(ui);
		frame.setDefaultLookAndFeelDecorated(true);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		ui.init(props);
	}
	
	public static void run(){
		while(true){
			try{
				Thread.sleep(25);
				update();
			}catch(Exception ex){
				ex.printStackTrace(System.out);
			}
		}
	}
	
	public static void update()throws Exception{
		ui.updateUI();
	}

	public static void load() {
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter ff = new FileNameExtensionFilter("Properties file", "properties");
		fc.addChoosableFileFilter(ff);
		fc.setFileFilter(ff);
		int returnVal = fc.showDialog(frame, "load");
		if(returnVal == JFileChooser.APPROVE_OPTION){
			try {
				Properties tp = new Properties();
				tp.load(new FileInputStream(fc.getSelectedFile().getAbsolutePath()));
				fcUsed = true;
				inputProperties(tp);
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(frame, "File not found\n" + fc.getSelectedFile().getAbsolutePath(), "File not found", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame, "IO Error", "ERROR", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		}
	}

	private static void inputProperties(Properties tp) {
		props.clear();
        for(Entry<Object, Object> e : tp.entrySet()) {
            props.add(new Setting((String) e.getKey(), (String) e.getValue()));
        }
        updateTable();
	}
	
	public static void updateTable(){
		ui.init(props);
	}
	
	public static void updateProperties(JTable t){
		props.clear();
		for(int i = 0; i < t.getRowCount(); i++){
			props.add(new Setting((String) t.getValueAt(i, 0), (String) t.getValueAt(i, 1)));
		}
		updateTable();
	}

	public static void save() {
		if(fcUsed){
			updateProperties(ui.table);
			Properties p = new Properties();
			String comments = JOptionPane.showInputDialog(frame, "Input comments");
			DataOutputStream stream;
			for(int i = 0; i < props.size(); i++){
				Setting s = props.get(i);
				p.put(s.key, s.value);
			}
			try{
				stream = new DataOutputStream(new FileOutputStream(fc.getSelectedFile().getAbsoluteFile()));
				p.store(stream, comments);
			}catch(Exception ex){
				ex.printStackTrace(System.out);
			}
		}else{
			saveAs();
		}
	}

	public static void CreateTest() {
		Properties p = new Properties();
		p.put("testkey1", "testvalue1");
		p.put("testkey2", "testvalue2");
		p.put("testkey3", "testvalue3");
		p.put("testkey4", "testvalue4");
		DataOutputStream stream;
		try {
			stream = new DataOutputStream(new FileOutputStream(new File("test.properties")));
			p.store(stream, "Test Comment");
		} catch (Exception e) {
			e.printStackTrace();
		}
		inputProperties(p);
	}

	public static void saveAs() {
		updateProperties(ui.table);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter ff = new FileNameExtensionFilter("Properties file", "properties");
		fc.addChoosableFileFilter(ff);
		fc.setFileFilter(ff);
		int returnVal = fc.showDialog(frame, "save");
		
		if(returnVal == JFileChooser.APPROVE_OPTION){
			Properties p = new Properties();
			String comments = JOptionPane.showInputDialog(frame, "Input comments");
			DataOutputStream stream;
			for(int i = 0; i < props.size(); i++){
				Setting s = props.get(i);
				p.put(s.key, s.value);
			}
			try{
				stream = new DataOutputStream(new FileOutputStream(fc.getSelectedFile().getAbsoluteFile()));
				p.store(stream, comments);
			}catch(Exception ex){
				ex.printStackTrace(System.out);
			}
		}
	}
	
	public static void newFile() {
		int size = getRowCountInput("NEW FILE");
		props.clear();
		for(int i = 0; i < size; i++){
			props.add(new Setting("", ""));
		}
		updateTable();
	}
	
	public static int getRowCountInput(String source){
		boolean inputIsInteger = false;
		String input = JOptionPane.showInputDialog(frame, source + "\nSet number of rows");
		int size = 0;
		try{
			size = Integer.parseInt(input);
		}catch(Exception ex){
			while(!inputIsInteger){
				input = JOptionPane.showInputDialog(frame, source + "\nIllogical input, try again");
				try{
					size = Integer.parseInt(input);
					inputIsInteger = true;
				}catch(Exception ex2){
					inputIsInteger = false;
				}
			}
		}
		return size;
	}
	
	public static void editFile() {
		int size = getRowCountInput("EDIT");
		if(size < 0){
			size = -size;
		}
		if(size < props.size()){
			while(props.size() > size){
				props.remove(props.size() - 1);
			}
		} else if(size > props.size()){
			for(int i = props.size(); i < size; i++){
				props.add(new Setting("", ""));
			}
		}
		updateTable();
	}

}
