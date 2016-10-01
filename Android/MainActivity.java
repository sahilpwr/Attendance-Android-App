package com.example.attendance;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	Button log;
	Spinner spin;
	String subject;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 
		/*for black backgrnd:
		in valuues string.xml put <color name="black">#000000</color>
		and in .xml put android:background="#444444"*/
		
		//for password field use hint param to display text
		
		spin=(Spinner)findViewById(R.id.spinner1);
		
		 List<String> list = new ArrayList<String>();
	       list.add("CHOOSE SUBJECT");
	       list.add("TOC");
	       list.add("DBMS");
	       list.add("DCWN");
	       list.add("CFCA");
	       list.add("OSD");
	      
	       
	       //create an ArrayAdaptar from the String Array
	       ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
	               android.R.layout.simple_spinner_item, list);
	       //set the view for the Drop down list
	       dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	       //set the ArrayAdapter to the spinner
	       spin.setAdapter(dataAdapter);
	       //attach the listener to the spinner
	     //  spin.setOnItemSelectedListener(new MyOnItemSelectedListener());
		
		log=(Button)findViewById(R.id.date1);
		setAlphaForView(spin, 0.5f);
		setAlphaForView(log, 0.5f);
		
		
		log.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				EditText username,password;
				username=(EditText)findViewById(R.id.editText1);
				password=(EditText)findViewById(R.id.editText2);
				
				subject=spin.getSelectedItem().toString();
				// Toast.makeText(getBaseContext(),subject,Toast.LENGTH_SHORT).show();
				
				
				if(username.getText().toString().equals("")&&password.getText().toString().equals("")&&subject.equals("DCWN"))
				{
					username.setText("");
					password.setText("");
					spin.setId(1);
					Toast.makeText(getBaseContext(),"LOGGED IN",Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(MainActivity.this,Dcwn.class);
    				startActivity(intent);
				}
				else if(username.getText().toString().equals("")&&password.getText().toString().equals("")&&subject.equals("DBMS"))
				{
					username.setText("");
					password.setText("");
					Toast.makeText(getBaseContext(),"LOGGED IN",Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(MainActivity.this,Dbms.class);
    				startActivity(intent);
					
				}
				else if(username.getText().toString().equals("admin")&&password.getText().toString().equals("admin")&&subject.equals("TOC"))
				{
					username.setText("");
					password.setText("");
					Toast.makeText(getBaseContext(),"LOGGED IN",Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(MainActivity.this,Toc.class);
    				startActivity(intent);
					
				}
				else if(username.getText().toString().equals("admin")&&password.getText().toString().equals("admin")&&subject.equals("OSD"))
				{
					username.setText("");
					password.setText("");
					Toast.makeText(getBaseContext(),"LOGGED IN",Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(MainActivity.this,Osd.class);
    				startActivity(intent);
					
				}
				else if(username.getText().toString().equals("admin")&&password.getText().toString().equals("admin")&&subject.equals("CFCA"))
				{
					username.setText("");
					password.setText("");
					Toast.makeText(getBaseContext(),"LOGGED IN",Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(MainActivity.this,Cfca.class);
    				startActivity(intent);
					
				}
				else 
				{
					username.setText("");
					password.setText("");
					 Toast.makeText(getBaseContext(),"WRONG USERID OR PASSWORD",Toast.LENGTH_SHORT).show();
				}
				
			}
		});
		
		
	}

	private void setAlphaForView(View v, float alpha) {
		AlphaAnimation animation = new AlphaAnimation(alpha, alpha);
		animation.setDuration(0);
		animation.setFillAfter(true);
		v.startAnimation(animation);
		
	}

	 
 
}
