package dev.tatuan.hh.DonHang.donhang;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dev.tatuan.hh.DonHang.DonHangData;
import dev.tatuan.hh.R;

/**
 * Created by Anh on 21/04/2018.
 */

public class ItemDonHangAdapter extends RecyclerView.Adapter<ItemDonHangViewHolder> {

    private ArrayList<DonHangData> arrDonHang;
    private Context mContext;

    public ItemDonHangAdapter(ArrayList<DonHangData> arrDonHang, Context mContext) {
        this.arrDonHang = arrDonHang;
        this.mContext = mContext;
    }

    @Override
    public ItemDonHangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_child_donhang, parent, false);
        return new ItemDonHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemDonHangViewHolder holder, int position) {
        DonHangData donHangData = arrDonHang.get(position);
        Picasso.get()
                .load(donHangData.getHinhanh())
                .into(holder.imgDonHang);
        holder.txtWatchName.setText(donHangData.getTendh());
        holder.txtCountWatch.setText(donHangData.getSoluong() + "");
        holder.txtAmount.setText(donHangData.getTongtien() + "vnd");
    }

    @Override
    public int getItemCount() {
        return arrDonHang.size();
    }
}
