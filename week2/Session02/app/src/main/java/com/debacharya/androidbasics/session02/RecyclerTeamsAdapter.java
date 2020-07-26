package com.debacharya.androidbasics.session02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.debacharya.androidbasics.session02.model.Team;

import java.util.List;

public class RecyclerTeamsAdapter extends RecyclerView.Adapter<RecyclerTeamsAdapter.TeamViewHolder> {

	private final List<Team> teams;

	public RecyclerTeamsAdapter(List<Team> teams) {
		this.teams = teams;
	}

	@NonNull
	@Override
	public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

		Context context = parent.getContext();
		View view = LayoutInflater.from(context).inflate(R.layout.listview_entry, parent, false);
		TeamViewHolder viewHolder = new TeamViewHolder(view);

		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull TeamViewHolder viewHolder, int position) {
		viewHolder.bind(position);
	}

	@Override
	public int getItemCount() {
		return this.teams.size();
	}

	public class TeamViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

		private TextView tvTitle;
		private TextView tvCode;

		public TeamViewHolder(@NonNull View itemView) {

			super(itemView);

			tvTitle = itemView.findViewById(R.id.tv_teamtitle);
			tvCode = itemView.findViewById(R.id.tv_teamcode);

			itemView.setOnClickListener(this);
		}

		public void bind(int position) {
			Team team = teams.get(position);
			tvTitle.setText(team.getTitle());
			tvCode.setText(team.getCode());
		}

		@Override
		public void onClick(View view) {
			Toast.makeText(view.getContext(), tvTitle.getText().toString(), Toast.LENGTH_SHORT).show();
		}
	}
}
