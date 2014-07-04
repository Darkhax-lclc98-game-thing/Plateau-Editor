package plateau;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
		// on clicking the X close the gui
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// sets the gui to be full screen
		frmMain.setExtendedState(Frame.MAXIMIZED_BOTH);
		// sets the minimum size the gui can get to
		frmMain.setMinimumSize(new Dimension(600, 400));
		// The title of the gui
		frmMain.setTitle("Plateau Editor");

		// Creates canvas for map editor
		Canvas cnvs = new Canvas();
		// sets size
		cnvs.setSize(800, 400);

		// TODO Remove code
		cnvs.setBackground(new Color(200, 191, 231));

		// Menu Bar
		createMenuBar(frmMain);

		// Tabs
		// TODO What it do?
		// createTabs(frmMain);

		frmMain.add(cnvs);
		frmMain.setLayout(new FlowLayout());
		frmMain.setVisible(true);

		// sets the viewport up for the map editor
		new PlateauLWJGLHandler().setup(frmMain, cnvs);
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
	private void createBar(String outerBar, JMenuItem[] items, JMenuBar menuBar) {
		JMenu menu = new JMenu(outerBar);

		// for each item in array add to the menu bar as a sub item
		for (JMenuItem itemList : items) {
			// if the text is null, it will put a separator in instead
			if (itemList.getText().equals("")) {
				menu.addSeparator();
			} else {
				menu.add(itemList);
			}
		}
		
		menuBar.add(menu);
	}

}
