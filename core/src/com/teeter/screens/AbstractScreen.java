package com.teeter.screens;

import com.badlogic.gdx.Screen;
import com.teeter.game.Teeter;

public abstract class AbstractScreen implements Screen {

	protected Teeter game;

    public AbstractScreen(Teeter game) {
        this.game = game;
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
