package com.cgaltier.uitests;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

import aurelienribon.tweenengine.TweenAccessor;

public class TableAccessor implements TweenAccessor<Table> {

	public static final int WIDTHHEIGHT=1;
	public static final int POSITIONXY=2;
	public static final int ROTATION=3;
	@Override
	public int getValues(Table target, int tweenType, float[] returnValues) 
	{
		switch (tweenType)
		{
		case WIDTHHEIGHT:
			returnValues[0]=target.getWidth();
			returnValues[1]=target.getHeight();
			return 2;
		case POSITIONXY:
			returnValues[0]=target.getOriginX();
			returnValues[1]=target.getOriginY();
			return 2;
		case ROTATION:
			returnValues[0]=target.getRotation();
			return 1;
		}
		return 0;
	}

	@Override
	public void setValues(Table target, int tweenType, float[] newValues) 
	{
		switch (tweenType)
		{
		case WIDTHHEIGHT:
			target.setSize(newValues[0], newValues[1]);
		case POSITIONXY:
			target.setOrigin(newValues[0], newValues[1]);
		case ROTATION:
			target.setRotation(newValues[0]);
		}
		
	}

}
