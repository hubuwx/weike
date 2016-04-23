package com.example.weike;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * @author 王旭
 *  首次进入软件时进入的引导页
 */
public class GuiderActivity extends Activity implements OnClickListener {
	private Button btn;
	private ViewPager viewPager;
	private List<View> list;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_guide);
		btn = (Button) findViewById(R.id.welcome_guide_btn);
		btn.setOnClickListener(this);
		viewPager = (ViewPager) findViewById(R.id.welcome_viewPager);
		InitViewPager();
	}
	
	@Override
	public void onClick(View v) {
		startActivity(new Intent(getBaseContext(),LoginActivity.class));
		finish();
	}
	
	//初始化viewPager的方法
	public void InitViewPager(){
		list = new ArrayList<View>();
		ImageView iv = new ImageView(this);
		iv.setImageResource(R.drawable.guide_01);
		list.add(iv);
		ImageView iv1 = new ImageView(this);
		iv1.setImageResource(R.drawable.guide_02);
		list.add(iv1);
		ImageView iv2 = new ImageView(this);
		iv2.setImageResource(R.drawable.guide_03);
		list.add(iv2);
		
		//viewpager绑定适配器
		viewPager.setAdapter(new MyPagerAdapter());
		//监听viewpager滑动效果
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				//如果是第三个页面，则显示“点击进入”的按钮
				if (arg0==2) {
					btn.setVisibility(View.VISIBLE);
				}else{
					btn.setVisibility(View.INVISIBLE);
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		
	}
	
	class MyPagerAdapter extends  PagerAdapter{

		@Override
		public int getCount() {
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0==arg1;
		}
		
		//销毁item对象
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
//			super.destroyItem(container, position, object);
			container.removeView(list.get(position));
		}
		
		//初始化item实例方法
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(list.get(position));
			return list.get(position);
		}
		
	}


}
