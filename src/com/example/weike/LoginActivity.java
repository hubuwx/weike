package com.example.weike;

/**
 * @author ����
 *   ��ҳ�棬ʵ�ֵ�½�Ĺ���
 *    û���˺ŵ��û��������ע��ҳ��
 */
import com.example.weike.DbHelper.SqliteOpenHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener {

	private Button btn_login, btn_login_reset,not_login;
	private EditText edit_name, edit_password;
	private SQLiteDatabase db;
	private SqliteOpenHelper mysqlhelper;
//    private CheckBox auto;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mysqlhelper = new SqliteOpenHelper(LoginActivity.this);
		db = mysqlhelper.getWritableDatabase();

//		auto = (CheckBox) findViewById(R.id.auto);//��δʵ��

		btn_login = (Button) findViewById(R.id.login);
		btn_login_reset = (Button) findViewById(R.id.login_reset);
//		not_login = (Button) findViewById(R.id.not_login);
		edit_name = (EditText) findViewById(R.id.edit_name);
		edit_password = (EditText) findViewById(R.id.edit_password);
		

		btn_login.setOnClickListener(this);
		btn_login_reset.setOnClickListener(this);
		
		TextView reg = (TextView) findViewById(R.id.txt_reg);
		reg.setClickable(true);
		reg.setFocusable(true);
		reg.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.login:
			if(edit_name.getText().toString().equals("") || edit_name.getText().toString().equalsIgnoreCase(null)
					|| edit_password.getText().toString().equals("")||edit_password.getText().toString().equalsIgnoreCase(null))
				Toast.makeText(LoginActivity.this, "�����ˣ����û������������ϣ�",Toast.LENGTH_SHORT).show();	
			else{
			Cursor cursor1 = db.rawQuery(
					"select count(*) from normalusers where username = '"+ edit_name.getText().toString() + "'", null);
			cursor1.moveToNext();
			int count = cursor1.getInt(0);
			if (count == 1) {
				Cursor cursor = db.rawQuery(
						"select username,password from normalusers where username = '"+ edit_name.getText().toString() + "'", null);
				cursor.moveToNext();
		    if ((edit_name.getText().toString()).equals(cursor.getString(0).toString())
		    		&& (edit_password.getText().toString()).equals(cursor.getString(1).toString())) {
					Toast.makeText(LoginActivity.this, "��¼�ɹ���", Toast.LENGTH_SHORT).show();				
					
				//��¼�ɹ�����תҳ��					
					Intent intent = new Intent(LoginActivity.this,main.class);				 			  
					LoginActivity.this.finish();
					startActivity(intent);			    
			   }	
		      else { 
				Toast.makeText(LoginActivity.this, "��������û������������",Toast.LENGTH_SHORT).show();
				edit_name.setText("");
				edit_password.setText("");
		    	}
		        cursor.close();
		  
			} 
			  else { 
					Toast.makeText(LoginActivity.this, "��������û������������",Toast.LENGTH_SHORT).show();
					edit_name.setText("");
					edit_password.setText("");
			    	}
				
		
			}
			break;

		case R.id.login_reset:
			edit_name.setText("");
			edit_password.setText("");
			break;
			
		case R.id.txt_reg:
			Intent intent = new Intent(LoginActivity.this, regActivity.class);
			startActivity(intent);
			finish();
		}
	}
	
	
	private void close() {
		this.finish();
	}
}
