package com.example.weike.Utils;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build;

/**
 * @author 王旭
 *  公共常量类
 */

public class Utils {
	
	  private static final String FILE_NAME = "weike";
	  private static final String MODE_NAME = "wangxu";
	
	//sharedPreference 的常量
	
		/**
		 * 获取boolean类型的数据
		 *  getWelcomeBoolean获得登陆的状态，putWelcomeBoolean写入登陆的状态
		 *  getWelcomeBoolean，putWelcomeBoolean主要用来判断是否第一次启动程序
		 */
		public static boolean getWelcomeBoolean(Context context){
			return context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE).getBoolean(MODE_NAME, false);
		} 	
		
		public static void putWelcomeBoolean(Context context,boolean isFirst){
			Editor edit = context.getSharedPreferences(FILE_NAME, Context.MODE_APPEND).edit();
			edit.putBoolean(MODE_NAME, isFirst);
			edit.commit();
		}
		
		public static final boolean IS_JBMR2 = Build.VERSION.SDK_INT == Build.VERSION_CODES.JELLY_BEAN_MR2;
	    static final boolean IS_ISC = Build.VERSION.SDK_INT == Build.VERSION_CODES.ICE_CREAM_SANDWICH;
	    static final boolean IS_GINGERBREAD_MR1 = Build.VERSION.SDK_INT == Build.VERSION_CODES.GINGERBREAD_MR1;
}
