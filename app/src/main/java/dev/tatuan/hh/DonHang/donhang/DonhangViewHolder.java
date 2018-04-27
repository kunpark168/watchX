package dev.tatuan.hh.DonHang.donhang;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import dev.tatuan.hh.R;

/**
 * Created by Anh on 21/04/2018.
 */

public class DonhangViewHolder extends RecyclerView.ViewHolder {

    public RecyclerView recyclerDonHang;
    public DonhangViewHolder(View itemView) {
        super(itemView);
        recyclerDonHang = itemView.findViewById(R.id.recyclerDonHang);
    }
}
