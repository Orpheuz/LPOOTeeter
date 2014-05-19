package com.teeter.elems;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Wall extends Element{

	private World world;
	
	public Wall(float x, float y, float width, float height, World world) {
		super(x, y, width, height);
		this.world = world;
	}
	
	public void makeBody() {
		
		BodyDef bodydef = new BodyDef();
		bodydef.type = BodyType.StaticBody;
		bodydef.position.set(position.x, position.y);
		
		PolygonShape shape = new PolygonShape();
		shape.set(new Vector2[] {
				new Vector2((float) (position.x - bounds.getWidth()/2), (float) (position.y -bounds.getHeight()/2)), 
				new Vector2((float) (position.x - bounds.getWidth()/2), (float) (position.y +bounds.getHeight()/2)), 
				new Vector2((float) (position.x + bounds.getWidth()/2), (float) (position.y +bounds.getHeight()/2)), 
				new Vector2((float) (position.x + bounds.getWidth()/2), (float) (position.y -bounds.getHeight()/2))});
		
		FixtureDef def = new FixtureDef();

		def.shape = shape;
		def.friction = 0.5f;
		def.restitution = 0;
		
		world.createBody(bodydef).createFixture(def);
		
	}

}
