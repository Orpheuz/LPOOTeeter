package com.teeter.cli;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;

public class Player implements Json.Serializable{

	private int level = 1;
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public void levelPassed() {
		level++;
		if(level > 5) 
			level = 5; //actual levels, might change
	}
	
	@Override
	public void write(Json json) {
		//writing json
		
		FileHandle fl = Gdx.files.local("playerData.json");
		String playerD = json.toJson(level, Integer.class);
		fl.writeString(playerD, false);
	}

	@Override
	public void read(Json json, JsonValue jsonData) {
		
	}
	
}
