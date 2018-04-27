package dev.tatuan.hh.DonHang;

import android.content.Context;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

import dev.tatuan.hh.MuaNgay.MuaNgayViewHolder;
import dev.tatuan.hh.R;

/**
 * Created by tatuan on 17/04/2018.
 */

public class DonHangAdapter extends RecyclerView.Adapter<DonHangViewHolder> {
    Context mContext;
    ArrayList<DonHangData> datas;

    public DonHangAdapter(Context mContext, ArrayList<DonHangData> datas) {
        this.mContext = mContext;
        this.datas = datas;
    }

    @Override
    public DonHangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.muangayitem, parent, false);

        return new DonHangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DonHangViewHolder holder, int position) {
        DonHangData data = datas.get(position);

        final String soLuong = data.getSoluong();
        final String ten = data.getTendh();
        final String tongTien = data.getTongtien();
        final String hinhAnh = data.getHinhanh();

        holder.tv_ten.setText(ten);

        holder.tv_soluong.setText(soLuong);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.tv_tien.setText(NumberFormat.getNumberInstance(Locale.US).format(Long.parseLong(tongTien)));
        }

        Picasso.get().load(data.getHinhanh()).into(holder.img_hinhanh);

    }


    @Override
    public int getItemCount() {
        return datas.size();
    }
}
