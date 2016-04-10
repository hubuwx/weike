package com.example.weike;

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;



import java.util.ArrayList;
import java.util.HashMap;

import com.example.weike.adapter.GridViewAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

/**
 * @author ����
 *  �γ��б���
 */
public class courses_list extends Activity {

	private GridView gridview;
	private GridViewAdapter adapter;
	private Button search;

	 private int images[] = { R.drawable.weikephoto20150729005,
	 R.drawable.weikephoto20150729002, R.drawable.weikephoto20150729003,
	 R.drawable.weikephoto20150729004, R.drawable.weikephoto20150729011,
	 R.drawable.weikephoto20150729006, R.drawable.weikephoto20150729007,
	 R.drawable.weikephoto20150729008, R.drawable.weikephoto20150729009,
	 R.drawable.weikephoto20150729010, R.drawable.weikephoto20150729001,
	 R.drawable.weikephoto20150729005, R.drawable.weikephoto20150729002,
	 R.drawable.weikephoto20150729003, R.drawable.weikephoto20150729004,
	 R.drawable.weikephoto20150729011, R.drawable.weikephoto20150729006,
	 R.drawable.weikephoto20150729007, R.drawable.weikephoto20150729008,
	 R.drawable.weikephoto20150729009, R.drawable.weikephoto20150729010,
	 R.drawable.weikephoto20150729001 };
	 private String names[] = { "ʮ����ФAPP�����̳�", "���ﳵ���ܽ���", "��Դ������", "�������ֳ",
	 "autoCompleteTextView����", "ˮ����_ ����������", "ˮ����_��֦������",
	 "ˮ����_���ѵİ�˪��ʲô", "ˮ����֮���������⨺���", "ͼ����Ӧ�ü��", "�ɹ���ʿ���߸�����ϰ��",
	 "ʮ����ФAPP�����̳�", "���ﳵ���ܽ���", "��Դ������", "�������ֳ",
	 "autoCompleteTextView����", "ˮ����_ ����������", "ˮ����_��֦������",
	 "ˮ����_���ѵİ�˪��ʲô", "ˮ����֮���������⨺���", "ͼ����Ӧ�ü��", "�ɹ���ʿ���߸�����ϰ��" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.courses_list);
		gridview = (GridView) findViewById(R.id.gridView1);
		search = (Button) findViewById(R.id.search);
		adapter = new GridViewAdapter(this);
		gridview.setAdapter(adapter);
		
		
//		gridview.setAdapter(new MyAdapter());
		 ArrayList<HashMap<String, Object>> lstImageItem = new
		 ArrayList<HashMap<String, Object>>();
		 {
		 for (int i = 0; i < images.length; i++) {
		 HashMap<String, Object> map = new HashMap<String, Object>();
		 map.put("itemImage", images[i]);
		 map.put("itemText", names[i]);
		 lstImageItem.add(map);
		 }
		 SimpleAdapter saImageItems = new SimpleAdapter(this, lstImageItem,//����Դ
		 R.layout.every_course_list_style,// ��ʾ����
		 new String[] { "itemImage", "itemText" }, new int[] {
		 R.id.imageView1, R.id.textView1 });
		 gridview.setAdapter(saImageItems);
		
		 }

		//��gridView���������õ������
		gridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(courses_list.this,
						"��ѡ�����     " + gridview.getItemAtPosition(position).toString() + "   �γ�",
						Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(courses_list.this,activity_information.class);
				startActivity(intent);
			}
		});
		
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(courses_list.this, "������������ť", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
