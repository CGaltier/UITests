package com.cgaltier.uitests;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class UITests implements ApplicationListener {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	private Stage stage ;
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		//TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		TextureAtlas atlas;
		atlas = new TextureAtlas(Gdx.files.internal("data/AtlasImage.atlas"));
		//sprite = new Sprite(region);
		sprite = atlas.createSprite("back320");
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		stage = new Stage ();
		Gdx.input.setInputProcessor(stage);
		
		Table table = new Table();
		table.setFillParent(true);
		stage.addActor(table);
		
		//TextureRegion upRegion = atlas.findRegion("button32");
		//TextureRegion downRegion = atlas.findRegion("button32");	
		//TextButtonStyle style = new TextButtonStyle();
		BitmapFont buttonFont = new BitmapFont ();

		//style.up = new TextureRegionDrawable (upRegion);
		//style.down=new TextureRegionDrawable (downRegion);
		//style.font = buttonFont;
		NinePatch patch = atlas.createPatch("button32");
		TextButtonStyle style = new TextButtonStyle ();
		style.up = new NinePatchDrawable (patch);
		style.down = new NinePatchDrawable (patch);
		style.font = buttonFont;
		
		//TextButtonStyle style = new TextButtonStyle (patch,patch,patch,0,);// (patch, patch, patch, 0, 0, 0, 0, new BitmapFont(), new Color(0.3f, 0.2f, 0.8f, 1f), new Color(0, 0, 0, 1f), new Color(0, 0, 0, 1f));
		TextButton button1 = new TextButton ("Button 1 - Button 1 - Button 1",style);
		table.add(button1);
		TextButton button2 = new TextButton ("Button 2 - Button 2", style);
		table.add (button2);
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
		stage.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		Table.drawDebug(stage);
	}

	@Override
	public void resize(int width, int height) 
	{
		stage.setViewport (width,height,true);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
