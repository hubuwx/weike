package com.example.weike;




import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


public class UIActivity extends TabActivity {
	
	private TabHost tabHost;
	private LayoutInflater layoutInflater;
	
	String[] mTitle = new String[] { "首页", "分类", "交流", "个人" };
	int[] mIcon = new int[] { R.drawable.icon_main_pressed, R.drawable.icon_class_pressed,
			R.drawable.icon_discuss_pressed, R.drawable.icon_personal_pressed };
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.ui_activity_xml);
			
			initTabView();
		}
		
		
		public View getTabItemView(int i) {
			LayoutInflater inflater = LayoutInflater.from(getBaseContext());
			View view = inflater.inflate(R.layout.item_tab_widget, null);
			ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
			imageView.setImageResource(mIcon[i]);
			TextView textView = (TextView) view.findViewById(R.id.textview);
			textView.setText(mTitle[i]);
			return view;
		}
		private void initTabView() {
			tabHost = getTabHost();
			layoutInflater = LayoutInflater.from(this);
			TabHost.TabSpec spec;

			Intent intent1 = new Intent(this, HomeActivity.class);
			spec = tabHost.newTabSpec(mTitle[0]).setIndicator(getTabItemView(0))
					.setContent(intent1);
			tabHost.addTab(spec);

			Intent intent2 = new Intent(this, ClassActivity.class);
			spec = tabHost.newTabSpec(mTitle[1]).setIndicator(getTabItemView(1))
					.setContent(intent2);
			tabHost.addTab(spec);

			Intent intent3 = new Intent(this, CommunicationActivity.class);
			spec = tabHost.newTabSpec(mTitle[2]).setIndicator(getTabItemView(2))
					.setContent(intent3);
			tabHost.addTab(spec);

			Intent intent4 = new Intent(this, PersonalActivity.class);
			spec = tabHost.newTabSpec(mTitle[3]).setIndicator(getTabItemView(3))
					.setContent(intent4);
			tabHost.addTab(spec);
		}
}
