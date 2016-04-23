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
 * @author ����
 * �������֮���ҳ�洦���߼�
 *  �ж��Ƿ��һ�ν���������������������ҳ���ҽ�������¼���浽sharedPreference
 *   �����ǣ���ֱ�ӽ����������ҳ������ʱ��ֱ�ӽ����½ҳ��
 *  ��ʱ��ת
 */
public class welcomeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		//ʹ��Handlerִ����ʱ��ת
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
			//���ǵ�һ�ν���
			if (Utils.getWelcomeBoolean(getBaseContext())) {
				startActivity(new Intent(getApplicationContext(),LoginActivity.class));
			}else{
				startActivity(new Intent(getApplicationContext(),GuiderActivity.class));
				//������ʼ�¼
				Utils.putWelcomeBoolean(getBaseContext(), true);
			}
			finish();
		}
		
	}
}
