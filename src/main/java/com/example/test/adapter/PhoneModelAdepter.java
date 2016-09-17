package com.example.test.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.test.R;
import com.example.test.pojo.PhoneModel;

import java.util.List;


public class PhoneModelAdepter extends BaseAdapter {


    private List<PhoneModel> list;
    private LayoutInflater layoutInflater;

    public PhoneModelAdepter(Context context, List<PhoneModel> list) {
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = view;
        if (view1 == null) {
            view1 = layoutInflater.inflate(R.layout.item_layout, viewGroup, false);
        }

        PhoneModel phoneModel = getPhoneModel(i);

        TextView textView = (TextView) view1.findViewById(R.id.textView);

        textView.setText(phoneModel.getFirstName() + " " + phoneModel.getSecondName());

        return view1;
    }

    private PhoneModel getPhoneModel(int i) {
        return (PhoneModel) getItem(i);
    }
}
