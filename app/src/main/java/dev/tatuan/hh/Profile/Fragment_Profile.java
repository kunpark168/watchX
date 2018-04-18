package dev.tatuan.hh.Profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.tatuan.hh.R;


public class Fragment_Profile extends Fragment {
    Context mContext;
    String phone, address, name;
    TextView tv_phone, tv_address, tv_name;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("DATA", Context.MODE_PRIVATE);

        phone = sharedPreferences.getString("phone", "");
        address = sharedPreferences.getString("address", "");
        name = sharedPreferences.getString("name", "");


        tv_name = view.findViewById(R.id.tv_name);
        tv_address = view.findViewById(R.id.tv_diachi);
        tv_phone = view.findViewById(R.id.tv_phone);

        tv_phone.setText(phone);
        tv_name.setText(name);
        tv_address.setText(address);

        return view;

    }
}
