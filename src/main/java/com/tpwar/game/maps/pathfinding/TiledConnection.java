package com.tpwar.game.maps.pathfinding;

import com.tpwar.game.astar.DefaultConnection;

public class TiledConnection extends DefaultConnection<TiledNode> {

	public TiledConnection(TiledNode fromNode, TiledNode toNode) {
		super(fromNode, toNode);
	}

	@Override
	public float getCost() {
		return 1;
	}

}
