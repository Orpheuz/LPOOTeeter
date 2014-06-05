package com.teeter.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.teeter.game.Teeter;

public class DialogPopup extends ScreenAdapter {

	private String message;
	private Stage stage;
	private Skin skin;
	protected Teeter game;
	private int level;

	public DialogPopup(Teeter game, String message, int level) {
		this.message = message;
		this.game = game;
		this.level = level;
	}
	
	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage = new Stage());
		skin = game.manager.get("ui/uiskin.json", Skin.class);

		new Dialog("", skin) {

			{
				text("\n" + message + "\n\nDo you want to play again?\n\n");
				button("Yes", "Let's go!");
				button("No", "Ok");
			}

			@Override
			protected void result(final Object object) {
				if (object.toString() != "Ok") {
					game.setScreen(new Play(game, level));
				} else {
					game.setScreen(new LevelMenu(game));
				}
			}

		}.show(stage);
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

}