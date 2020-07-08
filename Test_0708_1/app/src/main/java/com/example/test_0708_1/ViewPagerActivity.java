package com.example.test_0708_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        TabLayout tableLayout = findViewById(R.id.tab_lay);
        ViewPager viewPager = findViewById(R.id.view_pager);

        ArrayList<View> alist = new ArrayList<View>();
        LayoutInflater lin = getLayoutInflater();
        alist.add(lin.inflate(R.layout.pager_view_one, null, false));
        alist.add(lin.inflate(R.layout.pager_view_second, null, false));
        alist.add(lin.inflate(R.layout.pager_view_third, null, false));
        alist.add(lin.inflate(R.layout.pager_view_fourth, null, false));
        MyPagerAadapter myPagerAadapter = new MyPagerAadapter(alist);
        viewPager.setAdapter(myPagerAadapter);

        tableLayout.setupWithViewPager(viewPager);
        ArrayList<String> tabList = new ArrayList<String>();
        tabList.add("蔡依林");
        tabList.add("汤唯");
        tabList.add("郎朗");
        tabList.add("成龙");

        for(int i=0; i<tabList.size(); i++ )
            tableLayout.getTabAt(i).setText(tabList.get(i));
    }

    public static class MyPagerAadapter extends PagerAdapter {
        private ArrayList<View> viewList;

        public MyPagerAadapter(ArrayList<View> viewList) {
            super();
            this.viewList = viewList;
        }

        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position){
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }
    }
}
