package com.teeter.elems;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class Hole extends Element {

	private World world;
	private float r;
	private Body hole;
	private int holeType;
	private final int NORMAL_HOLE = 0;
	private final int WINNING_HOLE = 1;

	public Hole(float x, float y, float r, World world, int holeType) {
		super(x, y, r, r);
		this.world = world;
		this.r = r;
		this.holeType = holeType;
	}

	public void makeBody() {

		Texture text = null;
		switch (holeType) {
		case NORMAL_HOLE:
			text = new Texture("img/hole.png");
			break;
		case WINNING_HOLE:
			text = new Texture("img/whole.png");
			break;
		}
		Sprite holeSprite = new Sprite(text);
		holeSprite.setSize(r * 9, r * 9);
		holeSprite.setOrigin(r / 2, r / 2);
		BodyDef bodydef = new BodyDef();
		bodydef.type = BodyType.StaticBody;
		bodydef.position.set(position.x, position.y);

		CircleShape circle = new CircleShape();
		circle.setRadius(r);

		FixtureDef def = new FixtureDef();
		def.shape = circle;
		def.isSensor = true; //detects collision but doesnt interact

		hole = world.createBody(bodydef);
		hole.createFixture(def);
		
		//setting different user data so that we can know which hole the ball collided with
		switch (holeType) {
		case NORMAL_HOLE:
			hole.getFixtureList().get(0).setUserData("h");
			break;
		case WINNING_HOLE:
			hole.getFixtureList().get(0).setUserData("wh");
			break;
		}
		hole.setUserData(holeSprite);

		circle.dispose();

	}

}
