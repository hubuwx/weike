package com.example.weike.adapter;

import com.example.weike.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class class_listView_adapter extends BaseAdapter {

	private String names[] = {"课程1","课程2","课程3","课程4","课程5","课程6","课程7"};
	   private Context context;
	   public class_listView_adapter(Context context) {
			this.context = context;
		}
	
	@Override
	public int getCount() {		return names.length;	}

	@Override
	public Object getItem(int position) {		return names[position];	}

	@Override
	public long getItemId(int position) {		return position;	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view =convertView;
		ViewHolder holder;
		if (view==null) {
			view=LayoutInflater.from(context).inflate(R.layout.activity_course_list_item,null); 
			holder=new ViewHolder(); 
			holder.tv_name=(TextView)view.findViewById(R.id.tv_className); 
			for(int i=0;i<position+1;i++)
			holder.tv_name.setText(names[i]);
			view.setTag(holder); 
		}else 
		{ 
			holder=(ViewHolder)view.getTag(); 
		} 
			return view; 
	}

	class ViewHolder 
	{ 
	TextView tv_name; 
	} 
}
