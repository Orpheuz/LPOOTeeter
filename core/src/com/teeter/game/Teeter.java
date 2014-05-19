package com.teeter.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.teeter.screens.SplashScreen;

public class Teeter extends Game {
	
	static final float WORLD_TO_BOX = 0.01f;
	static final float BOX_TO_WORLD = 100f;
	
	@Override
	public void create() {
		setScreen(new SplashScreen());
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);
	}

	@Override
	public Screen getScreen() {
		return super.getScreen();
	}
}
