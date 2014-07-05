package plateau;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Plateau {

	public static void main(String[] args) {
		new Plateau().start();
	}

	public void start() {
		createWindow();
	}

	public void createWindow() {
		// Sets up jframe
		JFrame frmMain = new JFrame();
		// sets the gui to be full screen
		frmMain.setExtendedState(Frame.MAXIMIZED_BOTH);
		// sets the minimum size the gui can get to
		frmMain.setMinimumSize(new Dimension(600, 400));
		// The title of the gui
		frmMain.setTitle("Plateau Editor");

		// Creates canvas for map editor
		//Canvas cnvs = new Canvas();
		// sets size
		//cnvs.setSize(800, 400);

		// TODO Remove code
		//cnvs.setBackground(new Color(200, 191, 231));

		// Menu Bar
		createMenuBar(frmMain);

		// Tabs
		// TODO What it do?
		createTabs(frmMain);

		// Custom close handler
		WindowListener exitListener = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				close();
			}
		};
		frmMain.addWindowListener(exitListener);

		//frmMain.add(cnvs);
		frmMain.setLayout(new FlowLayout());
		frmMain.setVisible(true);

		// sets the viewport up for the map editor
		//new PlateauLWJGLHandler().setup(frmMain, cnvs);
	}

	public void close() {
		//int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Close Application?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		//if (confirm == 0) {
			System.exit(0);
		//}
	}

	/**
	 * Creates the main menu for the jframe
	 * 
	 * @param frmMain
	 */
	private void createMenuBar(JFrame frmMain) {
		JMenuBar menuBar = new JMenuBar();

		// TODO have a handler for these button presses
		createBar("File", new JMenuItem[] {
			new JMenuItem("New"),
			new JMenuItem("Open"),
			new JMenuItem(),
			new JMenuItem("Save"),
			new JMenuItem("Save As"),
			new JMenuItem(),
			new JMenuItem("Quit") }, menuBar);

		createBar("Edit", new JMenuItem[] {
			new JMenuItem("Undo"),
			new JMenuItem("Redo"),
			new JMenuItem(),
			new JMenuItem("Cut"),
			new JMenuItem("Copy"),
			new JMenuItem("Paste") }, menuBar);

		// TODO Remove code
		menuBar.setBackground(new Color(34, 177, 76));

		frmMain.setJMenuBar(menuBar);
	}

	/**
	 * Adds menus to the menu bar using an array of menu items
	 * 
	 * @param outerBar
	 * @param items
	 * @param menuBar
	 */
	private void createBar(final String menuMain, JMenuItem[] items, JMenuBar menuBar) {
		JMenu menu = new JMenu(menuMain);

		// for each item in array add to the menu bar as a sub item
		for (final JMenuItem itemList : items) {
			// if the text is null, it will put a separator in instead
			if (itemList.getText().equals("")) {
				menu.addSeparator();
			} else {
				menu.add(itemList);
				itemList.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onClick(menuMain, itemList.getText());
					}
				});
			}
		}

		menuBar.add(menu);
	}

	private void onClick(String menuName, String itemName) {
		if (menuName.equalsIgnoreCase("File") && itemName.equalsIgnoreCase("Quit")) close();
	}

	private void createTabs(JFrame frmMain) {
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JComponent panel1 = makeTextPanel("Panel #1");
		tabbedPane.addTab("Test", null, panel1);
		
		frmMain.add(tabbedPane);
	}

	private JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		panel.setPreferredSize(new Dimension(800, 600));
		return panel;
	}
}
