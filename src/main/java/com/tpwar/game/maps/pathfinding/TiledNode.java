package com.tpwar.game.maps.pathfinding;

import com.tpwar.game.astar.Connection;

import java.util.ArrayList;

public class TiledNode {

	public int x;
	public int y;
	public int position;
	public long leftZoneId;
	public long rightZoneId;
	public boolean walkable;

	public ArrayList<Connection<TiledNode>> connections = new ArrayList<>(4);
	
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
