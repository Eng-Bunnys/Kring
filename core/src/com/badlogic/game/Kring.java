package com.badlogic.game;

import com.badlogic.game.Graphics.Screens.Screen_MainMenu;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import helper.RelativeScreenPositionService;

public class Kring extends Game {
	public SpriteBatch batch;

	@Override
	public void create() {
		batch = new SpriteBatch();

		this.setScreen(new Screen_MainMenu(this));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		RelativeScreenPositionService.UpdateAbsoluteResolution(width,height);
	}
}
