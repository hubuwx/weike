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
 * @author ����
 * ��ʾ�γ�ͼ���б��GridView��������
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
	private String names[] = { "ʮ����ФAPP�����̳�", "���ﳵ���ܽ���", "��Դ������", "�������ֳ",
			"autoCompleteTextView����", "ˮ����_ ����������", "ˮ����_��֦������",
			"ˮ����_���ѵİ�˪��ʲô", "ˮ����֮���������⨺���", "ͼ����Ӧ�ü��", "�ɹ���ʿ���߸�����ϰ��", };
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
