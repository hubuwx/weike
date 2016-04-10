package com.example.weike.adapter;


import com.example.weike.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author 王旭
 * 显示课程图文列表的GridView的适配器
 *
 */
public class GridViewAdapter extends BaseAdapter {

	private Context context;
	private int images[] = { R.drawable.weikephoto20150729005,
			R.drawable.weikephoto20150729002,
			R.drawable.weikephoto20150729003,
			R.drawable.weikephoto20150729004,
			R.drawable.weikephoto20150729011,
			R.drawable.weikephoto20150729006,
			R.drawable.weikephoto20150729007,
			R.drawable.weikephoto20150729008,
			R.drawable.weikephoto20150729009,
			R.drawable.weikephoto20150729010,
			R.drawable.weikephoto20150729001, };
	private String names[] = { "十二生肖APP制作教程", "购物车功能介绍", "开源软件简介", "生物的生殖",
			"autoCompleteTextView概述", "水果课_ 火龙果传奇", "水果课_荔枝的秘密",
			"水果课_葡萄的白霜是什么", "水果课之奇异果还是猕猴桃", "图案锁应用简介", "成功人士的七个良好习惯", };
	public GridViewAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return  names.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return names[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.every_course_list_style, null);
		ImageView iv = (ImageView) view.findViewById(R.id.imageView1);
		TextView tv =(TextView) view.findViewById(R.id.textView1);
		iv.setImageResource(images[position]);
		tv.setText(names[position]);
		
		return view;
	}

}
