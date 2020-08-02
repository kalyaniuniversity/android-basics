package com.example.pincode;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pincode.modem.Meaning;

import java.util.List;

public class Listview_adapter extends BaseAdapter {

    private List<Meaning> meanings;
    public Listview_adapter(List<Meaning> meanings){
        this.meanings=meanings;
    }

    @Override
    public int getCount() {
        return this.meanings.size();
    }

    @Override
    public Object getItem(int i) {
        return this.meanings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.meanings.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_entry,parent,false);
        Meaning meanings=this.meanings.get(i);
        TextView train_name=view.findViewById(R.id.meanings);
        TextView std = view.findViewById(R.id.std);

        train_name.setText(meanings.getTextMeaning());
        std.setText(meanings.getPincode());

        return  view;
    }
}
