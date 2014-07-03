package plateau;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMain.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmMain.setTitle("Plateau Editor");

		// Creates
		Canvas cnvs = new Canvas();
		cnvs.setSize(400, 400);

		// TODO Remove code
		cnvs.setBackground(new Color(200, 191, 231));

		// Menu Bar
		createMenuBar(frmMain);

		// Tabs
		createTabs(frmMain);

		frmMain.add(cnvs);
		frmMain.setVisible(true);
	}

	private void createMenuBar(JFrame frmMain) {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("A Menu");
		JMenuItem menuItem = new JMenuItem("Test");

		// TODO Remove code
		menuBar.setBackground(new Color(34, 177, 76));

		menu.add(menuItem);
		menuBar.add(menu);
		frmMain.setJMenuBar(menuBar);
	}

	private void createTabs(JFrame frmMain) {
		JTabbedPane tabbedPane = new JTabbedPane();
		JComponent panel1 = makeTextPanel("Panel #1");
		tabbedPane.addTab("Test", null, panel1);
		frmMain.add(tabbedPane);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	}

	protected JComponent makeTextPanel(String text) {
		JPanel panel = new JPanel(false);
		JLabel filler = new JLabel(text);
		filler.setHorizontalAlignment(JLabel.CENTER);
		panel.setLayout(new GridLayout(1, 1));
		panel.add(filler);
		return panel;
	}
}
