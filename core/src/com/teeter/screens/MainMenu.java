package com.teeter.screens;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.teeter.tween.ActorAccessor;
import com.teeter.tween.SpriteAccessor;

public class MainMenu implements Screen {

	private TweenManager tweenM;
	private Stage stage;
	private TextureAtlas atlas;
	private Skin skin;
	private Table table;
	private Sprite splsh;
	private SpriteBatch sprtB;
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		sprtB.begin();
		splsh.draw(sprtB);
		sprtB.end();
		
		stage.act(delta);
		stage.draw();

		tweenM.update(delta);
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		table.invalidateHierarchy();
	}

	@Override
	public void show() {
		
		sprtB = new SpriteBatch();
		tweenM = new TweenManager();
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		Texture stxt = new Texture("img/metal.png");
		splsh = new Sprite(stxt);
		splsh.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		//setting up stage and stuff
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		atlas = new TextureAtlas("ui/button.pack");
		skin = new Skin(Gdx.files.internal("ui/menuSkin.json"), atlas);
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		//heading
		Label heading = new Label("Teeter", skin, "big");
		heading.setFontScale(2);
		
		//buttons
		
		TextButton buttonPlay = new TextButton("PLAY", skin);
		buttonPlay.pad(20);
		buttonPlay.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				((Game) Gdx.app.getApplicationListener()).setScreen(new Play());
			}
		});
		
		TextButton buttonOpt = new TextButton("OPTIONS", skin);
		buttonOpt.pad(20);
		
		TextButton buttonExit = new TextButton("EXIT", skin);
		buttonExit.pad(20);
		buttonExit.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.exit();
			}
		});
		
		
		//adding stuff
		table.add(heading);
		table.getCell(heading).spaceBottom(100);
		table.row();
		table.add(buttonPlay);
		table.getCell(buttonPlay).spaceBottom(20);
		table.row();
		table.add(buttonOpt);
		table.getCell(buttonOpt).spaceBottom(20);
		table.row();
		table.add(buttonExit);
		table.row();
		stage.addActor(table);
		
		//animations
		Tween.registerAccessor(Actor.class, new ActorAccessor());
		
		Timeline.createSequence().beginSequence()
		.push(Tween.to(heading, ActorAccessor.RGB, .5f).target(0, 0, 1))
		.push(Tween.to(heading, ActorAccessor.RGB, .5f).target(0, 1, 0))
		.push(Tween.to(heading, ActorAccessor.RGB, .5f).target(0, 1, 1))
		.push(Tween.to(heading, ActorAccessor.RGB, .5f).target(1, 0, 0))
		.push(Tween.to(heading, ActorAccessor.RGB, .5f).target(1, 0, 1))
		.push(Tween.to(heading, ActorAccessor.RGB, .5f).target(1, 1, 0))
		.push(Tween.to(heading, ActorAccessor.RGB, .5f).target(1, 1, 1))
		.end().repeat(Tween.INFINITY, 0).start(tweenM);
		
		Timeline.createSequence().beginSequence()
		.push(Tween.set(buttonOpt, ActorAccessor.ALPHA).target(0))
		.push(Tween.set(buttonExit, ActorAccessor.ALPHA).target(0))
		.push(Tween.from(heading, ActorAccessor.ALPHA, .25f).target(0))
		.push(Tween.to(buttonPlay, ActorAccessor.ALPHA, .25f).target(1))
		.push(Tween.to(buttonOpt, ActorAccessor.ALPHA, .25f).target(1))
		.push(Tween.to(buttonExit, ActorAccessor.ALPHA, .25f).target(1))
		.end().start(tweenM);
		
		Tween.from(table, ActorAccessor.ALPHA, .5f).target(0).start(tweenM);
		Tween.from(table, ActorAccessor.Y, .5f).target(Gdx.graphics.getHeight() / 8).start(tweenM);
	 
		tweenM.update(Gdx.graphics.getDeltaTime());
		
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
		stage.dispose();
		atlas.dispose();
		skin.dispose();
		sprtB.dispose();
		splsh.getTexture().dispose();
	}

}
