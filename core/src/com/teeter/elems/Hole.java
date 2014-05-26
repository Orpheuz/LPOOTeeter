package com.teeter.elems;

import com.badlogic.gdx.physics.box2d.World;

public class Hole extends Element {
	
	private World world;

	public Hole(float x, float y, float width, float height, World world) {
		super(x, y, width, height);
		this.world = world;
	}
	
	public void makeBody() {
		
		
	}

}
