package com.teeter.worlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.World;
import com.teeter.elems.Ball;
import com.teeter.elems.Hole;
import com.teeter.elems.Wall;

public class TeeterWorld {
	static final float WORLD_TO_BOX = 0.01f;
	static final float BOX_TO_WORLD = 100f;
	
	private World world;
	private Hole hole;
	public Ball ball;

	private Wall wall;
	
	public TeeterWorld(World world) {
		this.world = world;
	}
	
	public void makeWorld() {
		
		float wSize = Gdx.graphics.getWidth();
		float hSize = Gdx.graphics.getHeight();
		float ratio = wSize /  hSize;
		float ballSize = (float) (ratio/11.9);
		
		// creating the walls

		
		wall = new Wall(0, -ballSize * 2 + (hSize / 2)
				* WORLD_TO_BOX, wSize * WORLD_TO_BOX,
				50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();

		wall = new Wall(0, ballSize * 2 + (-hSize / 2)
				* WORLD_TO_BOX, wSize * WORLD_TO_BOX,
				50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();

		wall = new Wall(-(wSize / 2) * WORLD_TO_BOX, 0,
				hSize * WORLD_TO_BOX, 50 * WORLD_TO_BOX,
				world, 1);
		wall.makeBody();

		wall = new Wall((wSize / 2) * WORLD_TO_BOX, 0,
				hSize * WORLD_TO_BOX, 50 * WORLD_TO_BOX,
				world, 1);
		wall.makeBody();
	}
	
	public void makeWorld1() {
		float wSize = Gdx.graphics.getWidth();
		float hSize = Gdx.graphics.getHeight();
		float ratio = wSize /  hSize;
		float ballSize = (float) (ratio/11.9);
		
		// creating the holes
		hole = new Hole((float) (wSize/2 * 0.3 * WORLD_TO_BOX), 
				(float) -(hSize/5 * 0.7 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();

		hole = new Hole((float) (wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.7 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();

		hole = new Hole(0.7f, 0.9f, ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.8 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.7 * WORLD_TO_BOX), ballSize / 4, world, 1);
		hole.makeBody();
		
		wall = new Wall(wSize/4 * WORLD_TO_BOX, (float) (hSize / 3.5
				* WORLD_TO_BOX), (float) (wSize * 0.6) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();
		
		wall = new Wall(-wSize/4 * WORLD_TO_BOX, (float) (-hSize / 3.5
				* WORLD_TO_BOX), (float) (wSize * 0.6) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();
		
	}
	
	public void makeWorld2() {
		
	}
	
	public Ball getBall() {
		return ball;
	}
}
