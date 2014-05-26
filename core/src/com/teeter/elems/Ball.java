package com.teeter.elems;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Ball extends DynamicObject {

	private World world;
	private float r;
	private Body ball;
	
	public Ball(float x, float y, float r, World world) {
		super(x, y, r, r);
		this.world = world;
		this.r = r;
	}
	
	public void makeBody() {
		
		BodyDef bodydef = new BodyDef();
		bodydef.type = BodyType.DynamicBody;
		bodydef.position.set(position.x, position.y);
		
		CircleShape circle = new CircleShape();
		circle.setRadius(r);
		
		FixtureDef def = new FixtureDef();
		def.shape = circle;
		def.density = 2.5f;
		def.friction = 5.75f;
		def.restitution = 0.2f;
		
		ball = world.createBody(bodydef);
		ball.createFixture(def);

		circle.dispose();
	}
	
	public void update(float deltaTime) {

		float acY = Gdx.input.getAccelerometerY();
		float acX = Gdx.input.getAccelerometerX();
		ball.applyForceToCenter(acY, -acX, true);

		velocity.add(acY * deltaTime, -acX * deltaTime);

		position.add(velocity.x * deltaTime, velocity.y * deltaTime);

		bounds.x = position.x - bounds.width / 2;
		bounds.y = position.y - bounds.height / 2;
		
	}
}
