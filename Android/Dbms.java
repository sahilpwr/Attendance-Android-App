package com.example.attendance;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.util.Log;
import android.view.View;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.view.animation.AlphaAnimation;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings.System;
import android.support.v7.app.ActionBarActivity;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class Dbms extends ActionBarActivity implements OnClickListener{

    private static String a;

	Button ab,pr,date,lec,submit;
	String[] msg =new String[72];

	String date_ser;
	int mYear, mMonth, mDay, mHour, mMinute,count,j=1;
     
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_dcwn); 
        
      
        date=(Button)findViewById(R.id.date);
        lec=(Button)findViewById(R.id.lectures);
        ab=(Button)findViewById(R.id.absent);
        pr=(Button)findViewById(R.id.present);
        submit=(Button)findViewById(R.id.submit);
        
        date.setOnClickListener(this);

        setAlphaForView(date, 0.5f);
        setAlphaForView(lec, 0.5f);
        setAlphaForView(ab, 0.5f);
        setAlphaForView(pr, 0.5f);
        setAlphaForView(submit, 0.5f);
        
        submit.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) 
			
			{
		        String k = null;
				
			
						
				
				msg[0]=date_ser;
				
				TextView t;
				t=(TextView)findViewById(R.id.textView1);
				
				
				  	    HttpClient httpclient = new DefaultHttpClient();
				   	    HttpPost httppost = new HttpPost("http://www.attend.attend.5gbfree.com/dbms.php");
				   	    
				   	 try {
					   	   List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
					    int i = 0;
					    
					    nameValuePairs.add(new BasicNameValuePair("message"+i, msg[i]));
					    
					    count++;
					   	   for( i=1;i<count;i++) 
					   		   nameValuePairs.add(new BasicNameValuePair("message"+i, msg[i]));
					      
					      
					   	
					   	
					       httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					       
					   	   httpclient.execute(httppost);
					   	   
					   	   Toast.makeText(getBaseContext(),"DATABASE UPDATED",Toast.LENGTH_SHORT).show();
					   	   
					     }
					   	 catch (ClientProtocolException e)
						     {
						         
						     } 
					   	 catch (IOException e)
						   	 {
						         
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

    
    @Override
    public void onClick(View v) {
   	 
        
        if(v==date)
        {
        // Process to get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // Launch Date Picker Dialog
        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

					@Override
					public void onDateSet(DatePicker view, int selectedYear, int selectedMonth,
							int selectedDay) {
						
						mYear = selectedYear;
				        mMonth = selectedMonth;
				        mDay = selectedDay;
				        date_ser=mDay+"/"+mMonth+"/"+mYear;
				        
				        
				        TextView tv;
				        tv=(TextView)findViewById(R.id.textView1);
				        tv.setText(new StringBuilder().append(mDay)
				                .append("-").append(mMonth + 1).append("-").append(mYear)
				                .append(" "));

					}
                }, mYear, mMonth, mDay);
        dpd.show();
        }
    }


	public void Lectures_Dialog(View v)
    {
		
		List<String> listItems = new ArrayList<String>(72);
		for(int i=1;i<=4;i++)
		listItems.add(Integer.toString(i));

		
		final CharSequence[] items = listItems.toArray(new CharSequence[listItems.size()]);
		final boolean[] itemsChecked = new boolean[items.length];
		
		
    	AlertDialog.Builder builder=new AlertDialog.Builder(this);
    	builder.setTitle("LECTURES CONDUCTED");
    	
    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
          	  int j=0;
            	
           for (int i = 0; i < items.length; i++)
           {
                if (itemsChecked[i])
                {
              	 
                    itemsChecked[i]=true;
                    
                }
            }
            
            }
        });
    	
    	builder.setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					itemsChecked[which]=isChecked;	
			}
		});
    	builder.show();
    }
    
    
  	public void Absent_Dialog(View v)
      {
  		
  		 
  		
  		List<String> listItems = new ArrayList<String>(72);
  		for(int i=3401;i<=3472;i++)
  		listItems.add(Integer.toString(i));

  		
  		final CharSequence[] items = listItems.toArray(new CharSequence[listItems.size()]);
  		final boolean[] itemsChecked = new boolean[items.length];
  		
  		
      	AlertDialog.Builder builder=new AlertDialog.Builder(this);
      	builder.setTitle("ABSENT ROLL NUMBER");
      	
      	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

              @Override
              public void onClick(DialogInterface dialog, int which) {
            	 
              	
             for (int i = 0; i < items.length; i++)
             {
                  if (itemsChecked[i])
                  {
                	  msg[j]=items[i].toString();
                      itemsChecked[i]=false;
                      j++;
                      count++;
                  }
              }
            
              }
             
              
          });
      	
      	builder.setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
  			
  			@Override
  			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
  					itemsChecked[which]=isChecked;	
  			}
  		});
      	builder.show();
      }
	
  	 	 	
  	public void Present_Dialog(View v)
    {

		List<String> listItems = new ArrayList<String>(72);
		for(int i=3401;i<=3472;i++)
		listItems.add(Integer.toString(i));

		
		final CharSequence[] items = listItems.toArray(new CharSequence[listItems.size()]);
		final boolean[] itemsChecked = new boolean[items.length];
		
		
    	AlertDialog.Builder builder=new AlertDialog.Builder(this);
    	builder.setTitle("PRESENT ROLL NUMBER");
    	
    	builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
           
            int j = 0;	
            
           for (int i = 0; i < items.length; i++)
           {
                if (itemsChecked[i])
                {
                    
                    
                    
                }
                else
                {
                	itemsChecked[i]=false;
                	 msg[j]=items[i].toString();
                	 j++;
                	 count++;
                	 
                }
            }
           
            }
        });
    	
    	builder.setMultiChoiceItems(items, itemsChecked, new DialogInterface.OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					itemsChecked[which]=isChecked;	
			}
		});
    	builder.show();
    }
  		
}
    
