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
 *  个人页面的listView的适配器
 *
 */
public class Personal_Adapter extends BaseAdapter{

	private int image1[] = {R.drawable.main_index_tuan_pressed,R.drawable.main_index_my_pressed,R.drawable.main_index_home_pressed};
	   private String names[] = {"我的课程","直播课堂","观看历史"};
//	   private int image2[] = {};
	   private Context context;
	   public Personal_Adapter(Context context) {
			this.context = context;
		}
	@Override
	public int getCount() {
		return names.length;
	}

	@Override
	public Object getItem(int position) {
		return names[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = LayoutInflater.from(context);
		View view = inflater.inflate(R.layout.personal_items, null);
		ImageView iv1 = (ImageView)view.findViewById(R.id.imageView1);
//		ImageView iv2 = (ImageView)view.findViewById(R.id.imageView2);
		TextView tv = (TextView)view.findViewById(R.id.textView1);
		 
		iv1.setImageResource(image1[position]);
//		iv2.setImageResource(image2[position]);
		tv.setText(names[position]);
//		listView.LayoutParams lp = new listView.LayoutParams(
//             LinearLayout.LayoutParams.FILL_PARENT, 70);
//convertView.setLayoutParams(lp);
		
		return view;
	}
	   

}
