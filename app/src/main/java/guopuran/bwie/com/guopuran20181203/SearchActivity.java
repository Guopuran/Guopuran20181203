package guopuran.bwie.com.guopuran20181203;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        init();
    }

    private void init() {
        final CustomViewSearch zuijin=findViewById(R.id.search_zui);
        final CustomViewSearch faxian=findViewById(R.id.faxian);
        final CustomViewTitle title=findViewById(R.id.title);
        final Button qingkong=findViewById(R.id.qingkong);
        title.setButtonClickListener(new CustomViewTitle.OnButtonClickListener() {
            @Override
            public void onButtonClick(String str) {
                final TextView tv=new TextView(SearchActivity.this);
                tv.setTextColor(Color.parseColor("#cccfff"));
                tv.setText(str);
                tv.setTag("aa");
                Dao.getInstance(SearchActivity.this).add(new Bean(tv.getTag().toString(),tv.getText().toString()));
                tv.setBackgroundResource(R.drawable.bd_bg);
                zuijin.addView(tv);
                //点击事件
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(SearchActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        qingkong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dao.getInstance(SearchActivity.this).delete("aa");
                zuijin.removeAllViews();
            }
        });
        for (int i=0;i<25;i++){
            final TextView tt=new TextView(SearchActivity.this);
            tt.setText("数据"+i);
            tt.setBackgroundResource(R.drawable.bd_bg);
            tt.setTextColor(Color.RED);
            tt.setTag("bb");
            faxian.addView(tt);
            Dao.getInstance(SearchActivity.this).add(new Bean(tt.getTag().toString(),tt.getText().toString()));
            tt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(SearchActivity.this,tt.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
