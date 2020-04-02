package com.tpwar.game.maps.pathfinding;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.utils.Array;

public class TiledNode {

	public int x;
	public int y;
	public int position;
	public long leftZoneId;
	public long rightZoneId;
	public boolean walkable;

	public Array<Connection<TiledNode>> connections = new Array<>(4);
	
	private int height;
	public TiledNode(int x, int y, int height) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
	}

	public boolean hasZone() {
		return leftZoneId > 0 || rightZoneId > 0;
	}

	public int getIndex() {
		return y * height + x;
	}

	@Override
	public String toString() {
		return "TiledNode{" +
				"x=" + x +
				", y=" + y +
				", position=" + position +
				'}';
	}
}
