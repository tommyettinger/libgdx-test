import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ai.pfa.DefaultGraphPath;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
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

		for (int y = 0; y < Tpmap.TOTAL_ROWS; y++) {
			for (int x = 0; x < Tpmap.TOTAL_COLUMNS; x++) {
				TiledNode point = tpmap.getNode(x, y);
				System.out.println("("+x+","+y+") is " + (point == null ? "null" : (point.walkable ? "walkable" : "non-walkable")));
			}
		}
//		System.out.println("start is " + (start == null ? "null" : (start.walkable ? "walkable" : "non-walkable")));
//		System.out.println("end is "   + (end   == null ? "null" : (end.walkable   ? "walkable" : "non-walkable")));

		TiledNode start = tpmap.getNode(8, 6);
		TiledNode end = tpmap.getNode(15, 3);
//		TiledNode start = tpmap.getNode(10, 4);
//		TiledNode end = tpmap.getNode(10, 12);

		Gdx.app.log("", start + " :::::: " + end);
		DefaultGraphPath<TiledNode> path = pathFinder.find(start, end);
		System.out.println("Path found with length " + path.getCount());
		for(TiledNode n : path)
		{
			System.out.println(n);
		}
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
