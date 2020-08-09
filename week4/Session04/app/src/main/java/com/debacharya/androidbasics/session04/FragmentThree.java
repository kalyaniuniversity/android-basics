package com.debacharya.androidbasics.session04;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentThree extends Fragment {

	private DataListener parentActivity;
	private MainActivity rootActivity;

	public interface DataListener {
		void listen(String value);
	}

	@Override
	public void onAttach(@NonNull Context context) {
		super.onAttach(context);

		try {
			this.parentActivity = (DataListener) context;
			this.rootActivity = (MainActivity) context;
		} catch (ClassCastException e) {
			Log.e("cce", "parent activity must implement DataListener");
		}
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_three, container, false);
	}

	@Override
	public void onStart() {
		super.onStart();

		Button button = getView().findViewById(R.id.bt_fragment3);

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				EditText editText = getView().findViewById(R.id.et_fragment3);
				String value = editText.getText().toString();

				parentActivity.listen(value);

				// replacing fragment with itself
				rootActivity
					.getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.fragment3_container, new FragmentThree())
					.commit();
			}
		});
	}
}
