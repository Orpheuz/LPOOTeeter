package com.teeter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.teeter.game.Teeter;

public class LevelMenu extends AbstractScreen {

	private int level;
	
	public LevelMenu(Teeter game) {
		super(game);
		level = 1;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		game.setScreen(new Play(game, level));
	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

}
