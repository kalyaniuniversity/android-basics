package com.androidapp.phototext;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class WallpaperListAdapter  extends ArrayAdapter<Wallpaper> {

    List<Wallpaper> wallpaperList;
    Context context;
    int resource;

    public WallpaperListAdapter(Context context, int resource, List<Wallpaper> wallpaperList) {
        super(context, resource, wallpaperList);
        this.context = context;
        this.resource = resource;
        this.wallpaperList = wallpaperList;
    }

    public class ViewHolder {
        ImageView wall;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View view, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
       // View view = layoutInflater.inflate(resource, null, false);
        //ImageView imageView = view.findViewById(R.id.wall);
       // Wallpaper photo = wallpaperList.get(position);
       // imageView.setImageDrawable(context.getResources().getDrawable(photo.getImage()));
        //return view;

//        String listItem = (String) listView.getItemAtPosition(position);
//
//        if(!checked.contains(listItem)){ //optional: avoids duplicate Strings in your list
//            checked.add((position+1), listItem);
//        }
//        String allItems = ""; //used to display in the toast
//
//        for(String str : checked){
//            allItems = allItems + "\n" + str; //adds a new line between items
//        }

  //      Toast.makeText(getApplicationContext(),allItems, Toast.LENGTH_LONG).show();

        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.my_walpaper_list, null);
            holder.wall = (ImageView) view.findViewById(R.id.wall);
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.wall.setImageResource(wallpaperList.get(position).getImage());
        //view.setClickable(true);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String allItems = "Item is clicked : " + holder.wall.getDrawable();
                Toast.makeText(v.getContext(), allItems, Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}
