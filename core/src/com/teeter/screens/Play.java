package com.teeter.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.teeter.elems.Ball;
import com.teeter.elems.Hole;
import com.teeter.elems.Wall;
import com.teeter.game.Teeter;

public class Play extends AbstractScreen {

	static final float WORLD_TO_BOX = 0.01f;
	static final float BOX_TO_WORLD = 100f;
	
	private final float TIMESTEP = 1 / 60f;
	private final int POSITIONITR = 3;
	private final int VELOCITYITR = 8;
	private final int GAME_RUNNING = 1;
	private final int GAME_WON = 2;
	private final int GAME_LOST = 3;

	private Table table;
	private Stage stage;
	private World world;
	private OrthographicCamera camera;
	private Hole hole;
	private Ball ball;
	private Wall wall;
	private SpriteBatch batch;
	private int state = 1;
	private Array<Body> tmpBodies = new Array<Body>();
	private Sprite sprt;

	public Play(Teeter game) {
		super(game);
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		switch(state) {
		case GAME_RUNNING:
			world.step(TIMESTEP, VELOCITYITR, POSITIONITR);
			
			ball.update(delta);
			
			if(ball.getContHole() == 1) {
				state = 3;
				//((Game) Gdx.app.getApplicationListener()).setScreen(new DialogPopup("                 YOU LOSE!"));
			}
			if(ball.getContHole() == 2) {
				state = 2;				
			}
			
			batch.setProjectionMatrix(camera.combined); 
			batch.begin();
			
			sprt.setPosition(-sprt.getWidth()/2, -sprt.getHeight()/2);
			sprt.setScale(WORLD_TO_BOX);
			sprt.draw(batch);
			world.getBodies(tmpBodies);
			Body temp = null;
			for (Body body : tmpBodies) {
				if (body.getFixtureList().get(0).getUserData() != "b") {
					if (body.getUserData() instanceof Sprite) {
						Sprite sprite = (Sprite) body.getUserData();
						sprite.setPosition(body.getPosition().x - sprite.getWidth()
								/ 2, body.getPosition().y - sprite.getHeight() / 2);
						sprite.draw(batch);
					}
				}
				else {
					temp = body;
				}
			}
			if (temp.getUserData() instanceof Sprite) {
				Sprite sprite = (Sprite) temp.getUserData();
				sprite.setPosition(temp.getPosition().x - sprite.getWidth()
						/ 2, temp.getPosition().y - sprite.getHeight() / 2);
				sprite.draw(batch);
			}
			batch.end();
			break;
		case GAME_WON:
			game.setScreen(new DialogPopup(game, "                  YOU WIN!"));
			break;
		case GAME_LOST:
			pause();
			world.step(0, VELOCITYITR, POSITIONITR);
			stage.draw();
			boolean touched = Gdx.input.isTouched();
			ball.setContHole(0);
			if(touched) {
				table.clearChildren();
				state = 1;
				createWorld();
			}
			break;
		}
		//debugRenderer.render(world, camera.combined);
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		createWorld();
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
		batch.dispose();
		stage.dispose();
		sprt.getTexture().dispose();
		world.dispose();
	}
	
	private void createWorld() {
		
		Gdx.input.setInputProcessor(new GestureDetector(new GestureListener() {
			
			@Override
			public boolean zoom(float initialDistance, float distance) {
				return false;
			}
			
			@Override
			public boolean touchDown(float x, float y, int pointer, int button) {
				return false;
			}
			
			@Override
			public boolean tap(float x, float y, int count, int button) {
				return false;
			}
			
			@Override
			public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
					Vector2 pointer1, Vector2 pointer2) {
				return false;
			}
			
			@Override
			public boolean panStop(float x, float y, int pointer, int button) {
				return false;
			}
			
			@Override
			public boolean pan(float x, float y, float deltaX, float deltaY) {
				return false;
			}
			
			@Override
			public boolean longPress(float x, float y) {
				game.setScreen(new MainMenu(game));
				return false;
			}
			
			@Override
			public boolean fling(float velocityX, float velocityY, int button) {
				return false;
			}
		}));
		
		table = new Table();
		stage = new Stage();
		stage.addActor(table);
	
		Label tapScr = new Label("Tap Screen to Retry", new LabelStyle(new BitmapFont(), Color.WHITE));
		tapScr.setFontScale(2);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		table.add(tapScr);
		
		Texture stxt = new Texture("img/background.jpg");
		sprt = new Sprite(stxt);
		batch = new SpriteBatch();
		world = new World(new Vector2(0, 0), true);
		camera = new OrthographicCamera(Gdx.graphics.getWidth() / 100,
				Gdx.graphics.getHeight() / 100);

		// creating the holes
		
		hole = new Hole(2, 1.5f, 0.125f / 4, world, 0);
		hole.makeBody();

		hole = new Hole(1, 0.3f, 0.125f / 4, world, 0);
		hole.makeBody();

		hole = new Hole(0.7f, 0.9f, 0.125f / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole(-0.7f, -0.9f, 0.125f / 4, world, 1);
		hole.makeBody();
		
		// creating the ball and its definitions
		
		ball = new Ball(0, 1, 0.125f, world);
		ball.makeBody();

		// creating the walls

		float borderX = Gdx.graphics.getWidth() / 50;
		float borderY = Gdx.graphics.getHeight() / 9;

		wall = new Wall(0, (-borderY + Gdx.graphics.getHeight() / 2)
				* WORLD_TO_BOX, Gdx.graphics.getWidth() * WORLD_TO_BOX,
				(Gdx.graphics.getHeight() / 18) * WORLD_TO_BOX, world);
		wall.makeBody();

		wall = new Wall(0, (+borderY - Gdx.graphics.getHeight() / 2)
				* WORLD_TO_BOX, Gdx.graphics.getWidth() * WORLD_TO_BOX,
				(Gdx.graphics.getHeight() / 18) * WORLD_TO_BOX, world);
		wall.makeBody();

		wall = new Wall(
				(-borderX + Gdx.graphics.getWidth() / 2) * WORLD_TO_BOX, 0,
				(Gdx.graphics.getHeight() / 18) * WORLD_TO_BOX,
				Gdx.graphics.getHeight() * WORLD_TO_BOX, world);
		wall.makeBody();

		wall = new Wall((borderX - Gdx.graphics.getWidth() / 2) * WORLD_TO_BOX,
				0, (Gdx.graphics.getHeight() / 18) * WORLD_TO_BOX,
				Gdx.graphics.getHeight() * WORLD_TO_BOX, world);
		wall.makeBody();
	}

}
