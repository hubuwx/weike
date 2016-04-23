package com.example.weike;


import com.example.weike.R;
import com.example.weike.adapter.Personal_Adapter;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author ����
 *  ����ҳ�棬������ʾ����һЩ�����Ϣ
 *   
 *
 */
public class PersonalActivity extends Activity {

	private ListView listView;
//	private ImageView imageView1,imageView2;
	private TextView tv_xiaoshishu,tv_jieshu;//�ۿ���ʱ��
	private ImageButton personalMessage;//ͷ��ť
	private Personal_Adapter adapter;
//	private Intent intent = new Intent();
//	private Button feedback;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
		setContentView(R.layout.activity_personal);
		
		tv_jieshu=(TextView) findViewById(R.id.jieshu);
		tv_jieshu.setText("");//����ʱ��
		tv_xiaoshishu=(TextView) findViewById(R.id.xiaoshishu);
		tv_xiaoshishu.setText("");//����ʱ��
		personalMessage= (ImageButton) findViewById(R.id.personalMessage);
		personalMessage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(PersonalActivity.this,personalMessage.class);
				intent.putExtra("title", "������Ϣ");
				startActivity(intent);
			}
		});
		listView = (ListView) findViewById(R.id.listView1);
		adapter= new Personal_Adapter(this);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				String values = listView.getItemAtPosition(position).toString();
				Toast.makeText(PersonalActivity.this, "��ǰ�����itemֵΪ"+values, Toast.LENGTH_SHORT).show();
//				if(values.equals("�ҵĿγ�")){
//					intent.setClass(PersonalActivity.this,mycourses.class);
//					intent.putExtra("title", values);
//					startActivity(intent);
//				}
//				
//				if(values.equals("ֱ������")){
//					intent.setClass(PersonalActivity.this,livecourses.class);
//					intent.putExtra("title1", values);
//					startActivity(intent);
//				}
//				
//				if(values.equals("�ۿ���ʷ")){
//					intent.setClass(PersonalActivity.this,learninghistory.class);
//					intent.putExtra("title2", values);
//					startActivity(intent);
//				}
//				
//				if(values.equals("�ҵ�����")){
//					intent.setClass(PersonalActivity.this,myquestions.class);
//					intent.putExtra("title3", values);
//					startActivity(intent);
//				}
//				
//				if(values.equals("�ҵıʼ�")){
//					intent.setClass(PersonalActivity.this,mynotes.class);
//					intent.putExtra("title4", values);
//					startActivity(intent);
//				}
//				
//			}
//		});

//        feedback=(Button) findViewById(R.id.feed_back_btn);
//        feedback.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View arg0) {
//				Intent intent = new Intent(personalActivity.this,FeedbackMainActivity.class);
//				startActivity(intent);
//			}
//		});
	
	}
});
	}
	}

