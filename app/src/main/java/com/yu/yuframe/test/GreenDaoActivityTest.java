package com.yu.yuframe.test;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.yu.greendao.Note;
import com.yu.greendao.NoteDao;
import com.yu.yuframe.GlobalApplication;
import com.yu.yuframe.R;
import com.yu.yuframe.ui.BaseActivity;

import java.text.DateFormat;
import java.util.Date;

import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

/**
 * GreenDao数据库测试类如果需要修改改变表内容需要到  greendaogenerator 的 MODULE
 * GreenDaoGenerator类下修改
 * <p/>
 * Created by Yu on 2016/4/15.
 * Email:zhaoshiyu900310@163.com
 */
public class GreenDaoActivityTest extends BaseActivity implements View.OnClickListener {
    // TODO 官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
//    private DaoMaster daoMaster;
//    private DaoSession daoSession;
    private Cursor cursor;
    public static final String TAG = "GreenDaoAcTest";


    private android.widget.EditText testgreendaoactivitytesteditTextNote;
    private android.widget.Button testgreendaoactivitytestbuttonAdd;
    private android.widget.Button testgreendaoactivitytestbuttonSearch;
    private android.widget.ListView testgreendaoactivitytestlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_greendao_activity_test);
//        初始化xml
        initXml();
// 获取 NoteDao 对象
        String textColumn = NoteDao.Properties.Text.columnName;
        String orderBy = textColumn + " COLLATE LOCALIZED ASC";
        cursor = GlobalApplication.getDb().query(getNoteDao().getTablename(), getNoteDao().getAllColumns(), null, null,
                null, null, orderBy);
        String[] from = {textColumn, NoteDao.Properties.Comment.columnName};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout
                .simple_list_item_2, cursor, from,
                to);


//   TODO   单击  ListView 的监听事件，用于删除一个 Item

        testgreendaoactivitytestlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getNoteDao().deleteByKey(id);
                //删除所有
                // getNoteDao().deleteAll();
                Log.d(TAG, "单击了第" + position + "个按钮");
                Log.d(TAG, "Deleted note, ID: " + id);
                cursor.requery();
            }
        });


        //   TODO   长按  ListView 的监听事件，用于弹出一个dialog可以修改数据 Item
        testgreendaoactivitytestlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, final long
                    id) {
                Log.d(TAG, "长按了第" + position + "个按钮");
                View view_dialog = LayoutInflater.from(getApplicationContext()).inflate(R.layout
                        .test_greendao_activity_dialog, null);
                final EditText editText_dialog = (EditText) view_dialog.findViewById(R.id
                        .test_greendao_activity_edit_text_dialog);
                editText_dialog.setText(testgreendaoactivitytesteditTextNote.getText());
                Log.d(TAG, "editText:" + testgreendaoactivitytesteditTextNote);
                AlertDialog.Builder builder = new AlertDialog.Builder(GreenDaoActivityTest.this);
                builder.setView(view_dialog).setTitle("修改数据")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("提交修改", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String string = String.valueOf(editText_dialog.getText());
                                final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat
                                        .MEDIUM);
                                String comment = "Added on " + df.format(new Date());
                                Note note = new Note(id, string, comment, new Date());

                                getNoteDao().insertOrReplace(note);
                                cursor.requery();

                            }
                        });
                builder.create().show();
                return true;
            }
        });


        testgreendaoactivitytestlist.setAdapter(adapter);
    }

    private void initXml() {
        this.testgreendaoactivitytestlist = (ListView) findViewById(R.id.test_greendao_activity_test_listview);
        this.testgreendaoactivitytestbuttonSearch = (Button) findViewById(R.id
                .test_greendao_activity_test_buttonSearch);
        this.testgreendaoactivitytestbuttonAdd = (Button) findViewById(R.id.test_greendao_activity_test_buttonAdd);
        this.testgreendaoactivitytesteditTextNote = (EditText) findViewById(R.id
                .test_greendao_activity_test_editTextNote);
        testgreendaoactivitytestbuttonAdd.setOnClickListener(this);
        testgreendaoactivitytestbuttonSearch.setOnClickListener(this);
    }

    /**
     * Button 点击的监听事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.test_greendao_activity_test_buttonAdd:
                addNote();
                break;
            case R.id.test_greendao_activity_test_buttonSearch:
                searchNode();
                break;
            default:
                Log.d(TAG, "what has gone wrong ?");
                break;
        }
    }

    //?拿到NoteDao实体?
    private NoteDao getNoteDao() {
        return GlobalApplication.getDaoSession(this).getNoteDao();
    }

    //增
    private void addNote() {
        String noteText = testgreendaoactivitytesteditTextNote.getText().toString();
        testgreendaoactivitytesteditTextNote.setText("");

        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = "Added on " + df.format(new Date());

        // 插入操作，简单到只要你创建一个 Java 对象
        Note note = new Note(null, noteText, comment, new Date());
        getNoteDao().insert(note);
        Log.d(TAG, "Inserted new note, ID: " + note.getId());
        cursor.requery();

    }

    //查
    private void searchNode() {
// Query 类代表了一个可以被重复执行的查询
        Query query = getNoteDao().queryBuilder()
                //TODO 输入自己需要查询的内容
                .where(NoteDao.Properties.Text.eq(testgreendaoactivitytesteditTextNote.getText()))
                .orderAsc(NoteDao.Properties.Date)
                .build();



        cursor.requery();

        Toast.makeText(this, "共查到" + query.list().size() + "条", Toast.LENGTH_SHORT).show();
//      查询结果以 List 返回
//      List<String> notes = query.list();
        // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }
}
