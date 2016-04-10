package com.example.weike.fragment;

import com.example.weike.R;
//import com.lidroid.xutils.ViewUtils;
//import com.lidroid.xutils.view.annotation.ViewInject;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;


/**
 * @author ÍõÐñ
 *  Ö÷Ò³µÄfragment
 */
public class fragmentHome extends FragmentActivity  {

//	private TextView tv_haopingtuijian, tv_jingpin, tv_GuessYouLike;
//	private ImageView ImgBtn_more_haopingtuijian, ImgBtn_more_jingpin,
//			ImgBtn_more_GuessYouLike;
//	private RelativeLayout More_tuijian, More_jingpin, More_GuessYouLike;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home_index, null);
//		ViewUtils.inject(this,view);
		
		return view;
	}

//	@Override
//	public void onClick(View v) {
//		switch (v.getId()) {
//		case R.id.More_tuijian:
//
//			break;
//		case R.id.More_jingpin:
//
//			break;
//		case R.id.More_GuessYouLike:
//
//			break;
//		default:
//			break;
//		}
//	}
}
