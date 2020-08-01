package com.androidapp.phototext;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;


public class BackgroundActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView backbutton;
    GridView gridView;
    int[] wallpaperImages = {R.drawable.wall1,
            R.drawable.wall12,
            R.drawable.wall3,
            R.drawable.wall4,
            R.drawable.wall5,
            R.drawable.wall6,
            R.drawable.wall7,
            R.drawable.wall8,
            R.drawable.wall9,
            R.drawable.wall10,
            R.drawable.wall11,
            R.drawable.wall13,
            R.drawable.wall14,
            R.drawable.wall2,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(this);

        gridView = findViewById(R.id.gridView);
        WallListAdapter customAdapter = new WallListAdapter();
            gridView.setAdapter(customAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                    Intent intent = new Intent();
                    intent.putExtra("wallpaper",wallpaperImages[i]);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            });
        }

    private class WallListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return wallpaperImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.my_walpaper_list,null);
            ImageView image = view1.findViewById(R.id.wall);
            image.setImageResource(wallpaperImages[i]);
            return view1;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.backbutton:
                finish();
                break;

        }
    }
}



//<-----ListView--->

//        wallpaperList = new ArrayList<>();
//        listView = (ListView) findViewById(R.id.listView);
//        wallpaperList.add(new Wallpaper(R.drawable.wall1));
//        wallpaperList.add(new Wallpaper(R.drawable.wall12));
//        wallpaperList.add(new Wallpaper(R.drawable.wall3));
//        wallpaperList.add(new Wallpaper(R.drawable.wall4));
//        wallpaperList.add(new Wallpaper(R.drawable.wall5));
//        wallpaperList.add(new Wallpaper(R.drawable.wall6));
//        wallpaperList.add(new Wallpaper(R.drawable.wall7));
//        wallpaperList.add(new Wallpaper(R.drawable.wall8));
//        wallpaperList.add(new Wallpaper(R.drawable.wall9));
//        wallpaperList.add(new Wallpaper(R.drawable.wall10));
//        wallpaperList.add(new Wallpaper(R.drawable.wall11));
//        wallpaperList.add(new Wallpaper(R.drawable.wall13));
//        wallpaperList.add(new Wallpaper(R.drawable.wall14));
//        wallpaperList.add(new Wallpaper(R.drawable.wall12));

//        WallpaperListAdapter adapter = new WallpaperListAdapter(this, R.layout.my_walpaper_list, wallpaperList);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<!--?--> adapterView, View view, int i, long l) {
////                Toast.makeText(getApplicationContext(),fruitNames[i],Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(getApplicationContext(),ListdataActivity.class);
//                intent.putExtra("name",fruitNames[i]);
//                intent.putExtra("image",fruitImages[i]);
//                startActivity(intent);
//
//            }
//        });
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Toast.makeText(getApplicationContext(), wallpaperList.get(position), Toast.LENGTH_LONG).show();
//                Intent intent_wall = new Intent();
//                intent_wall.putExtra("wallpaper", wallpaperList);
//                setResult(RESULT_OK, intent_wall);
//                finish();
//            }
//        });
//        wall1 = findViewById(R.id.wall1);
//        wall1.setOnClickListener(this);

//<------ END ----->