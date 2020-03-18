package kr.co.tjoeun.a20200318_04_listview02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjoeun.a20200318_04_listview02.adapters.RoomAdapter;
import kr.co.tjoeun.a20200318_04_listview02.databinding.ActivityMainBinding;
import kr.co.tjoeun.a20200318_04_listview02.datas.Room;

public class MainActivity extends BaseActivity {

    List<Room> roomDatas = new ArrayList<>();
    RoomAdapter roomAdapter = null;
    ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        roomAdapter = new RoomAdapter(mContext, R.layout.room_list_item,roomDatas);
        binding.roomListView.setAdapter(roomAdapter);

        addRooms();
    }

    private void addRooms() {
        roomDatas.add(new Room(80020, "함양", 4, "살기좋은 방입니다."));
        roomDatas.add(new Room(81000, "서울", 2, "꺼져."));
        roomDatas.add(new Room(89000, "경기", 1, "티모."));
        roomDatas.add(new Room(85000, "부산", -1, "원."));
        roomDatas.add(new Room(81000, "대구", 0, "투."));
        roomDatas.add(new Room(78000, "베이징", 5, "아파트"));

        roomAdapter.notifyDataSetChanged();
    }


}
