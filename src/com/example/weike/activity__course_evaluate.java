package com.example.weike;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
/**
 * 
 * @author ����
 *  �����б�ҳ��
 *  ���幦�����£�1.listView�б���ʾ���е�����
 *							   2.�û����Բ���γ�����
 */
public class activity__course_evaluate extends Activity implements OnClickListener{
	
	private Button btn_evaluate;
	private ListView listView_evaluate;
	private LinearLayout layout_evaluate;
	String[] item = {"1�� (�ܲ�)","2�� (��)","3�� (һ��)","4�� (��)","5�� (�ܺ�)"};
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_evaluate);
				
				initView();
				initClickListener();
			}
			
			private void initClickListener() {
				// ��ʼ��������
				btn_evaluate.setOnClickListener(this);
				layout_evaluate.setOnClickListener(this);
			}
			private void initView() {
				// ��ʼ���ؼ�
				btn_evaluate = (Button) findViewById(R.id.button_evaluate);
				layout_evaluate = (LinearLayout) findViewById(R.id.layout_evaluate);
				listView_evaluate = (ListView) findViewById(R.id.listView_evaluate);
				
			}
			
			int mSingleChoiceID = -1;  
			
			@Override
			public void onClick(View v) {
				// layout_evaluate��btn_evaluate�ĵ���¼�
				switch (v.getId()) {
				case R.id.button_evaluate:
			{		AlertDialog.Builder builder = new Builder(activity__course_evaluate.this); 
					builder.setTitle("�γ�����"); 
//					builder.setView(new RatingBar(activity_evaluation.this)); 
//					builder.setMessage("��ѡ�����ֵȼ�����д���");
					builder.setSingleChoiceItems(item, 0,new DialogInterface.OnClickListener (){
						@Override
						public void onClick(DialogInterface dialog, int which) {
							 mSingleChoiceID = which;  
						}});
					builder.setView(new EditText(activity__course_evaluate.this)); 
					builder.setPositiveButton("ȷ��",null); 
			
//			final View view =  LayoutInflater.from(this).inflate(R.layout.dialog_evaluate, null);  
//		     builder.setTitle("�γ�����");  
//		     builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {  
//		         public void onClick(DialogInterface dialog, int whichButton) {  
//
//		         EditText editText_evaluate = (EditText) view.findViewById(R.id.editText_evaluate);  
//		         RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);  
//		         // userName.getText().toString()  +  password.getText().toString();  
//		         }  
//		     });  
					builder.show(); 		}
					break;
				default:
					break;
				}
			}

			
}
