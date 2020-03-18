package kr.co.tjoeun.a20200318_04_listview02;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

// abstract 메쏘드를 가지는 클래스는 반드시 abstract class
public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext = this;

    public abstract void setupEvents(); // 이벤트 세팅
    public abstract void setValues(); // 값 세팅


}
