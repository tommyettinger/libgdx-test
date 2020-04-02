package com.tpwar.game.maps.pathfinding;

import com.badlogic.gdx.ai.pfa.DefaultConnection;

public class TiledConnection extends DefaultConnection<TiledNode> {

	public TiledConnection(TiledNode fromNode, TiledNode toNode) {
		super(fromNode, toNode);
	}

	@Override
	public float getCost() {
		return 1;
	}

}
