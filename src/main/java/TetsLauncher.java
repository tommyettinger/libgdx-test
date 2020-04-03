import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class TetsLauncher {
	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.backgroundFPS = 0;
		config.title = "test";
		config.fullscreen = false;
		config.resizable = false;
		new LwjglApplication(new BinaryHeapTest(), config);
	}
}
