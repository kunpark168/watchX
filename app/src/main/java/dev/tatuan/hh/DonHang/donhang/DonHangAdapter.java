package dev.tatuan.hh.DonHang.donhang;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import dev.tatuan.hh.DonHang.DonHangData;
import dev.tatuan.hh.R;

/**
 * Created by Anh on 21/04/2018.
 */

public class DonHangAdapter extends RecyclerView.Adapter<DonhangViewHolder> {

    private ArrayList<String> arrListDH;
    private Context mContext;
    private ItemDonHangAdapter adapter;
    private HashMap<String, ArrayList<DonHangData>> mapDonHang;

    public DonHangAdapter(ArrayList<String> arrListDH, Context mContext) {
        this.arrListDH = arrListDH;
        this.mContext = mContext;
    }


    @Override
    public DonhangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_donhang, parent, false);
        return new DonhangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DonhangViewHolder holder, int position){
        ArrayList<DonHangData> arrDH = new ArrayList<>();
        arrDH = mapDonHang.get(arrListDH.get(position));
        adapter = new ItemDonHangAdapter(arrDH, mContext);
        holder.recyclerDonHang.setAdapter(adapter);
        holder.recyclerDonHang.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public int getItemCount() {
        return arrListDH.size();
    }

    public void setMapDonHang(HashMap<String, ArrayList<DonHangData>> mapDonHang) {
        this.mapDonHang = mapDonHang;
    }
}
