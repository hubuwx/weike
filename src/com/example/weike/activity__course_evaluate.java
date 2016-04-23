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
 * @author 王旭
 *  评价列表页面
 *  具体功能如下：1.listView列表显示所有的评价
 *							   2.用户可以参与课程评价
 */
public class activity__course_evaluate extends Activity implements OnClickListener{
	
	private Button btn_evaluate;
	private ListView listView_evaluate;
	private LinearLayout layout_evaluate;
	String[] item = {"1分 (很差)","2分 (差)","3分 (一般)","4分 (好)","5分 (很好)"};
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				// TODO Auto-generated method stub
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_evaluate);
				
				initView();
				initClickListener();
			}
			
			private void initClickListener() {
				// 初始化监听器
				btn_evaluate.setOnClickListener(this);
				layout_evaluate.setOnClickListener(this);
			}
			private void initView() {
				// 初始化控件
				btn_evaluate = (Button) findViewById(R.id.button_evaluate);
				layout_evaluate = (LinearLayout) findViewById(R.id.layout_evaluate);
				listView_evaluate = (ListView) findViewById(R.id.listView_evaluate);
				
			}
			
			int mSingleChoiceID = -1;  
			
			@Override
			public void onClick(View v) {
				// layout_evaluate和btn_evaluate的点击事件
				switch (v.getId()) {
				case R.id.button_evaluate:
			{		AlertDialog.Builder builder = new Builder(activity__course_evaluate.this); 
					builder.setTitle("课程评分"); 
//					builder.setView(new RatingBar(activity_evaluation.this)); 
//					builder.setMessage("请选择评分等级，填写评语！");
					builder.setSingleChoiceItems(item, 0,new DialogInterface.OnClickListener (){
						@Override
						public void onClick(DialogInterface dialog, int which) {
							 mSingleChoiceID = which;  
						}});
					builder.setView(new EditText(activity__course_evaluate.this)); 
					builder.setPositiveButton("确定",null); 
			
//			final View view =  LayoutInflater.from(this).inflate(R.layout.dialog_evaluate, null);  
//		     builder.setTitle("课程评分");  
//		     builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  
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
