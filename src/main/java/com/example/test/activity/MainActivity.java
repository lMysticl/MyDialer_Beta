package com.example.test.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.test.*;
import com.example.test.pojo.PhoneModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int EDIT = 0, DELETE = 1;
    int longClickedItemIndex;
    private ListView listView;
    private List<PhoneModel> list = new ArrayList<>();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private TextView _screen;
    private String display = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  initToolbar();
        //toolbar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragments(new TopFreeFragment(), "Dial");
        viewPagerAdapter.addFragments(new Home_Fragment(), "Contacts");
        viewPagerAdapter.addFragments(new TopPaidFragment(), "Favorite");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    public TextView get_screen() {
        return _screen;
    }

    public String getDisplay() {
        return display;
    }

    public void onClickNumber(View v) {
        if (display.length() < 30) {
            Button b = (Button) v;
            display += b.getText();
            TopFreeFragment topFreeFragment = new TopFreeFragment();
            _screen = (TextView) findViewById(R.id.textView2);
            _screen.setText(display);
            topFreeFragment.set_screen(_screen);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.list_set);
        TextView infoTextView = (TextView) findViewById(R.id.textView);
        switch (item.getItemId()) {

            case R.id.action_setting1:
                if (item.isCheckable())
                    item.setCheckable(false);
                else
                    item.setCheckable(true);
                main_view.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.action_setting2:
                if (item.isCheckable())
                    item.setCheckable(false);
                else
                    item.setCheckable(true);
                main_view.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.action_setting3:
                if (item.isCheckable())
                    item.setCheckable(false);
                else
                    item.setCheckable(true);
                main_view.setBackgroundColor(Color.RED);
                return true;
            case R.id.navigate:
                startActivity(new Intent(this, SubActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void backSpace(View v) {
        System.out.printf("Метод: backSpace%s%n", display);
        display = display.substring(0, display.length() - 1);
        _screen.setText(display);
    }

}
