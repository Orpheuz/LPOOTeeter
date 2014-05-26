package com.teeter.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.teeter.elems.Ball;
import com.teeter.elems.Wall;

public class Play implements Screen {

	static final float WORLD_TO_BOX = 0.01f;
	static final float BOX_TO_WORLD = 100f;

	private final float TIMESTEP = 1 / 60f;
	private final int POSITIONITR = 3;
	private final int VELOCITYITR = 8;

	private World world;
	private Box2DDebugRenderer debugRenderer;
	private OrthographicCamera camera;
	private Ball ball;

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		debugRenderer.render(world, camera.combined);

		world.step(TIMESTEP, VELOCITYITR, POSITIONITR);
		
		ball.update(delta);
		camera.update();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		world = new World(new Vector2(0, 0), true);
		debugRenderer = new Box2DDebugRenderer();
		camera = new OrthographicCamera(Gdx.graphics.getWidth() / 100,
				Gdx.graphics.getHeight() / 100);
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			((Game) Gdx.app.getApplicationListener()).setScreen(new MainMenu());
		}

		// creating the ball and its definitions

		ball = new Ball(0, 1, .125f, world);
		ball.makeBody();

		// creating the walls
		float borderX = 60 * WORLD_TO_BOX;
		float borderY = 20 * WORLD_TO_BOX;

		Wall wall = new Wall(0, -borderY + Gdx.graphics.getWidth() / 2 * WORLD_TO_BOX,
				Gdx.graphics.getWidth() * WORLD_TO_BOX,
				Gdx.graphics.getHeight() / 15 * WORLD_TO_BOX, world);
		wall.makeBody();
		System.out.print(Gdx.graphics.getWidth());
		System.out.print(Gdx.graphics.getHeight());
		
//		wall = new Wall(0, -borderX+Gdx.graphics.getHeight() / 2 * WORLD_TO_BOX,
//				Gdx.graphics.getWidth() * WORLD_TO_BOX,
//				Gdx.graphics.getHeight() / 15 * WORLD_TO_BOX, world);
//		wall.makeBody();
//		wall = new Wall(borderY-Gdx.graphics.getWidth() / 2 * WORLD_TO_BOX, 0,
//				Gdx.graphics.getHeight() / 15 * WORLD_TO_BOX,
//				Gdx.graphics.getHeight() * WORLD_TO_BOX, world);
//		wall.makeBody();
//		wall = new Wall(-borderY+Gdx.graphics.getWidth() / 2 * WORLD_TO_BOX, 0,
//				Gdx.graphics.getHeight() / 15 * WORLD_TO_BOX,
//				Gdx.graphics.getHeight() * WORLD_TO_BOX, world);
//		wall.makeBody();
//		wall = new Wall(0, borderX-Gdx.graphics.getHeight() / 2 * WORLD_TO_BOX,
//				Gdx.graphics.getWidth() / 5 * WORLD_TO_BOX,
//				Gdx.graphics.getHeight() / 15 * WORLD_TO_BOX, world);
//		wall.makeBody();
//		wall = new Wall(Gdx.graphics.getWidth() / 5 * WORLD_TO_BOX, borderX-Gdx.graphics.getHeight() / 2 * WORLD_TO_BOX,
//				Gdx.graphics.getWidth() / 5 * WORLD_TO_BOX,
//				Gdx.graphics.getHeight() / 15 * WORLD_TO_BOX, world);
//		wall.makeBody();

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
		world.dispose();
		debugRenderer.dispose();
	}

}
