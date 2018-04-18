package dev.tatuan.hh.MuaNgay;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import dev.tatuan.hh.R;

/**
 * Created by tatuan on 18/04/2018.
 */

public class MuaNgayActivity extends AppCompatActivity {
    RecyclerView rcItem;

    ArrayList<MuaNgayData> muaNgayDatas;
    MuaNgayAdapter muaNgayAdapter;
    LinearLayoutManager Verti;
    MuaNgayData Cdata;
    String phone, id;
    DatabaseReference databaseReference, dathang;
    TextView tv_dathang;
//    Data2 data2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muahanglayout);


        SharedPreferences sharedPreferences = getSharedPreferences("DATA", MODE_PRIVATE);
        phone = sharedPreferences.getString("phone", "");
        id = sharedPreferences.getString("idd", "");

        muaNgayDatas = new ArrayList<>();
        muaNgayAdapter = new MuaNgayAdapter(getApplicationContext(), muaNgayDatas);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        rcItem = (RecyclerView) findViewById(R.id.rcItem);
        Verti = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        getData();
        rcItem.setLayoutManager(Verti);
        rcItem.setAdapter(muaNgayAdapter);

        datHang();
    }

    private void getData() {
        databaseReference.child("abcd").child(phone).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() != null) {
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        Cdata = data.getValue(MuaNgayData.class);
                        muaNgayDatas.add(Cdata);
//                        data2 = new Data2(muaNgayDatas);

                    }
                }
                muaNgayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void datHang() {
        tv_dathang = (TextView) findViewById(R.id.tv_dathang);
        tv_dathang.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dathang = FirebaseDatabase.getInstance().getReference("donhangcuatoi").child(phone);
                final String id = dathang.push().getKey();
                final DatabaseReference db = dathang.child(id);
                db.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        db.setValue(muaNgayDatas);

                        DatabaseReference kk = FirebaseDatabase.getInstance().getReference("abcd").child(phone);
                        kk.removeValue();

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DatabaseReference kk = FirebaseDatabase.getInstance().getReference("abcd").child(phone);
        kk.removeValue();
        super.onBackPressed();

    }
}
