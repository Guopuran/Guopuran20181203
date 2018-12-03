package guopuran.bwie.com.guopuran20181203;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CustomViewTitle extends LinearLayout {
    private Context context;
    public CustomViewTitle(Context context) {
        super(context);
        this.context=context;
        init();
    }

    public CustomViewTitle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init();
    }

    private void init() {
        //添加布局
        View view=View.inflate(context,R.layout.title,null);
        //获取资源ID
        ImageView imageView=view.findViewById(R.id.search_title);
        final EditText editText=view.findViewById(R.id.edit_title);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onButtonClickListener!=null){
                   onButtonClickListener.onButtonClick(editText.getText().toString());
                }
            }
        });
        addView(view);
    }
    private OnButtonClickListener onButtonClickListener;
    public void setButtonClickListener(OnButtonClickListener onButtonClickListener){
        this.onButtonClickListener=onButtonClickListener;
    }
    public interface OnButtonClickListener{
        void onButtonClick(String str);
    }
}
