package datanapps.multiviewrecyclelistsample.simple;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import datanapps.multiviewrecyclelistsample.R;
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
 * */

// Sample activity that display recycle view
public class MainActivity extends AppCompatActivity {


    private MultiViewAdapter multiViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAdapter();
        setRecycleView();
    }

    /*
    *
    * prepare adapter
    * */
    private void createAdapter(){
        multiViewAdapter = new MultiViewAdapter(this);
        multiViewAdapter.setFeedItems(getPreparedItemDate());
    }

/*
* prepare recycle view
*
* */
    private void setRecycleView(){

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(multiViewAdapter);
    }



    /*
    *
    * Prepare data list to show in recycle view
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
