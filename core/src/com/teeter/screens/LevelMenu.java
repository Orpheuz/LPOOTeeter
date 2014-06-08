package com.teeter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Json;
import com.teeter.cli.Player;
import com.teeter.game.Teeter;

public class LevelMenu extends AbstractScreen {

	private Table table;
	private Stage stage;
	private Skin skin;
	private TextButton button;
	private Player player;
	
	public LevelMenu(Teeter game) {
		super(game);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.15f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		
		Json json = new Json();
		player = new Player();
		if(!Gdx.files.local("playerData.json").exists()) {
			player.write(json);
		}
		player.setLevel(json.fromJson(Integer.class, Gdx.files.local("playerData.json")));
		
		stage = new Stage();
		
		Gdx.input.setInputProcessor(stage);	
		
		skin = game.manager.get("ui/uiskin.json", Skin.class);
		
		table = new Table(skin);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		//adding the buttons
		for(int i = 1; i < 6; i++) {

			final int level = i;
			String levelT;

			if (player.getLevel() >= i ) {
				levelT = Integer.toString(i);
				button = new TextButton(levelT, skin);
				button.addListener(new ClickListener() {
					@Override
					public void clicked(InputEvent event, float x, float y) {
						game.setScreen(new Play(game, level));
					}
				});
			} else {
				levelT = "?";
				button = new TextButton(levelT, skin);
				button.setDisabled(true);
			}
			table.add(button).spaceRight(15).width(70).height(70);
		}

		stage.addActor(table);

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
	}
	

}
