package it.apogeo.sushi.resactlay.layouttest.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Massimo Carli - 24/ott/2012
 *
 */
public class MyLayout extends ViewGroup {
	
	/*
	 * The Width of each View in this Layout
	 */
	private int mViewWidth;

	public MyLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public MyLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MyLayout(Context context) {
		super(context);
	}

	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int childCount = getChildCount();
		if(childCount==0){
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}else{
			// We share the space with the contained View
			int widthSize = MeasureSpec.getSize(widthMeasureSpec);
			// We use only the information about the width
			mViewWidth = widthSize/childCount;
			// We calculate the dimension of the layout component base on the contained components
			int measuredWidth = MeasureSpec.makeMeasureSpec(widthSize, MeasureSpec.EXACTLY);
			// We set the dimension for this layout
			setMeasuredDimension(measuredWidth, heightMeasureSpec);
		}
	}
	
	/* (non-Javadoc)
	 * @see android.view.ViewGroup#onLayout(boolean, int, int, int, int)
	 */
	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		// If layout is changed we recalculate it
		if(changed){
			for(int i=0;i<getChildCount();i++){
				View child = getChildAt(i);
				int viewLeft = i*mViewWidth;
				child.layout(viewLeft, top, viewLeft+mViewWidth, bottom);
			}
		}
	}

}
