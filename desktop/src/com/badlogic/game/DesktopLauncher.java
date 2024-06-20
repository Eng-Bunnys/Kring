package com.badlogic.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.game.Kring;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setTitle("Kring");

		config.setForegroundFPS(60);
		config.setIdleFPS(20);
		config.useVsync(true);

		config.setWindowedMode(800, 640);
		config.setWindowIcon("GameLogo.png");

		new Lwjgl3Application(new Kring(), config);
	}
}