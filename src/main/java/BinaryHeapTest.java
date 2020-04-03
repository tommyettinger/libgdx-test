import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.math.RandomXS128;
import com.tpwar.game.maps.Tpmap;
import com.tpwar.game.maps.TpmapData;
import com.tpwar.game.maps.pathfinding.TiledNode;
import com.tpwar.game.maps.pathfinding.TiledPathFinder;
import com.tpwar.game.utils.TpmapLoader;

public class BinaryHeapTest extends ApplicationAdapter {

	@Override
	public void create() {

		String fileName = "oseon_1.tpmap";
		FileHandleResolver resolver = new InternalFileHandleResolver();
		AssetManager assetManager = new AssetManager(resolver);
		assetManager.setLoader(TpmapData.class, new TpmapLoader(resolver));
		assetManager.load(fileName, TpmapData.class);
		assetManager.finishLoading();

		TpmapData tpmapData = assetManager.get(fileName);
		Tpmap tpmap = new Tpmap();
		tpmap.updateMoveMap(tpmapData);
		TiledPathFinder pathFinder = new TiledPathFinder(tpmap);
		pathFinder.updateMoveMap();

//		for (int y = 0; y < Tpmap.TOTAL_ROWS; y++) {
//			for (int x = 0; x < Tpmap.TOTAL_COLUMNS; x++) {
//				TiledNode point = tpmap.getNode(x, y);
//				System.out.println("("+x+","+y+") is " + (point == null ? "null" : (point.walkable ? "walkable" : "non-walkable")));
//			}
//		}
		
//		System.out.println("start is " + (start == null ? "null" : (start.walkable ? "walkable" : "non-walkable")));
//		System.out.println("end is "   + (end   == null ? "null" : (end.walkable   ? "walkable" : "non-walkable")));

		TiledNode start = tpmap.getNode(8, 6);
		TiledNode end = tpmap.getNode(15, 3);
//		TiledNode start = tpmap.getNode(10, 4);
//		TiledNode end = tpmap.getNode(10, 12);

		RandomXS128 random = new RandomXS128(123456789L);
		for (int i = 0; i < 100; i++) {
			Gdx.app.log("", start + " :::::: " + end);
			pathFinder.find(start, end);
			start = tpmap.getNode(random.nextInt(Tpmap.COLUMNS)+1, random.nextInt(Tpmap.ROWS)+1);
			end = tpmap.getNode(random.nextInt(Tpmap.COLUMNS)+1, random.nextInt(Tpmap.ROWS)+1);
		}
//		System.out.println("Path found with length " + path.size());
//		for(TiledNode n : path)
//		{
//			System.out.println(n);
//		}
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

}
