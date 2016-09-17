package com.example.test.DataAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.test.R;
import com.example.test.pojo.PhoneModel;

import java.util.List;

public class DataAdapter extends BaseAdapter {

    private Context mContext;
    private List<PhoneModel> mData;
    private LayoutInflater layoutInflater;

    public DataAdapter(Context context, List<PhoneModel> mData) {
        mContext = context;
        this.mData = mData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_main, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.txtItem = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        PhoneModel phoneModel = getPhoneModel(position);
        viewHolder.txtItem.setText(phoneModel.getFirstName() + " " + phoneModel.getSecondName());

        return convertView;
    }

    private PhoneModel getPhoneModel(int i) {
        return (PhoneModel) getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    static class ViewHolder {
        TextView txtItem;
    }
}