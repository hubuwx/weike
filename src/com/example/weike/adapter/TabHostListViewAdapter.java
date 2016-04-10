package com.example.weike.adapter;

import java.util.List;

import com.example.weike.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 *   @author 王旭
 * 包括在tabHost里 listView 的适配器
 *  
 */
public class TabHostListViewAdapter extends BaseAdapter {

	
	private List<String> list;
	private Context context;

	public TabHostListViewAdapter(List<String> list,Context context) {
		this.list = list;
		this.context = context;
	}
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView ==null){
			convertView = LayoutInflater.from(context).inflate(R.layout.tabhost_listview_items, null);
		}
		TextView tv = (TextView) convertView.findViewById(R.id.tv);
		tv.setText(list.get(position));
		
		return convertView;
	}

}
