package com.teeter.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.teeter.screens.LevelMenu;
import com.teeter.screens.MainMenu;
import com.teeter.screens.Play;
import com.teeter.screens.SplashScreen;

public class Teeter extends Game {
	
	public AssetManager manager = new AssetManager();
	
	SplashScreen splash;
	LevelMenu lvlMenu;
	MainMenu mainMenu;
	Play play;
	
	@Override
	public void create() {

		setScreen(new SplashScreen(this));
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
