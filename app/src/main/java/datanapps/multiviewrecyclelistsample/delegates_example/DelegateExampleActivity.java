package datanapps.multiviewrecyclelistsample.delegates_example;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import datanapps.multiviewrecyclelistsample.R;
import datanapps.multiviewrecyclelistsample.delegates_example.adapters.BaseItemAdapter;
import datanapps.multiviewrecyclelistsample.delegates_example.adapters.HeaderAdapter;
import datanapps.multiviewrecyclelistsample.delegates_example.adapters.MoviesAdapter;
import datanapps.multiviewrecyclelistsample.delegates_example.adapters.RectHeaderAdapter;
import datanapps.multiviewrecyclelistsample.delegates_example.adapters.UsersAdapter;
import datanapps.multiviewrecyclelistsample.models.BaseModel;
import datanapps.multiviewrecyclelistsample.models.Header;
import datanapps.multiviewrecyclelistsample.models.Movie;
import datanapps.multiviewrecyclelistsample.models.RectHeader;
import datanapps.multiviewrecyclelistsample.models.User;


/*
 *
 * Yogendra
 * 11/02/2019
 *
 * To make sure you are implemented in build dependency
 *  implementation "com.hannesdorfmann:adapterdelegates3:3.0.1"
 *
 * */

// Sample activity that display recycle view

public class DelegateExampleActivity extends AppCompatActivity {


    BaseItemAdapter baseItemAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        createAdapter();
        setRecycleView();
    }

    /*
    * create base adapter and save all other adapter as delegate
    *
    * */
    private void createAdapter(){
        baseItemAdapter = new BaseItemAdapter();
        baseItemAdapter.addDelegate(new UsersAdapter());
        baseItemAdapter.addDelegate(new MoviesAdapter());
        baseItemAdapter.addDelegate(new HeaderAdapter());
        baseItemAdapter.addDelegate(new RectHeaderAdapter());
        baseItemAdapter.addFeedItems(getPreparedItemDate());
    }

/*
*
* Prepare recycle view to show data
* */
    private void setRecycleView(){

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(baseItemAdapter);
    }


    /*
    *
    * prepare multi item list  
    * */
    private  List<BaseModel> getPreparedItemDate() {

        List<BaseModel> itemList = new ArrayList<>();
        itemList.add(new Movie("Mad Max: Fury Road", "Action & Adventure", "2015"));
        itemList.add(new User(R.mipmap.ic_launcher, "Vinay"));
        itemList.add(new RectHeader(Color.RED, " Red Text"));
        itemList.add(new Header("Header "));
        itemList.add(new User(R.drawable.ic_avatar_male_1, "Yogendra"));
        itemList.add(new Movie("Apane", "Family", "2009"));
        itemList.add(new Header("Header "));
        itemList.add(new User(R.drawable.ic_avatar_female, "Shakila"));
        itemList.add(new User(R.mipmap.ic_launcher, "Kishor"));
        itemList.add(new User(R.drawable.ic_avatar_male_1, "Pawan"));
        itemList.add(new Header("Header "));
        itemList.add(new Movie("BOSS", "Actios", "2012"));
        itemList.add(new RectHeader(Color.BLUE, " Blue Text"));
        itemList.add(new Movie("YES", "Romanse", "2005"));
        itemList.add(new Movie("Baby", "Actios", "2014"));
        itemList.add(new RectHeader(Color.YELLOW, " Yellow Text"));
        itemList.add(new Header("Header "));
        itemList.add(new Header("Header "));
       itemList.add(new Header("Header "));
        return itemList;
    }
    }
