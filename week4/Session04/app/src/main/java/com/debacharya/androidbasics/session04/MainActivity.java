package com.debacharya.androidbasics.session04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentThree.DataListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onStart() {
		super.onStart();

		FragmentTwo fragmentTwo = new FragmentTwo();
		FragmentThree fragmentThree = new FragmentThree();
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

		fragmentTransaction.add(R.id.fragment2_container, fragmentTwo);
		fragmentTransaction.add(R.id.fragment3_container, fragmentThree);
		fragmentTransaction.commit();
	}

	@Override
	public void listen(String value) {
		Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();

		FragmentTwo fragmentTwo = new FragmentTwo();
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		Bundle bundle = new Bundle();

		bundle.putString(Keystore.KEY_ONE, value);
		fragmentTwo.setArguments(bundle);

		fragmentTransaction
			.replace(R.id.fragment2_container, fragmentTwo)
			.commit();
	}
}