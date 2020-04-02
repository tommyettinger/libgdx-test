import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl.LwjglFrame;

public class TetsLauncher {
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.backgroundFPS = 0;
		config.title = "test";
		config.fullscreen = false;
		config.resizable = false;
		new LwjglFrame(new BinaryHeapTest(), config);
	}
}
