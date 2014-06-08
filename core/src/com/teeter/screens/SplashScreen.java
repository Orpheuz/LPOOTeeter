package com.teeter.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teeter.game.Teeter;
import com.teeter.tween.SpriteAccessor;


public class SplashScreen extends AbstractScreen {

	private Sprite splsh;
	private SpriteBatch sprtB;
	private TweenManager tweenM;
	
	public SplashScreen(Teeter game) {
		super(game);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		sprtB.begin();
		splsh.draw(sprtB);
		sprtB.end();
		tweenM.update(delta);
	}

	@Override
	public void resize(int width, int height) {
		splsh.setSize(width, height);
	}

	@Override
	public void show() {
		sprtB = new SpriteBatch();
		tweenM = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		
		Texture stxt = new Texture("img/Teeter.jpg");
		splsh = new Sprite(stxt);
		splsh.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Tween.set(splsh, SpriteAccessor.ALPHA).target(0).start(tweenM);
		Tween.to(splsh, SpriteAccessor.ALPHA, 1.5f).target(1).repeatYoyo(1, .5f).setCallback(new TweenCallback() {
			
			@Override
			public void onEvent(int arg0, BaseTween<?> arg1) {
				game.setScreen(new LoadingScreen(game));
			}
		}).start(tweenM);
		
		tweenM.update(Float.MIN_VALUE);
		
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		sprtB.dispose();
		splsh.getTexture().dispose();
	}

}
