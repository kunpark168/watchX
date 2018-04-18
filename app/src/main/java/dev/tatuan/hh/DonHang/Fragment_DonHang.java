package dev.tatuan.hh.DonHang;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import dev.tatuan.hh.R;

import static android.content.Context.MODE_PRIVATE;

public class Fragment_DonHang extends Fragment {
    RecyclerView rcOfDonHang;
    ArrayList<DonHangData> donHangDatas;
    DonHangAdapter donHangAdapter;
    DonHangData donHangData;
    DatabaseReference db;
    String phone;
    LinearLayoutManager Verti;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_donhang, container, false);
        rcOfDonHang = view.findViewById(R.id.rcOfDonHang);
        donHangDatas = new ArrayList<>();
        donHangAdapter = new DonHangAdapter(getActivity(), donHangDatas);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("DATA", MODE_PRIVATE);
        phone = sharedPreferences.getString("phone", "");
        Verti = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        getData();
        return view;
    }

    private void getData() {
        db = FirebaseDatabase.getInstance().getReference("donhangcuatoi").child(phone);
        final String id = db.push().getKey();
        DatabaseReference dbb = db.child(id);
        dbb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                donHangDatas.clear();
                if (dataSnapshot.getValue() != null) {
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        donHangData = data.getValue(DonHangData.class);
                        donHangDatas.add(donHangData);
                        Toast.makeText(getActivity(), id+"", Toast.LENGTH_SHORT).show();
                    }
                }
                donHangAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        rcOfDonHang.setLayoutManager(Verti);
        rcOfDonHang.setAdapter(donHangAdapter);
    }
}
