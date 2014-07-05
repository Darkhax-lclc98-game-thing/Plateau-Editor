package plateau;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glViewport;

import java.awt.Canvas;

import javax.swing.JFrame;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;

public class PlateauLWJGLHandler {

	private boolean running;

	/**
	 * Sets up the glViewport of the map editor
	 * 
	 * @param frmMain
	 * @param cnvs
	 */
	public void setup(JFrame frmMain, Canvas cnvs) {
		try {
			// sets the parent to the canvas
			Display.setParent(cnvs);
			// creates the display
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		// sets up view port of map editor
		glViewport(0, 0, cnvs.getWidth(), cnvs.getHeight());

		// sets the viewport to running
		running = true;

		loop();
	}

	/**
	 * Loops the display
	 */
	private void loop() {
		while (running) {
			// clears the render buffer
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

			// updates the viewport and surrounding gui components
			Display.update();

			// checks if a close request is sent
			isRequestShutdown();
		}
	}

	/**
	 * Checks for close request
	 */
	private void isRequestShutdown() {
		// if close request is sent
		if (Display.isCloseRequested()) {
			// stop running loop
			this.running = false;

			// destroy the lwjgl display
			Display.destroy();
		}
	}

}
