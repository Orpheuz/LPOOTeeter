package com.teeter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.teeter.game.Teeter;

public class OptionsMenu extends AbstractScreen {
	
	public OptionsMenu(Teeter game) {
		super(game);
	}

	private Stage stage;
	private Table table;
	private Skin skin;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.15f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
		table.invalidateHierarchy();
	}

	@Override
	public void show() {
		stage = new Stage();

		Gdx.input.setInputProcessor(stage);

		skin = game.manager.get("ui/uiskin.json", Skin.class);

		table = new Table(skin);
		table.setFillParent(true);

		final CheckBox vibrateCheckBox = new CheckBox("               Vibrate", skin);
		vibrateCheckBox.scaleBy(2);
		vibrateCheckBox.setChecked(game.isVibrate());

		ClickListener buttonHandler = new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				if(event.getListenerActor() == vibrateCheckBox) {
					game.setVibrate(!game.isVibrate());
			}
			}
		};

		vibrateCheckBox.addListener(buttonHandler);
		
		final TextButton buttonPlay = new TextButton("BACK", skin);
		buttonPlay.pad(20);
		buttonPlay.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new MainMenu(game));
			}
		});

		
		// putting everything in the table
		table.row();
		table.add(new Label("SETTINGS", skin, "big")).spaceBottom(50).colspan(3).expandX().row();
		table.add(vibrateCheckBox).spaceBottom(10).colspan(4).row();
		table.row().row();
		table.add(buttonPlay).colspan(3);

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