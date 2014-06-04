package com.teeter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.teeter.game.Teeter;

public class MainMenu extends AbstractScreen {

	private Stage stage;
	private Skin skin;
	private Table table;
	private Sprite splsh;
	private SpriteBatch sprtB;
	private Label heading;
	private TextButton buttonPlay, buttonOpt, buttonExit;
	
	public MainMenu(Teeter game) {
		super(game);
		this.game = game;
	}
	
	public void asd() {
		skin = game.manager.get("ui/uiskin.json", Skin.class);
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		//setting up stage and stuff
		stage = new Stage();
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);	
		
		//heading
		heading = new Label("Teeter", skin, "big");
		heading.setFontScale(2);
		
		//buttons
		
		buttonPlay = new TextButton("PLAY", skin);
		buttonPlay.pad(20);
		buttonPlay.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new Play(game));
			}
		});

		buttonOpt = new TextButton("OPTIONS", skin);
		buttonOpt.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new DialogPopup(game, "                  YOU WIN!"));
			}
		});
		buttonOpt.pad(20);

		buttonExit = new TextButton("EXIT", skin);
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
	
		sprtB = new SpriteBatch();
		Texture stxt = new Texture("img/metal.jpg");
		splsh = new Sprite(stxt);
		splsh.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		sprtB.begin();
		splsh.draw(sprtB);
		sprtB.end();
		
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		asd();
		stage.getViewport().update(width, height, true);
		table.invalidateHierarchy();
	}

	@Override
	public void show() {
		
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
		 stage.dispose();
	}

}
