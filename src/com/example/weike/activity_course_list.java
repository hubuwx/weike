package com.example.weike;

import com.example.weike.adapter.class_listView_adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_course_list extends Activity{
	
	private TextView class_name;
	private ListView list_class;
	private class_listView_adapter adapter;
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_course_list);
			initView();
			
		}

		private void initView() {
				adapter = new class_listView_adapter(getApplicationContext());//初始化适配器
				//通过findViewById找到控件
				class_name = (TextView) findViewById(R.id.class_name);
				list_class = (ListView) findViewById(R.id.listView_class);
				//接收intent的值
				Intent i = getIntent();
				String name = i.getStringExtra("name");
				class_name.setText(name);
				//绑定适配器
				list_class.setAdapter(adapter);
				list_class.setOnItemClickListener(new OnItemClickListener() {
					
					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						
//						Toast.makeText(getApplicationContext(), "你点击的是"+list_class.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
						if(position != 1){
							Toast.makeText(getApplicationContext(), "你点击的是"+list_class.getItemIdAtPosition(position)+"请点击课程2跳转！", Toast.LENGTH_SHORT).show();
						}else{
							startActivity(new Intent(getApplicationContext(),every_course_activity.class));
							
						}
					}
				});
		}

		
}
