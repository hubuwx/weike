package com.example.weike;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 *  @author  ����
 *  �γ���Ϣҳ��
 *  
 * ��һ��ʵ�ֵ��������ݿ�״̬�µ�������ʾ
 * �ڶ����ڴ�ҳ��ʵ�ֶ����ݿ��еĿγ̽��м���
 * ͨ���γ����ҵ����ݿ��ж�Ӧ��ID��Ȼ����ص���ҳ����ʾ
 */
public class activity_course_details extends Activity {
	private TextView course_name,course_source,course_brif_introducation;
	private ImageView course_mindmap;
//	private ListView listView_courses;
//	private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_course_details);
    	
    	course_name = (TextView) findViewById(R.id.course_name);
    	course_source=(TextView) findViewById(R.id.course_source);
    	course_brif_introducation = (TextView) findViewById(R.id.course_brif_introducation);
    	course_mindmap = (ImageView) findViewById(R.id.course_mindmap);
//    	listView_courses = (ListView) findViewById(R.id.listView_courses);
//    	
//    	listView_courses.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getData()));
//    	listView_courses.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?>  parent, View view, int position,
//					long id) {
//				Toast.makeText(activity_course_details.this, "�����"+listView_courses.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
//			}
//    		
//		});
//    }
//	public List<String> getData() {
//		List<String> list = new ArrayList<String>();
//		for (int i = 1; i < 100; i++) {
//			list.add("JSP������Ƶ�   " + i + "  ��");
//		}
//		return list;
	}
	
	
    
}
