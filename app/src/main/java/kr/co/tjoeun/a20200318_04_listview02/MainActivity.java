package kr.co.tjoeun.a20200318_04_listview02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

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


        binding.roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Room clickedRoom = roomDatas.get(position);
//                방상세 화면으로 이동
                Intent intent = new Intent(mContext, RoomDetailActivity.class);
                intent.putExtra("room", clickedRoom);
                startActivity(intent);
            }
        });

        binding.roomListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Room data = roomDatas.get(position);
                Toast.makeText(mContext, data.getDescription(), Toast.LENGTH_SHORT).show();
                return true; // true : 롱클릭만, false : 그냥클릭도 같이 출력됨
            }
        });





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
