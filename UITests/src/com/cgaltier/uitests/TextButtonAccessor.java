package com.cgaltier.uitests;


import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import aurelienribon.tweenengine.TweenAccessor;

public class TextButtonAccessor implements TweenAccessor<TextButton> 
{
	public static final int WIDTHHEIGHT = 1;
	public static final int ROTATION = 2;
	public static final int POSITIONXY = 3;
	@Override
	public int getValues(TextButton target, int tweenType, float[] returnValues) 
	{
		switch (tweenType)
		{
		case WIDTHHEIGHT:
			// TODO Auto-generated method stub
			returnValues [0] = target.getWidth();
			returnValues [1] = target.getHeight();
			return 2;
			
		case ROTATION:
			// TODO Auto-generated method stub
			returnValues [0] = target.getRotation();			
			return 1;
		case POSITIONXY:
			// TODO Auto-generated method stub
			returnValues [0] = target.getX();
			returnValues [1] = target.getY();
			return 2;			
		}
		return 0;

	}

	@Override
	public void setValues(TextButton target, int tweenType, float[] newValues) 
	{
		switch (tweenType)
		{
		case WIDTHHEIGHT:
			target.setWidth(newValues[0]);
			target.setHeight(newValues[1]);
			break;
		case ROTATION:
			target.setRotation(newValues[0]);
			break;
		case POSITIONXY:
			target.setPosition(newValues[0],newValues[1]);
			break;			
		}

		
	}

}
