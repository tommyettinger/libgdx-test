package com.tpwar.game.maps;

import java.util.List;
import java.util.Map;


public class TpmapData {
	public List<LayerData> layers;
	public int[][] moveMap;
	
	public class LayerData {
		public int depth;
		public Map<Integer, TileData> tiles;
		public String className;

		public TileData getTileByPos(int pos){
			for(TileData tile: tiles.values()){
				if(tile.pos == pos)
					return tile;
			}
			return null;
		}
	}
	
	public class TileData {
		public int frame;
		public int pos;
		public int oX;
		public int oY;
	}
}
