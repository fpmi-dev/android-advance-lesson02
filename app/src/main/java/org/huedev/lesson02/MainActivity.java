package org.huedev.lesson02;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.huedev.lesson02.fragments.FirstFragment;
import org.huedev.lesson02.fragments.SecondFragment;
import org.huedev.lesson02.fragments.ThirdFragment;

public class MainActivity extends AppCompatActivity {
    private final int TAB_FIRST = 0;
    private final int TAB_SECOND = 1;
    private final int TAB_THIRD = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
    }

    public class MainPagerAdapter extends FragmentPagerAdapter {
        private final int TAB_NUMBER = 3;

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position){
                case TAB_FIRST:
                    fragment = new FirstFragment();
                    break;
                case TAB_SECOND:
                    fragment = new SecondFragment();
                    break;
                case TAB_THIRD:
                    fragment = new ThirdFragment();
                    break;
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return TAB_NUMBER;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "page " + position;
        }
    }
}
