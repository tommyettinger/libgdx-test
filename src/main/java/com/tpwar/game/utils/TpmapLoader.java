package com.tpwar.game.utils;

import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.AsynchronousAssetLoader;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.google.gson.Gson;
import com.tpwar.game.maps.TpmapData;

public class TpmapLoader extends AsynchronousAssetLoader<TpmapData, TpmapLoader.TpmapParameter> {

	private TpmapData data;
	public TpmapLoader(FileHandleResolver resolver) {
		super(resolver);
	}

	@Override
	public void loadAsync(AssetManager manager, String fileName, FileHandle file, TpmapParameter parameter) {
		data = null;
		Gson gson = new Gson();
		data = gson.fromJson(file.readString(), TpmapData.class);		
	}

	@Override
	public TpmapData loadSync(AssetManager manager, String fileName, FileHandle file, TpmapParameter parameter) {
		TpmapData data = this.data;
		this.data = null;
		return data;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Array getDependencies(String fileName, FileHandle file, TpmapParameter parameter) {
		return null;
	}
	
	static public class TpmapParameter extends AssetLoaderParameters<TpmapData> {
	}
}
