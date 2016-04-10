package com.example.weike.fragment;

import com.example.weike.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author 王旭
 *  分类页面的 fragment
 */
public class fragmentClass extends FragmentActivity {
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_class_index, null);
		return view;
	}
}
