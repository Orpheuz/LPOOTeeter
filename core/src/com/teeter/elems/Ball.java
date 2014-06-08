package com.teeter.elems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.teeter.game.Teeter;

public class Ball extends DynamicObject implements ContactListener{

	private Teeter game;
	private World world;
	private float r;
	private Body ball;
	private int contHole = 0;

	public Ball(Teeter game, float x, float y, float r, World world) {
		super(x, y, r, r);
		this.game = game;
		this.world = world;
		this.r = r;
		
		//setting the world contact listener to know ball collisions
		world.setContactListener(this);
	}
	
	public void makeBody() {
		
		//initializing the sprite and its size
		Sprite ballSprite = new Sprite(new Texture("img/sphere.png"));
		ballSprite.setSize(r*2, r*2);
		ballSprite.setOrigin(r/2, r/2);
	
		
		//initializing cicle's bodydef and shape to apply to the fixture
		BodyDef bodydef = new BodyDef();
		bodydef.type = BodyType.DynamicBody;
		bodydef.position.set(position.x, position.y);
		
		CircleShape circle = new CircleShape();
		circle.setRadius(r);
		
		
		//initializing fixture
		FixtureDef def = new FixtureDef();
		def.shape = circle;
		def.density = 6.5f;
		def.friction = .85f;
		def.restitution = 0.15f;
		
		
		//creating the ball setting it's fixture and add to the world
		ball = world.createBody(bodydef);
		ball.createFixture(def);
		ball.getFixtureList().get(0).setUserData("b");
		ball.setUserData(ballSprite);
		circle.dispose();
	}
	
	public void update(float deltaTime) {

		//getting accelM forces and aplying it to the ball
		float acY = Gdx.input.getAccelerometerY();
		float acX = Gdx.input.getAccelerometerX();
		ball.applyForceToCenter(r*5 * acY, r*5 * -acX, true);

		
		//keeping track of balls velocity and position
		velocity.add(acY * deltaTime, -acX * deltaTime);

		position.add(velocity.x * deltaTime, velocity.y * deltaTime);

		bounds.x = position.x - bounds.width / 2;
		bounds.y = position.y - bounds.height / 2;
		
	}

	@Override
	public void beginContact(Contact contact) {
		
		//contact with a normal hole
		if(contact.getFixtureA().getUserData() != null && 
				contact.getFixtureB().getUserData().equals("b") &&
				contact.getFixtureA().getUserData().equals("h")) {
			contHole = 1;
			System.out.println("contactH");
		}
		//contact with the winning hole
		if(contact.getFixtureA().getUserData() != null && 
				contact.getFixtureB().getUserData().equals("b") &&
				contact.getFixtureA().getUserData().equals("wh")) {
			contHole = 2;
			System.out.println("contactWH");
		}
		//contact with a wall
		if(contact.getFixtureA().getUserData() != null && 
				contact.getFixtureB().getUserData().equals("b") &&
				contact.getFixtureA().getUserData().equals("w")) {
			if(game.isVibrate())
				Gdx.input.vibrate(100);
		}
		
	}

	@Override
	public void endContact(Contact contact) {
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		
	}
	
	public int getContHole() {
		return contHole;
	}

	public void setContHole(int contHole) {
		this.contHole = contHole;
	}
	
}
