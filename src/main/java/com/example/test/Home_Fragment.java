package com.example.test;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.test.adapter.PhoneModelAdepter;
import com.example.test.pojo.PhoneModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Fragment extends Fragment {
    private static final int EDIT = 0, DELETE = 1;
    private ListView listview;
    private List<PhoneModel> list = new ArrayList<>();
    private PhoneModelAdepter adapter;

    public Home_Fragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_, container, false);
        listview = (ListView) view.findViewById(R.id.listView2);
        adapter = new PhoneModelAdepter(getContext(), initData());
        listview.setAdapter(adapter);
        registerForContextMenu(listview);
        return view;
    }

    private List<PhoneModel> initData() {
//        list.add(new PhoneModel(1, "Iphone", 1000));
//        list.add(new PhoneModel(2, "Htc", 200));
//        list.add(new PhoneModel(3, "Lg", 500));
//        list.add(new PhoneModel(4, "One+", 300));
        for (int i = 0; i < 10; i++) {
            list.add(new PhoneModel("FirstName", "SecondName"));
        }
        return list;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, EDIT, 0, "Добавить контакт");
        menu.add(0, DELETE, 0, "Удалить запись");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case EDIT:
                if (item.getItemId() == EDIT) {
                    startActivity(new Intent(this.getActivity(), SubActivity.class));

                }
                return true;
            case DELETE:
                if (item.getItemId() == DELETE) {
                    AdapterView.AdapterContextMenuInfo ami = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    list.remove(ami.position);
                    adapter.notifyDataSetChanged();
                    return true;
                }


        }
        return super.onContextItemSelected(item);
    }


}
