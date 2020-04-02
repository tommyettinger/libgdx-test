package com.tpwar.game.maps.pathfinding;

import com.badlogic.gdx.ai.pfa.Connection;
import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
import com.badlogic.gdx.ai.pfa.indexed.IndexedGraph;
import com.badlogic.gdx.utils.Array;
import com.tpwar.game.maps.Tpmap;

public class TiledGraph extends DefaultGraphPath<TiledNode> implements IndexedGraph<TiledNode> {

	public int width = 20;
	public int height = 15;

	public TiledGraph(Tpmap map) {
		super(Tpmap.TOTAL_ROWS * Tpmap.TOTAL_COLUMNS);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				add(map.getNode(x, y));
			}
		}
	}

	public void update() {
		for (int x = 0; x < width; x++) {
			int idx = x * height;
			for (int y = 0; y < height; y++) {
				TiledNode node = nodes.get(idx + y);
				node.connections.clear();
				if (x > 0) {
					addConnection(node, -1, 0);
				}
				if (y < height - 1) {
					addConnection(node, 0, 1);
				}				
				if (x < width - 1) {
					addConnection(node, 1, 0);
				}
				if (y > 0) {
					addConnection(node, 0, -1);
				}
			}
		}
	}

	private void addConnection(TiledNode node, int x, int y) {
		//if (node.walkable) {
			TiledNode target = getNode(node.x + 1 + x, node.y + y + Tpmap.TOP_BORDER);
			if(target != null && target.walkable)
				getConnections(node).add(new TiledConnection(node, target));
		//}
	}

	public TiledNode getNode(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height)
			return null;
		return nodes.get(x * height + y);
	}

	@Override
	public int getIndex(TiledNode node) {
		return node.getIndex();
	}

	@Override
	public int getNodeCount() {
		return getCount();
	}

	@Override
	public Array<Connection<TiledNode>> getConnections(TiledNode fromNode) {
		return fromNode.connections;
	}

}
