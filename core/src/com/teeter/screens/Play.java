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
import com.badlogic.gdx.utils.Json;
import com.teeter.cli.Player;
import com.teeter.elems.Ball;
import com.teeter.game.Teeter;
import com.teeter.worlds.TeeterWorld;

public class Play extends AbstractScreen {

	static final float WORLD_TO_BOX = 0.01f;
	static final float BOX_TO_WORLD = 100f;
	
	private final float TIMESTEP = 1 / 60f;
	private final int POSITIONITR = 3;
	private final int VELOCITYITR = 8;
	private final int GAME_RUNNING = 1;
	private final int GAME_WON = 2;
	private final int GAME_LOST = 3;

	private int level;
	private Ball ball;
	private Table table;
	private Stage stage;
	private World world;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private int state = 1;
	private Array<Body> tmpBodies = new Array<Body>();
	private Sprite sprt;
	private TeeterWorld Tworld;
	private Player player;

	public Play(Teeter game, int level) {
		super(game);
		this.level = level;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		switch (state) {
		case GAME_RUNNING:
			camera.update();

			//world step for collision detection and other stuff
			world.step(TIMESTEP, VELOCITYITR, POSITIONITR);
			
			ball.update(delta);
			
			if(ball.getContHole() == 1) {
				state = 3;
			}
			if(ball.getContHole() == 2) {
				state = 2;
			}
			
			//setting up the projection used by the batch
			batch.setProjectionMatrix(camera.combined); 
			batch.begin();
			
			//drawing background
			sprt.setPosition(-sprt.getWidth()/2, -sprt.getHeight()/2);
			sprt.setScale(WORLD_TO_BOX);
			sprt.draw(batch);
			
			//drawing the bodies
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
			game.setScreen(new DialogPopup(game, "                  YOU WIN!", level));
			player.levelPassed();
			player.write(new Json());
			break;
		case GAME_LOST:
			pause();
			world.step(0, VELOCITYITR, POSITIONITR);
			stage.draw();
			boolean touched = Gdx.input.isTouched();
			if(touched) {
				table.clearChildren();
				state = 1;
				createWorld();
			}
			ball.setContHole(0);
			break;
		}
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

		Json json = new Json();
		
		//loading user data
		player = new Player();
		player.setLevel(json.fromJson(Integer.class, Gdx.files.local("playerData.json")));
		
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
		
		//adding the stage and table with a label
		table = new Table();
		stage = new Stage();
		stage.addActor(table);
	
		Label tapScr = new Label("Tap Screen to Retry", new LabelStyle(new BitmapFont(), Color.WHITE));
		tapScr.setFontScale(2);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		table.add(tapScr);
		
		//initializing the background camera and world
		Texture stxt = new Texture("img/back.jpg");
		sprt = new Sprite(stxt);
		batch = new SpriteBatch();
		world = new World(new Vector2(0, 0), true);
		camera = new OrthographicCamera(Gdx.graphics.getWidth() / 100,
				Gdx.graphics.getHeight() / 100);
		
		Tworld = new TeeterWorld(world);
		Tworld.makeWorld();
		
		float wSize = Gdx.graphics.getWidth();
		float hSize = Gdx.graphics.getHeight();
		float ratio = wSize /  hSize;
		float ballSize = (float) (ratio/11.9);
		
		//worlds
		switch(level) {
		case 1:
			Tworld.makeWorld1();

			ball = new Ball(game, (float) -(wSize/2 * 0.8 * WORLD_TO_BOX), 
					(float) -(hSize/2 * 0.7 * WORLD_TO_BOX), ballSize, world);
			
			ball.makeBody();
			
			break;
		case 2:
			Tworld.makeWorld2();

			ball = new Ball(game, (float) -(wSize / 2 * 0.8 * WORLD_TO_BOX),
					(float) -(hSize / 2 * 0.7 * WORLD_TO_BOX), ballSize, world);

			ball.makeBody();

			break;
		}
	}

}
