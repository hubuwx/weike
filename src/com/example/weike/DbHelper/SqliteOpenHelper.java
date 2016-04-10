package com.example.weike.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author 王旭
 * 数据库帮助类
 *
 */
public class SqliteOpenHelper extends SQLiteOpenHelper {

	private final static String DbName = "weike.db";
	private final static int DbVersion = 1;

	public SqliteOpenHelper(Context context) {
		super(context, DbName, null, DbVersion);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table normalusers(_id integer primary key autoincrement,"
				+ "username varchar(20)," + "password varchar(20))");
		db.execSQL("create table Managers(_id integer primary key autoincrement,"
				+ "User varchar(20)," + "Pass varchar(20))");
		

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int OldVersion, int NewVersion) {

	}

}
