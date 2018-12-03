package guopuran.bwie.com.guopuran20181203;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Dao {
    private static Dao instance;
    private SqliteHelper helper;
    private SQLiteDatabase sb;
    private Dao(Context context){
        helper=new SqliteHelper(context);
        sb=helper.getReadableDatabase();
    }
    public static Dao getInstance(Context context){
        if (instance==null){
            instance=new Dao(context);
        }
        return instance;
    }
    //添加
    public void add(Bean bean){
        ContentValues values=new ContentValues();
        values.put("tag",bean.getTag());
        values.put("name",bean.getName());
        sb.insert("users",null,values);
    }
    public void delete(String tag){
        sb.delete("users","tag=?",new String[]{tag});
    }
}
