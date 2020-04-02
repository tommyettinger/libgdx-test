package com.tpwar.game.maps;

import com.tpwar.game.maps.pathfinding.TiledNode;

public class Tpmap {
	public static final int COLUMNS = 20;
	public static final int ROWS = 15;

	public static final int FOG_OF_WAR = 1;
	public static final int TOP_BORDER = 1;
	public static final int BOTTOM_BORDER = 1;

	public static final int TOTAL_ROWS = ROWS + TOP_BORDER + BOTTOM_BORDER;
	public static final int TOTAL_COLUMNS = COLUMNS + FOG_OF_WAR * 2;

	private TiledNode[][] moveMap;

	public Tpmap() {
		int sizeMap = COLUMNS * ROWS;
		this.moveMap = new TiledNode[TOTAL_ROWS][TOTAL_COLUMNS];
		for (int y = -TOP_BORDER; y < ROWS + BOTTOM_BORDER; y++) {
			int position = sizeMap - COLUMNS - y * COLUMNS;
			for (int x = -1; x < COLUMNS + FOG_OF_WAR; x++) {
				TiledNode node = new TiledNode(x, y, COLUMNS);
				if (x >= 0 && x < COLUMNS && y >= 0 && y < ROWS)
					node.position = position++;
				else
					node.position = -1;
				node.walkable = false;
				this.moveMap[y + TOP_BORDER][x + 1] = node;
			}
		}
	}

	public void updateMoveMap(TpmapData data) {
		for (int x = 0; x < data.moveMap.length; x++) {
			for (int y = 0; y < data.moveMap[x].length; y++) {
				TiledNode node = this.moveMap[ROWS - x][y + 1];
				node.walkable = data.moveMap[x][y] == 0;
			}
		}

		for (int y = 0; y < ROWS; y++) {
			TiledNode node = getNode(0, y + TOP_BORDER);
			node.leftZoneId = 0;
			node = getNode(TOTAL_COLUMNS - 1, y + TOP_BORDER);
			node.rightZoneId = 0;
			// node.walkable = true;
		}
	}

	public TiledNode getNode(int x, int y) {
		if (x < 0 || y < 0 || x >= TOTAL_COLUMNS || y >= TOTAL_ROWS)
			return null;
		return moveMap[y][x];
	}

}
