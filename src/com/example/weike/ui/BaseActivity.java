package com.example.weike.ui;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/*
 * 对activity进行操作的类
 */
public class BaseActivity extends Activity {
	protected void onCreate(Bundle paramBundle)
	  {
	    super.onCreate(paramBundle); 
	  } 
	  protected void onResume()
	  {
	    super.onResume();
	   
	  }

	  protected void onStop()
	  {
	    super.onStop(); 
	  }
	  
	  public Handler mainHandler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				switch (msg.what) {
//				case UIUtils.StrDialog:
//					startWationDialog();
//					
//					break;
//				case UIUtils.StopDialog:
//					closeWationDialog();
//					break;

				default:
					break;
				}
			}
			
		};

	//@Override
	//public void onTabChanged(int paramInt) {
//		// TODO Auto-generated method stub
	//	
	//}
}
