package com.debacharya.androidbasics.session02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.debacharya.androidbasics.session02.model.Team;

import java.util.List;

public class TeamLVAdapter extends BaseAdapter {

	private final List<Team> teams;

	public TeamLVAdapter(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public int getCount() {
		return this.teams.size();
	}

	@Override
	public Team getItem(int position) {
		return this.teams.get(position);
	}

	@Override
	public long getItemId(int position) {
		return this.teams.get(position).hashCode();
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {

		if(view == null)
			view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_entry, parent, false);

		Team team = this.teams.get(position);
		TextView tvTitle = view.findViewById(R.id.tv_teamtitle);
		TextView tvCode = view.findViewById(R.id.tv_teamcode);

		tvTitle.setText(team.getTitle());
		tvCode.setText(team.getCode());

		return view;
	}
}
