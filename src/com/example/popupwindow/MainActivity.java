package com.example.popupwindow;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

public class MainActivity extends Activity {

	
	public void  showPopupWindow(){
		Button btn =(Button) findViewById(R.id.button1);
		View layout =getLayoutInflater().inflate(R.layout.pw, null);
		PopupWindow popupWindow=new PopupWindow(layout,LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		popupWindow.showAsDropDown(btn, 0, -110);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Timer timer =new Timer();
		TimerTask task=new TimerTask() {
			
			
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						showPopupWindow();
						
					}
				});
				
			}
		};
		timer.schedule(task, 1000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
