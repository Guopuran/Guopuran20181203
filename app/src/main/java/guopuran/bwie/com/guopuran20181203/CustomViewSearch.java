package guopuran.bwie.com.guopuran20181203;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class CustomViewSearch extends LinearLayout {
    private Context context;
    private int mChildMaxHeight;
    private int mVSpace=20;
    private int mHSpace=20;
    public CustomViewSearch(Context context) {
        super(context);
        this.context=context;
    }

    public CustomViewSearch(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //得到父窗口的宽高
        int sizewidth=MeasureSpec.getSize(widthMeasureSpec);
        int sizeheight=MeasureSpec.getSize(heightMeasureSpec);
        //测量孩子的高度
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        //找到最高的孩子
        findMaxHeight();
        //初始化
        int left=0,top=0;
        //循环所有的孩子
        int childcount=getChildCount();
        for (int i=0;i<childcount;i++){
            View view=getChildAt(i);
            //是否是一行的开头
            if (left!=0){
                if (left+view.getMeasuredWidth()>sizewidth){
                    //计算下一行的高度
                    top+=mChildMaxHeight+mVSpace;
                    left=0;
                }
            }
            left+=view.getMeasuredWidth()+mHSpace;
        }
        setMeasuredDimension(sizewidth,(top+mChildMaxHeight)>sizeheight?sizeheight:top+mChildMaxHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //找到最高的孩子
        findMaxHeight();
        //初始化
        int left=0,top=0;
        //循环所有的孩子
        int childcount=getChildCount();
        for (int i=0;i<childcount;i++){
            View view=getChildAt(i);
            //是否是一行的开头
            if (left!=0){
                if (left+view.getMeasuredWidth()>getWidth()){
                    //计算下一行的高度
                    top+=mChildMaxHeight+mVSpace;
                    left=0;
                }
            }
            //安排孩子
            view.layout(left,top,left+view.getMeasuredWidth(),top+mChildMaxHeight);
            left+=view.getMeasuredWidth()+mHSpace;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void findMaxHeight() {
        mChildMaxHeight=0;
        int childcount=getChildCount();
        for(int i=0;i<childcount;i++){
            View view=getChildAt(i);
            if (view.getMeasuredHeight()>mChildMaxHeight){
                mChildMaxHeight=view.getMeasuredHeight();
            }
        }
    }
}
