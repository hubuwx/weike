package com.example.weike;

import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import com.example.weike.HomeActivity;
import com.example.weike.widget.GalleryView;
import com.example.weike.widget.MainPageGallarySelect;
import com.example.weike.widget.MainTitlebar;
import com.example.weike.adapter.GalleryImageAdapter;
import com.example.weike.entity.Media;
import com.example.weike.entity.MediaItem;
import com.example.weike.entity.Recommend;
import com.example.weike.http.IBindData;
import com.example.weike.http.NetWorkTask;
import com.example.weike.Utils.ActivityHolder;
import com.example.weike.Utils.Contents;
import com.example.weike.Utils.UIUtils;
import com.example.weike.Utils.Utils;
import com.example.weike.ui.BaseActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class HomeActivity extends BaseActivity implements IBindData{
	
	ArrayList<Recommend> arrayListComicHot = null;
	ArrayList<Recommend> arrayListIndexFlash = null;
	ArrayList<Recommend> arrayListMovieHot = null;

	private ArrayList<HashMap<String, ArrayList<Recommend>>>  arrRecommend;
	// private RelativeLayout view;
	private TextView recommendMore_HP;
	private GridView gridview_HP_course;
	private TextView recommendMore_JP;
	private GridView gridview_JP_course;
	private TextView recommendMore_TJ;
	private GridView gridview_TJ_course;
	
	private RadioGroup mRadioGroupGallery;
	private GalleryView mGalleryView;
	private GalleryImageAdapter mGalleryImageAdapter;
	private int pagesize = 6;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  
			this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
			setContentView(R.layout.activity_home);
			ActivityHolder.getInstance().addActivity(this);
			if (UIUtils.hasNetwork(HomeActivity.this)) {
				startLoadingDialog(HomeActivity.this);
				String url = Contents.BaiDuUrlRecommend + "?version="
						+ Contents.version;// arrayItem.get(0).getBase_url();
				System.out.println("url===" + url);
				new NetWorkTask().execute(HomeActivity.this,
						UIUtils.Recommend, url, mainHandler);
			} else {
				UIUtils.showToast(HomeActivity.this,
						HomeActivity.this.getText(R.string.tip_network).toString());

			}
			initViews();
			
			
		}
		
		@Override
		protected void onStart() {
			// TODO Auto-generated method stub
			super.onStart();
		}

		private void initViews() {
			((MainTitlebar) findViewById(R.id.main_title)).show("首页");

			mGalleryView = (GalleryView) findViewById(R.id.newImageGallery);
			mRadioGroupGallery = (RadioGroup) findViewById(R.id.mainRadioGallery);

			recommendMore_HP = (TextView) findViewById(R.id.recommendMore_HP);
			gridview_HP_course = (GridView) findViewById(R.id.gridview_HP_course);
			recommendMore_JP = (TextView) findViewById(R.id.recommendMore_JP);
			gridview_JP_course = (GridView) findViewById(R.id.gridview_JP_course);
			recommendMore_TJ = (TextView) findViewById(R.id.recommendMore_TJ);
			gridview_TJ_course = (GridView) findViewById(R.id.gridview_TJ_course);
			
			mGalleryView.setOnItemClickListener(new GallaryClick());
			mGalleryView.setOnItemSelectedListener(new MainPageGallarySelect(
					pagesize, mRadioGroupGallery));
			recommendMore_HP.setOnClickListener(myOnClick);
			recommendMore_JP.setOnClickListener(myOnClick);
			recommendMore_TJ.setOnClickListener(myOnClick);
			
			Timer timer = new Timer();
			timer.schedule(task, 3000, 3000);
		}

		OnClickListener myOnClick = new OnClickListener() {

			public void onClick(View v) {
				Intent i = null;
				switch (v.getId()) {
				case R.id.recommendMore_HP:
//					i = new Intent(MainActivity.this, ChannelListActivity.class);
//					BaiDuChannelVideo infoMovie = new BaiDuChannelVideo();
//					infoMovie
//							.setBase_url("http://app.video.baidu.com/adnativemovie/");
//					infoMovie.setExtra("");
//					infoMovie
//							.setFilter("http://app.video.baidu.com/conds/?worktype=adnativemovie");
//					infoMovie.setMask(3);
//					infoMovie.setName("好评微课");
//					infoMovie.setTag("movie");
//					infoMovie.setType("channel_video");
//					i.putExtra("channelVideoInfo", infoMovie);

					break;
				case R.id.recommendMore_JP:
//					i = new Intent(MainActivity.this, ChannelListActivity.class);
//					BaiDuChannelVideo infoTv = new BaiDuChannelVideo();
//					infoTv.setBase_url("http://app.video.baidu.com/adnativetvplay/");
//					infoTv.setExtra("");
//					infoTv.setFilter("http://app.video.baidu.com/conds/?worktype=adnativetvplay");
//					infoTv.setMask(3);
//					infoTv.setName("精品微课");
//					infoTv.setTag("tvplay");
//					infoTv.setType("channel_video");
//					i.putExtra("channelVideoInfo", infoTv);
					break;
				case R.id.recommendMore_TJ:
//					i = new Intent(MainActivity.this, ChannelListActivity.class);
//					BaiDuChannelVideo infoZy = new BaiDuChannelVideo();
//					infoZy.setBase_url("http://app.video.baidu.com/adnativetvshow/");
//					infoZy.setExtra("");
//					infoZy.setFilter("http://app.video.baidu.com/conds/?worktype=adnativetvshow");
//					infoZy.setMask(3);
//					infoZy.setName("推荐微课");
//					infoZy.setTag("tvshow");
//					infoZy.setType("channel_video");
//					i.putExtra("channelVideoInfo", infoZy);
					break;

				default:
					break;

				}
				HomeActivity.this.startActivity(i);
				overridePendingTransition(R.anim.fade, R.anim.hold);
			}
		};

		@Override
		protected void onDestroy() {
			// TODO Auto-generated method stub
			super.onDestroy();
			ActivityHolder.getInstance().removeActivity(this);
		}
		
		int isExit = 0;

		public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {

			if ((paramKeyEvent.getAction() == 0) && (paramInt == 4)) {

				if (isExit == 0) {
					isExit++;
					UIUtils.showToast(this, "再点一次可退出");
					return true;
				}
				if (isExit == 1) {
					// 以下方法将用于释放SDK占用的系统资源
					this.finish();
				}
			}
			return super.onKeyDown(paramInt, paramKeyEvent);

		}
		
		@Override
		protected void onResume() {
			super.onResume();
		}
		
		@Override
		protected void onPause() {
			super.onPause();
		}
		
		@Override
		protected void onRestart() {
			super.onRestart();
			// Toast.makeText(MainActivity.this, "重启了", 1).show();
			if (arrRecommend == null || arrRecommend.size() == 0) {
				if (UIUtils.hasNetwork(HomeActivity.this)) {
					Utils.startWaitingDialog(HomeActivity.this);
					String url = Contents.BaiDuUrlRecommend + "?version="
							+ Contents.version;  //  arrayItem.get(0).getBase_url();
					new NetWorkTask().execute(HomeActivity.this,
							UIUtils.Recommend, url, mainHandler);
				} else {
					UIUtils.showToast(HomeActivity.this,
							HomeActivity.this.getText(R.string.tip_network)
									.toString());
				}
			}
		}
		
		private class GallaryClick implements AdapterView.OnItemClickListener {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {

				try {
					int myPostion = 0;
					if (position >= arrayListIndexFlash.size()) {
						myPostion = position % (arrayListIndexFlash.size());
					} else {
						myPostion = position;
					}

					if (arrayListIndexFlash != null
							&& arrayListIndexFlash.size() > myPostion) {
						if (UIUtils.hasNetwork(HomeActivity.this)) {
							Recommend video = arrayListIndexFlash
									.get(myPostion);
							String workType = video.getWorks_type();
							if (workType.equals("browser")) {
								Utils.playView(setMedia(video), HomeActivity.this);
							} else {
								if (video.getWorks_id().equals("")
										&& video.getUrl().contains(".html")) {
									String tag = video.getTag();
//									Intent i = new Intent(MainActivity.this,
//											VideoListActivity.class);
//									BaiDuChannelVideo infoFunny = new BaiDuChannelVideo();
									String url = "http://m.baidu.com/video?static=utf8_data/android_channel/json/"
											+ tag + "/";
//									infoFunny.setBase_url(url.replaceAll(" ", ""));
//									// infoFunny.setHotUrl("http://m.baidu.com/video?static=utf8_data/android_channel/json/amuse/");//hot/1.js
//									infoFunny.setExtra("");
//									infoFunny.setFilter("");
//									infoFunny.setMask(2);
//									infoFunny.setName(video.getTitle());
//									infoFunny.setTag(video.getTag());
//									infoFunny.setType(workType);
//									i.putExtra("channelVideoInfo", infoFunny);
//									MainActivity.this.startActivity(i);
									overridePendingTransition(R.anim.fade,
											R.anim.hold);

								} else {
									if (workType.equals("tvshow")) {
//										Intent intent = new Intent();
//										intent.putExtra("BaiDuRecommend", video);
//										intent.setClass(MainActivity.this,
//												MediaShowActivity.class);
//										MainActivity.this.startActivity(intent);
									} else if (workType.equals("info")
											|| workType.equals("amuse")
											|| workType.equals("music")
											|| workType.equals("sport")
											|| workType.equals("woman")
											|| workType.equals("player")
											|| workType.equals("browser")) {

										Utils.playView(setMedia(video),
												HomeActivity.this);

									} else {
//										Intent intent = new Intent();
//										intent.putExtra("BaiDuRecommend", video);
//										intent.setClass(MainActivity.this,
//												MediaActivity.class);
//										MainActivity.this.startActivity(intent);
									}

								}
							}

						} else {
							UIUtils.showToast(HomeActivity.this, HomeActivity.this
									.getText(R.string.tip_network).toString());
						}

					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		};
		
		@Override
		public void bindData(int tag, Object object) {
			if (tag == UIUtils.Recommend && object != null) {
				arrRecommend = (ArrayList<HashMap<String, ArrayList<Recommend>>>) object;
				if (arrRecommend != null) {

					for (int i = 0; i < arrRecommend.size(); i++) {
						HashMap<String, ArrayList<Recommend>> map = arrRecommend
								.get(i);
						if (map.containsKey("index_flash")) {
							arrayListIndexFlash = map.get("index_flash");
							continue;
						}
						if (map.containsKey("movie_hot")) {
							arrayListMovieHot = map.get("movie_hot");
							continue;
						}
					}
		}
}
		}
		
		/**
		 * 定时器，实现自动播放
		 */
		private int index = 0;
		private TimerTask task = new TimerTask() {
			@Override
			public void run() {
				Message message = new Message();
				message.what = 2;
				index = mGalleryView.getSelectedItemPosition();
				index++;
				handler.sendMessage(message);
			}
		};
		private Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				switch (msg.what) {
				case 1:
					// if(UIUtils.hasNetwork(context)){
					// MovieDataAsyncTask movieTask = new MovieDataAsyncTask();
					// movieTask.execute();
					// }else{
					// UIUtils.showToast(context,
					// context.getText(R.string.tip_network).toString());
					// }

					break;
				case 2:
					mGalleryView.setSelection(index);
					break;
				case UIUtils.SHOW_PLAY:
				    Recommend Recommends = (Recommend) msg.obj;
					if (Recommends != null) {
						Utils.playView(setMedia(Recommends), HomeActivity.this);
					}
					break;
				default:
					break;
				}
			}
		};

		private Dialog dialog = null;

		public void startLoadingDialog(Context context) {
		try {
				// synchronized(Utils.synchronizeds) {
				if (dialog == null) {
				dialog = new Dialog(context, R.style.waitingLoading);
					dialog.setContentView(R.layout.loading_pre);
					// dialog.set
					// RelativeLayout re =
					// (RelativeLayout)findViewById(R.id.layout_loading);
					dialog.show();
				} else if (dialog != null && !dialog.isShowing()) {
				dialog.setContentView(R.layout.loading_pre);
					dialog.setCanceledOnTouchOutside(false);
					dialog.show();
				}
				//
			// }
				// }
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void closeLoadingDialog() {
			try {
				// synchronized(Utils.synchronizeds) {
				if (dialog != null) {
					dialog.dismiss();
			}
			// }
			} catch (Exception e) {
				// TODO: handle exception
		}

	}
		
		
		private Media setMedia(Recommend video) {
			Media mMedia = new Media();
			ArrayList<MediaItem> mMediaItemArrayList = new ArrayList<MediaItem>();
			MediaItem mMediaItem = new MediaItem();
			mMediaItem.setLive(false);
			mMediaItem.setTitle(video.getTitle());
			mMediaItem.setSourceUrl(video.getUrl());
			mMediaItem.setImage(video.getImg_url());
			mMediaItemArrayList.add(mMediaItem);
			mMedia.setMediaItemArrayList(mMediaItemArrayList);
			mMedia.setPosition(0);
			mMedia.setMediaType(video.getWorks_type());
			return mMedia;
		}
}
