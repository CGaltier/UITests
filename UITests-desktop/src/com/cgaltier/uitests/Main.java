package com.cgaltier.uitests;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "UITests";
		cfg.useGL20 = false;
		cfg.width = 480;
		cfg.height = 320;
		Settings settings = new Settings ();
		settings.maxHeight=512;
		settings.maxWidth=512;
		TexturePacker2.process (settings,"../UITests/images/images","../UITests-android/assets/data","AtlasImage");
		new LwjglApplication(new UITests(), cfg);
	}
}
