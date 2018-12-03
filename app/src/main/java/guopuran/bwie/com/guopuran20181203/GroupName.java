package guopuran.bwie.com.guopuran20181203;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import org.w3c.dom.Text;

@SuppressLint("AppCompatCustomView")
public class GroupName extends TextView {
    public GroupName(Context context) {
        super(context);
    }

    public GroupName(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GroupName);
        int color = typedArray.getColor(R.styleable.GroupName_textcolor, Color.parseColor("#cccfff"));
        setTextColor(color);
        //回收
        float textsize = typedArray.getDimension(R.styleable.GroupName_textsize, 20);
        setTextSize(textsize);
        typedArray.recycle();
    }
}
