package com.teeter.elems;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Wall extends Element{

	private World world;
	private Body wall;
	private int dir;
	final static int UP = 0;
	final static int DOWN = 1;
	
	public Wall(float x, float y, float width, float height, World world, int dir) {
		super(x, y, width, height);
		this.world = world;
		this.dir = dir;
	}
	
	public void makeBody() {
		Texture text;
		Sprite wallSprite;
		text = new Texture("img/wall.jpg");
		wallSprite = new Sprite(text);
		wallSprite.setSize(bounds.getWidth(), bounds.getHeight());
		wallSprite.setOrigin(bounds.getWidth()/2, bounds.getHeight()/2);
		
		BodyDef bodydef = new BodyDef();
		bodydef.type = BodyType.StaticBody;
		bodydef.position.set(position.x, position.y);
		
		if(dir == DOWN) {
			wallSprite.rotate(-90);
			bodydef.angle = (float) (Math.PI/2);
		}

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(bounds.width/2, bounds.height/2);
		
		FixtureDef def = new FixtureDef();

		def.shape = shape;
		def.friction = 0.5f;
		def.restitution = 0;
		wall = world.createBody(bodydef);
		wall.createFixture(def);
		wall.getFixtureList().get(0).setUserData("w");
		wall.setUserData(wallSprite);
		
		shape.dispose();
		
	}

}
