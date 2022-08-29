package com.tarapogancev.roommates.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tarapogancev.roommates.MainPagerAdapter;
import com.tarapogancev.roommates.R;
import com.tarapogancev.roommates.fragment.apartments.ApartmentsFragment;
import com.tarapogancev.roommates.fragment.roommates.RoommatesFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    Button roommateButton, apartmentButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new RoommatesFragment());
        fragmentList.add(new ApartmentsFragment());

        viewPager = findViewById(R.id.layout_ViewPager);
        pagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(pagerAdapter);

        roommateButton = findViewById(R.id.button_roommates);
        apartmentButton = findViewById(R.id.button_apartments);

        roommateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() != 0) {
                    viewPager.setCurrentItem(0);
                    makeButtonBlue(roommateButton);
                    makeButtonGray(apartmentButton);
                }
            }
        });

        apartmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() != 1) {
                    viewPager.setCurrentItem(1);
                    makeButtonBlue(apartmentButton);
                    makeButtonGray(roommateButton);
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    makeButtonBlue(roommateButton);
                    makeButtonGray(apartmentButton);
                } else {
                    makeButtonBlue(apartmentButton);
                    makeButtonGray(roommateButton);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void makeButtonBlue(Button button) {
        button.setBackground(ContextCompat.getDrawable(this, R.drawable.blue_rectangle_round));
        button.setTextColor(button.getContext().getResources().getColor(R.color.white));
    }

    private void makeButtonGray(Button button) {
        button.setBackground(ContextCompat.getDrawable(this, R.drawable.light_gray_rectangle_round));
        button.setTextColor(button.getContext().getResources().getColor(R.color.gray_medium));
    }
}