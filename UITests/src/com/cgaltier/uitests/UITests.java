package com.cgaltier.uitests;

import aurelienribon.tweenengine.TweenManager;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.equations.Bounce;
import aurelienribon.tweenengine.equations.Linear;

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
	private TweenManager tweener ;

	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		tweener = new TweenManager ();
		Tween.registerAccessor(TextButton.class, new TextButtonAccessor());
		Tween.registerAccessor(Sprite.class, new SpriteAccessor());
		Tween.registerAccessor(Table.class, new TableAccessor());
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		//TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		TextureAtlas atlas;
		atlas = new TextureAtlas(Gdx.files.internal("data/AtlasImage.atlas"));
		//sprite = new Sprite(region);
		sprite = atlas.createSprite("back320");
		sprite.setSize(1.2f, 1.2f * sprite.getHeight() / sprite.getWidth());
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
		NinePatch patchU = atlas.createPatch("button32");
		NinePatch patchD = atlas.createPatch("button32d");
		TextButtonStyle style = new TextButtonStyle ();
		style.up = new NinePatchDrawable (patchU);
		style.down = new NinePatchDrawable (patchD);
		style.font = buttonFont;
		
		
		/*Table table1 = new Table();
		Table table2 = new Table();
		Table table3 = new Table();
		Table table4 = new Table();
		Table table5 = new Table();
		
		table.addActor(table1);
		table.addActor(table2);
		table.addActor(table3);
		table.addActor(table4);
		table.addActor(table5);*/
		
		//TextButtonStyle style = new TextButtonStyle (patch,patch,patch,0,);// (patch, patch, patch, 0, 0, 0, 0, new BitmapFont(), new Color(0.3f, 0.2f, 0.8f, 1f), new Color(0, 0, 0, 1f), new Color(0, 0, 0, 1f));
		TextButton button1 = new TextButton ("Button 1",style);
		//table1.add(button1);
		table.add (button1);
		TextButton button2 = new TextButton ("Button 2", style);
		//table2.add (button2);
		table.add (button2);
		TextButton button3 = new TextButton ("Button 3", style);
		//table3.add (button3);
		table.add (button3);
		TextButton button4 = new TextButton ("Button 4", style);
		//table4.add (button4);
		table.add (button4);
		TextButton button5 = new TextButton ("Button 5", style);
		//table5.add (button5);
		table.add (button5);
		/*

		Tween.to(button2, TextButtonAccessor.WIDTHHEIGHT, 3.0f)
		.target(Height, Width)
	    .ease(Linear.INOUT)
	    //.delay(1.0f)
	    //.repeatYoyo(Tween.INFINITY, 0.5f)
	    .start(tweener);
		
		float Rotation = 180.0f;
		Tween.to(button3, TextButtonAccessor.ROTATE, 3.0f)
		.target(Rotation)
	    .ease(Linear.INOUT)
	    //.delay(1.0f)
	    //.repeatYoyo(Tween.INFINITY, 0.5f)
	    .start(tweener);		*/
		
		float spriteRotation = 360.0f;
		Tween.to(sprite,SpriteAccessor.ROTATION, 30.0f).target(spriteRotation).repeat(Tween.INFINITY, 0.0f).ease(Linear.INOUT).start(tweener);
		
		Tween.to(button1,TextButtonAccessor.ROTATION, 30.0f).target(spriteRotation).repeat(Tween.INFINITY, 0.0f).ease(Linear.INOUT).start(tweener);
	
		float Height = 64.0f;
		float Width = 200.0f;
		Tween.to(button1, TextButtonAccessor.WIDTHHEIGHT, 3.0f).target(button1.getWidth(), Height).repeatYoyo(Tween.INFINITY, 0.0f).ease(Linear.INOUT).start(tweener);
		Tween.to(button2, TextButtonAccessor.WIDTHHEIGHT, 3.0f).target(Width, Height).repeatYoyo(Tween.INFINITY, 0.0f).ease(Bounce.OUT).start(tweener);
		Tween.from(button3, TextButtonAccessor.POSITIONXY, 3.0f).target(button3.getX(), button3.getY()+60.0f).repeatYoyo(Tween.INFINITY, 0.0f).ease(Bounce.INOUT).start(tweener);
		
		//Tween.to(table1, TableAccessor.POSITIONXY, 3.0f).target(100.0f, 100.0f).repeatYoyo(Tween.INFINITY, 0.0f).ease(Bounce.INOUT).start(tweener);
		
		/*Tween.to(button1, 0, 3.0f)
	    .target(button1.getHeight()+30.0f, button1.getWidth()+10.0f)
	    .ease(Bounce.INOUT)
	    .delay(1.0f)
	    .repeatYoyo(Tween.INFINITY, 0.5f)
	    .start(tweener);
		
		Tween.to(button3, 0, 3.0f)
	    .target(button3.getHeight()+30.0f, button3.getWidth()+10.0f)
	    .ease(Bounce.IN)
	    .delay(1.0f)
	    .repeatYoyo(Tween.INFINITY, 0.5f)
	    .start(tweener);*/
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
		stage.dispose();
	}

	@Override
	public void render() {		
		tweener.update(Gdx.graphics.getDeltaTime());
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
