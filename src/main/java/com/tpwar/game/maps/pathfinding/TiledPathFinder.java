package com.tpwar.game.maps.pathfinding;

import com.tpwar.game.astar.Pathfinder;
import com.tpwar.game.maps.Tpmap;

import java.util.ArrayList;

public class TiledPathFinder {

	private TiledGraph graph;
	private TiledManhattanDistance<TiledNode> heuristic = new TiledManhattanDistance<TiledNode>();
	private Pathfinder<TiledNode> pathFinder;
	public TiledPathFinder(Tpmap map) {
		graph = new TiledGraph(map);
		pathFinder = new Pathfinder<>(graph, false);
	}
	
	public void updateMoveMap() {
		graph.update();
	}
	
	public ArrayList<TiledNode> find(int startX, int startY, int endX, int endY) {
		TiledNode start = graph.getNode(startX, startY);
		TiledNode end =  graph.getNode(endX, endY);
		return find(start, end);
	}
	
	public ArrayList<TiledNode> find(TiledNode start, TiledNode end) {
		ArrayList<TiledNode> outPath = new ArrayList<TiledNode>(2);
		pathFinder.searchNodePath(start, end, heuristic, outPath);
		
		return outPath;
	}

	public TiledGraph getGraph() {
		return graph;
	}

}
