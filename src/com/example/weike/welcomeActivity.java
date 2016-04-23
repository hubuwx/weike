package com.example.weike;

import java.util.Timer;
import java.util.TimerTask;

import com.example.weike.Utils.Utils;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.os.Handler;
//import android.widget.TimePicker;

/**
 * @author 王旭
 * 开启软件之后的页面处理逻辑
 *  判断是否第一次进入软件，若是则进入引导页，且将启动记录保存到sharedPreference
 *   若不是，则直接进入软件的主页，测试时是直接进入登陆页面
 *  延时跳转
 */
public class welcomeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		//使用Handler执行延时跳转
//		new Handler(new Handler.Callback() {
//			
//			@Override
//			public boolean handleMessage(Message msg) {
//				startActivity(new Intent(getApplicationContext(),MainActivity.class));
//				finish();
//				return false;
//			}
//		}).sendEmptyMessageDelayed(0, 2000);
		
		//
		Timer timer  = new Timer();
		timer.schedule(new Task(), 1000);
		
		
	}
	class Task extends TimerTask{

		@Override
		public void run() {
			//不是第一次进入
			if (Utils.getWelcomeBoolean(getBaseContext())) {
				startActivity(new Intent(getApplicationContext(),LoginActivity.class));
			}else{
				startActivity(new Intent(getApplicationContext(),GuiderActivity.class));
				//保存访问记录
				Utils.putWelcomeBoolean(getBaseContext(), true);
			}
			finish();
		}
		
	}
}
