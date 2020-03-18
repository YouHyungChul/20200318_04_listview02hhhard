package kr.co.tjoeun.a20200318_04_listview02.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import kr.co.tjoeun.a20200318_04_listview02.R;
import kr.co.tjoeun.a20200318_04_listview02.datas.Room;

public class RoomAdapter extends ArrayAdapter<Room> {

    Context mContext;
    List<Room> mList;
    LayoutInflater inf;
    public RoomAdapter(@NonNull Context context, int resource, @NonNull List<Room> objects) {
        super(context, resource, objects);

        mContext = context;
        mList = objects;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = inf.inflate(R.layout.room_list_item, null);
        }

        Room data = mList.get(position);

        TextView priceTxt = row.findViewById(R.id.priceTxt);
        TextView addressAndFloorTxt = row.findViewById(R.id.addressAndFloorTxt);
        TextView descTxt = row.findViewById(R.id.descTxt);

//        가격설정 => setText에는 int값을 넣지 말자
//        priceTxt.setText(data.getPrice());  ==> 잘못된 예제 이렇게 하면 앱 터진다
//        1만이상? 억 단위, 아니면? 숫자만 , 찍어서

        if (data.getPrice() >= 10000){
//            ?억 %,d로 구하자      ?억??   ?천??
            int uk = data.getPrice() / 10000;
            int thousand = data.getPrice()%10000;

            priceTxt.setText(String.format("%d억 %,d", uk, thousand));

        }else {
            priceTxt.setText(String.format("%,d", data.getPrice()));
        }

//        설명은 들어온 그대로 출력.
        descTxt.setText(data.getDescription());

        return row;
    }
}
