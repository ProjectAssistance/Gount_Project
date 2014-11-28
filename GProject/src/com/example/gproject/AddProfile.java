package com.example.gproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class AddProfile extends Activity {

	
	public static final String[] pill = new String[] { "iiiii", "ttttt", "oooooo", "yyyyy" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_profile);
		
		//pillSniper
		final Spinner spinner = (Spinner) findViewById(R.id.pillSpinner);
		
		//สร้าง Adapter และนำไปกำหนดให้กับ Spinner
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_item, pill);
		spinner.setAdapter(adapter);
		
		//ระบุการทำงานเมื่อไแเท็มใน Sniper ลูกเลือก
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			
			//เมธอดที่จะถูกเรียกเมื่อไอเท็มหนึ่งถูกเลือก
			@Override
			public void onItemSelected(AdapterView<?> av, View view,
					int position, long id) {
				System.out.println("pillSpinner --> Select : " + ((TextView) view).getText());
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> av) {
					return;
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_profile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
