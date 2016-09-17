package com.example.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */

public class TopFreeFragment extends Fragment {
    View view;
    private TextView _screen;
    private String display = "";

    public TopFreeFragment() {
        // Required empty public constructor

    }


    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public TextView get_screen() {
        return _screen;
    }

    public void set_screen(TextView _screen) {
        this._screen = _screen;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_top_free, container, false);
        _screen = (TextView) view.findViewById(R.id.textView2);
        return view;

    }


}
