package com.example.weike;

import com.example.weike.DbHelper.SqliteOpenHelper;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author ����
 *  ע��ҳ��
 */
public class regActivity extends Activity {
	private EditText userName, userPassword1, userPassword2;
	private SqliteOpenHelper mySqlHelper;
	private SQLiteDatabase db;
	private Button btn_reg, btn_clear;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		mySqlHelper = new SqliteOpenHelper(regActivity.this);
		db = mySqlHelper.getWritableDatabase();

		// ͨ��id�ҵ�ÿһ���ؼ�
		userName = (EditText) findViewById(R.id.editName);
		userPassword1 = (EditText) findViewById(R.id.editPassword);
		userPassword2 = (EditText) findViewById(R.id.editPassword2);
		btn_reg = (Button) findViewById(R.id.btn_reg);
		btn_clear = (Button) findViewById(R.id.btn_reset);
		// ��button����
		btn_reg.setOnClickListener(new View.OnClickListener() {
			// �ȶ��˺Ž����жϣ��ж����ݿ����Ƿ����ظ��˺�
			// �ٶ�����������������жϣ����������������Ƿ�һ��
			// ע��ɹ������ע�ᡱ������д�����ݿ⣬����ת�ص�¼����
			@Override
			public void onClick(View v) {
				if (userName.getText().toString().equals("")
						|| userName.getText().toString().equalsIgnoreCase(null)
						|| userPassword1.getText().toString().equals("")
						|| userPassword1.getText().toString()
								.equalsIgnoreCase(null)
						|| userPassword2.getText().toString().equals("")
						|| userPassword2.getText().toString()
								.equalsIgnoreCase(null))
					Toast.makeText(regActivity.this, "��ϢҪ��������Ŷ��",
							Toast.LENGTH_SHORT).show();
				else {	
					if (userPassword1.getText().toString()
							.equals(userPassword2.getText().toString())) {
						Cursor cursor = db.rawQuery(
								"select count(*) from normalusers where username = '"
										+ userName.getText().toString() + "'",
								null);
						cursor.moveToNext();
						int count = cursor.getInt(0);
						if (count == 0) {
							ContentValues values = new ContentValues();
							values.put("username", userName.getText()
									.toString());
							values.put("password", userPassword1.getText()
									.toString());
							db.insertOrThrow("normalusers", null, values);
							Toast.makeText(regActivity.this, "ע��ɹ�,���¼��",
									Toast.LENGTH_SHORT).show();
							Intent intent = new Intent(regActivity.this,
									LoginActivity.class);
							regActivity.this.finish();
							startActivity(intent);
						} else {
							Toast.makeText(regActivity.this, "��ע����û����Ѵ��ڣ�",
									Toast.LENGTH_SHORT).show();
						}
						cursor.close();
					} else {
						Toast.makeText(regActivity.this, "��������������벻һ����",
								Toast.LENGTH_SHORT).show();
					}
				}
			}
		});

		btn_clear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				userName.setText("");
				userPassword1.setText("");
				userPassword2.setText("");
			}
		});
	}
}
