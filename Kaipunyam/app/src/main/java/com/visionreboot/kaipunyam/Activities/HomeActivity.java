package com.visionreboot.kaipunyam.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.visionreboot.kaipunyam.OrderModel;
import com.visionreboot.kaipunyam.OrderRecyclerViewAdapter;
import com.visionreboot.kaipunyam.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolBarHome);
        RecyclerView recyclerView = findViewById(R.id.orderRecyclerView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black);
        getSupportActionBar().setTitle("Kaipunyam");

        FloatingActionButton fab = findViewById(R.id.pennyFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(HomeActivity.this, CalenderActivity.class);
                startActivity(signUp);
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);


        List<OrderModel.OrderModelData> orderTrackList = Collections.synchronizedList(new ArrayList<OrderModel.OrderModelData>());

        orderTrackList.add(new OrderModel.OrderModelData("Jose", "Kochi", "https://thenovicechef.files.wordpress.com/2011/09/img_2038.jpg?w=1000", "07:30am", "Dosa and Chammanthy", "3"));
        orderTrackList.add(new OrderModel.OrderModelData("Sara", "Vyttila", "https://scontent-vie1-1.cdninstagram.com/vp/afb33260ad5936e861782405c7329ea6/5BF30617/t51.2885-15/e35/37422272_2064832257111423_8802151992702009344_n.jpg", "1:30pm", "Veg Meals", "7"));
        orderTrackList.add(new OrderModel.OrderModelData("Stephen", "Vyttila", "https://pbs.twimg.com/media/CD6e8JQUIAAhhOt.jpg:large", "1:30pm", "Non Veg Meals", "7"));
        orderTrackList.add(new OrderModel.OrderModelData("Latha", "Tripunitura", "https://dinnerdabba.com/wp-content/uploads/2017/05/onion-uthappam.jpg", "03:30pm", "Uthappam", "2"));
        orderTrackList.add(new OrderModel.OrderModelData("Mathan", "Palarivattom", "http://1.bp.blogspot.com/-ZLqo8hMJjk8/VfW0GJ26krI/AAAAAAAACNA/nB-Xu0cxzFI/s1600/DSC_0670.JPG", "05:30pm", "Puttu and Kadala", "8"));
        orderTrackList.add(new OrderModel.OrderModelData("Gracy", "Kochi", "https://prods3.imgix.net/images/articles/2015_11/Hero-Aarti-Sequeria-Chef-Chapati-Flatbread-Recipe1.jpg", "06:30", "Chappathy", "4"));
        orderTrackList.add(new OrderModel.OrderModelData("Jose", "Kochi", "https://thenovicechef.files.wordpress.com/2011/09/img_2038.jpg?w=1000", "07:30am", "Dosa and Chammanthy", "3"));
        orderTrackList.add(new OrderModel.OrderModelData("Sara", "Vyttila", "https://scontent-vie1-1.cdninstagram.com/vp/afb33260ad5936e861782405c7329ea6/5BF30617/t51.2885-15/e35/37422272_2064832257111423_8802151992702009344_n.jpg", "1:30pm", "Veg Meals", "7"));
        orderTrackList.add(new OrderModel.OrderModelData("Stephen", "Vyttila", "https://pbs.twimg.com/media/CD6e8JQUIAAhhOt.jpg:large", "1:30pm", "Non Veg Meals", "7"));
        orderTrackList.add(new OrderModel.OrderModelData("Latha", "Tripunitura", "https://dinnerdabba.com/wp-content/uploads/2017/05/onion-uthappam.jpg", "03:30pm", "Uthappam", "2"));
        orderTrackList.add(new OrderModel.OrderModelData("Mathan", "Palarivattom", "http://1.bp.blogspot.com/-ZLqo8hMJjk8/VfW0GJ26krI/AAAAAAAACNA/nB-Xu0cxzFI/s1600/DSC_0670.JPG", "05:30pm", "Puttu and Kadala", "8"));
        orderTrackList.add(new OrderModel.OrderModelData("Gracy", "Kochi", "https://prods3.imgix.net/images/articles/2015_11/Hero-Aarti-Sequeria-Chef-Chapati-Flatbread-Recipe1.jpg", "06:30", "Chappathy", "4"));
        OrderRecyclerViewAdapter orderRecyclerViewAdapter = new OrderRecyclerViewAdapter(orderTrackList, this);
        recyclerView.setAdapter(orderRecyclerViewAdapter);


        NavigationView navigationViewHome = findViewById(R.id.navigationViewHome);
        View headerLayout = navigationViewHome.getHeaderView(0);
        AppCompatImageView imageViewPrflePik = headerLayout.findViewById(R.id.imageViewPrflePik);
        AppCompatImageView imageViewBackPrflePick = headerLayout.findViewById(R.id.imageViewBackPrflePick);
        AppCompatTextView textViewName = headerLayout.findViewById(R.id.textViewName);

        textViewName.setText("Mariyamma");

        RequestOptions requestOptions = new RequestOptions()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.defaultimage)
                .error(R.drawable.defaultimage);

        if (!isFinishing()) {
            Glide.with(imageViewBackPrflePick)
                    .load("http://www.openthemagazine.com/sites/default/files/public%3A/realindia-spices.jpg")
                    .apply(requestOptions)
                    .into(imageViewPrflePik);
            Glide.with(imageViewBackPrflePick)
                    .load("http://www.openthemagazine.com/sites/default/files/public%3A/realindia-spices.jpg")
                    .apply(requestOptions)
                    .into(imageViewBackPrflePick);
        }


        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(Gravity.START);
        }
        return super.onOptionsItemSelected(item);
    }
}
