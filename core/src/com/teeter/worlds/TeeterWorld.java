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
		

		hole = new Hole((float) (wSize/2 * 0.115 * WORLD_TO_BOX),
				(float) (hSize/2 * 0.23 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.2 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.25 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.07 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.6 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.67 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();

		hole = new Hole((float) -(wSize/2 * 0.35 * WORLD_TO_BOX), 
				(float) (-hSize / 13 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.88 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.7 * WORLD_TO_BOX), ballSize / 4, world, 1);
		hole.makeBody();
		
		
		
		
		//draw walls
		
		
		wall = new Wall(-wSize/4 * WORLD_TO_BOX, (float) (hSize / 13
				* WORLD_TO_BOX), (float) (wSize * 0.6) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();

		wall = new Wall(wSize/4 * WORLD_TO_BOX, (float) (-hSize / 13
				* WORLD_TO_BOX), (float) (wSize * 0.6) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();
		
		wall = new Wall(-wSize/4 * WORLD_TO_BOX, (float) (-hSize / 4
				* WORLD_TO_BOX), (float) (wSize * 0.6) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();
		
		wall = new Wall(wSize/4 * WORLD_TO_BOX, (float) (hSize / 4
				* WORLD_TO_BOX), (float) (wSize * 0.6) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();

	}
	
	public void makeWorld2() {
		float wSize = Gdx.graphics.getWidth();
		float hSize = Gdx.graphics.getHeight();
		float ratio = wSize /  hSize;
		float ballSize = (float) (ratio/11.9);
		
		wall = new Wall(-wSize/2.4f * WORLD_TO_BOX, (float) -(hSize / 300
				* WORLD_TO_BOX), (float) (wSize * 0.35) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 1);
		wall.makeBody();
		
		wall = new Wall(wSize/4f * WORLD_TO_BOX, (float) -(hSize / 300
				* WORLD_TO_BOX), (float) (wSize * 0.35) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 1);
		wall.makeBody();
		
		wall = new Wall(-wSize/14f * WORLD_TO_BOX, (float) -(hSize / 300
				* WORLD_TO_BOX), (float) (wSize * 0.35) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 1);
		wall.makeBody();
		
		
		hole = new Hole((float) (wSize/2 * 0.84 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.2 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.84 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.22 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.67 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.835 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.67 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.14 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.71 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		/////
		hole = new Hole((float) -(wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.3 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.75 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.25 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.3 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		/////
		
		hole = new Hole((float) -(wSize/2 * 0.03 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.18 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.3 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.38 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		
		hole = new Hole((float) (wSize/2 * 0.9 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 1);
		hole.makeBody();
		
	}

	

	public void makeWorld3() {
		float wSize = Gdx.graphics.getWidth();
		float hSize = Gdx.graphics.getHeight();
		float ratio = wSize /  hSize;
		float ballSize = (float) (ratio/11.9);
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.14 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.28 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.42 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.42 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.28 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.14 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.3 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.3 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.2 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.2 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.1 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.1 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.01 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.01 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (-wSize/2 * 0.1 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (-wSize/2 * 0.1 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.2 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.2 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.3 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.3 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.56 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.42 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.28 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();		
		
		hole = new Hole((float) -(wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.42 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.28 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();		
		
		hole = new Hole((float) -(wSize/2 * 0.2 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.08 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.2 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.08 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.2 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 1);
		hole.makeBody();
		
	}

	

	public void makeWorld4() {
		float wSize = Gdx.graphics.getWidth();
		float hSize = Gdx.graphics.getHeight();
		float ratio = wSize /  hSize;
		float ballSize = (float) (ratio/11.9);
		
		wall = new Wall(-wSize/4 * WORLD_TO_BOX, (float) (hSize / 5.5
				* WORLD_TO_BOX), (float) (wSize * 0.8) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();

		wall = new Wall(wSize/4 * WORLD_TO_BOX, (float) (-hSize / 5.5
				* WORLD_TO_BOX), (float) (wSize * 0.8) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();
		
		wall = new Wall(wSize/7 * WORLD_TO_BOX, (float) (hSize / 8.5
				* WORLD_TO_BOX), (float) (wSize * 0.09) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 1);
		wall.makeBody();
		
		wall = new Wall(-wSize/7f * WORLD_TO_BOX, (float) (-hSize / 8.5
				* WORLD_TO_BOX), (float) (wSize * 0.09) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 1);
		wall.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.22 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.22 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.6 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.45 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.2 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.45 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.2 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.45 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.01 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.7 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.7 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.6 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.45 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.2 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.45 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.2 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.45 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.01 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.7 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.7 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.625 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.2 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.725 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.2125 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.625 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.2 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.725 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.2125 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.85 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.7 * WORLD_TO_BOX), ballSize / 4, world, 1);
		hole.makeBody();
		
	}
	

	public void makeWorld5() {
		float wSize = Gdx.graphics.getWidth();
		float hSize = Gdx.graphics.getHeight();
		float ratio = wSize /  hSize;
		float ballSize = (float) (ratio/11.9);
		
		wall = new Wall(wSize/4* WORLD_TO_BOX, (float) (-hSize / 40
				* WORLD_TO_BOX), (float) (wSize * 0.32) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 1);
		wall.makeBody();
		
		wall = new Wall(-wSize/50* WORLD_TO_BOX, (float) (-hSize / 6
				* WORLD_TO_BOX), (float) (wSize * 0.14) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 1);
		wall.makeBody();
		
		wall = new Wall(-wSize/4* WORLD_TO_BOX, (float) (-hSize / 9
				* WORLD_TO_BOX), (float) (wSize * 0.43) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 1);
		wall.makeBody();
		
		wall = new Wall(-wSize/40000* WORLD_TO_BOX, (float) (hSize / 4.33
				* WORLD_TO_BOX), (float) (wSize * 0.5) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();
		
		wall = new Wall(wSize/8.6f* WORLD_TO_BOX, (float) (-hSize / 3.5
				* WORLD_TO_BOX), (float) (wSize * 0.283) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();
		
		wall = new Wall(wSize/17* WORLD_TO_BOX, (float) (-hSize / 15.8
				* WORLD_TO_BOX), (float) (wSize * 0.15) * WORLD_TO_BOX,
				hSize / 50 * WORLD_TO_BOX, world, 0);
		wall.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.88 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.35 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.88 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.35 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.05 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.35 * WORLD_TO_BOX), ballSize / 4, world, 1);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.88 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.35 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.88 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.35 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.59 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.59 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.44 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.13 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.35 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.5 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.7 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.3 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.55 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) -(wSize/2 * 0.4 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.69 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.05 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.2 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.3 * WORLD_TO_BOX), 
				(float) (hSize/2 * 0.01 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
		
		hole = new Hole((float) (wSize/2 * 0.3 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.3 * WORLD_TO_BOX), ballSize / 4, world, 0);
		hole.makeBody();
	
		hole = new Hole((float) (wSize/2 * 0.05 * WORLD_TO_BOX), 
				(float) -(hSize/2 * 0.35 * WORLD_TO_BOX), ballSize / 4, world, 1);
		hole.makeBody();

	}	
	
	public Ball getBall() {
		return ball;
	}
	
}