package com.tpwar.game.maps.pathfinding;

import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
import com.badlogic.gdx.ai.pfa.indexed.IndexedAStarPathFinder;
import com.tpwar.game.maps.Tpmap;

public class TiledPathFinder {

	private TiledGraph graph;
	private TiledManhattanDistance<TiledNode> heuristic = new TiledManhattanDistance<TiledNode>();
	private IndexedAStarPathFinder<TiledNode> pathFinder;
	public TiledPathFinder(Tpmap map) {
		graph = new TiledGraph(map);
		pathFinder = new IndexedAStarPathFinder<>(graph, false);
	}
	
	public void updateMoveMap() {
		graph.update();
	}
	
	public DefaultGraphPath<TiledNode> find(int startX, int startY, int endX, int endY) {
		TiledNode start = graph.getNode(startX, startY);
		TiledNode end =  graph.getNode(endX, endY);
		return find(start, end);
	}
	
	public DefaultGraphPath<TiledNode> find(TiledNode start, TiledNode end) {		
		DefaultGraphPath<TiledNode> outPath = new DefaultGraphPath<TiledNode>(2);
		pathFinder.searchNodePath(start, end, heuristic, outPath);
		
		return outPath;		
	}

	public TiledGraph getGraph() {
		return graph;
	}

}
