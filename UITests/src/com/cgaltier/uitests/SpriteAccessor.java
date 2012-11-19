package com.cgaltier.uitests;

import com.badlogic.gdx.graphics.g2d.Sprite;

import aurelienribon.tweenengine.TweenAccessor;

public class SpriteAccessor implements TweenAccessor<Sprite> {

	public static final int WIDTHHEIGHT=1;
	public static final int ROTATION=2;
	@Override
	public int getValues(Sprite target, int tweenType, float[] returnValues) 
	{
		switch (tweenType)
		{
		case 1:
			returnValues[0]=target.getWidth();
			returnValues[1]=target.getHeight();

			return 2;
		case 2:
			returnValues[0]=target.getRotation();
			return 1;
		}
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setValues(Sprite target, int tweenType, float[] newValues) 
	{
		switch (tweenType)
		{
		case 1:
			target.setSize(newValues[0],newValues[1]);
		case 2:
			target.setRotation(newValues[0]);
		}		
	}

}
