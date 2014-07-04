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

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

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
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmMain.setMinimumSize(new Dimension(600, 400));
		frmMain.setTitle("Plateau Editor");

		// Creates
		Canvas cnvs = new Canvas();
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

		try {
			Display.setParent(cnvs);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		GL11.glViewport(0, 0, 800, 400);
		
		while (!Display.isCloseRequested()) {
		    Display.update();
		}
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
			new JMenuItem("Quit")}, menuBar);

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

		for (JMenuItem itemList : items) {
			if (itemList.getText().equals("")) {
				menu.addSeparator();
			} else {
				menu.add(itemList);
			}
		}

		menuBar.add(menu);
	}

}
