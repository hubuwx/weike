package com.example.weike;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class CommunicationActivity extends Activity {
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  
			this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
			setContentView(R.layout.activity_communicate);
		}
}
