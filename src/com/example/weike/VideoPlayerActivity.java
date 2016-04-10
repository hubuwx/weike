package com.example.weike;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class VideoPlayerActivity extends Activity implements OnClickListener {

	// ��Ƶ���ŵ�ַ
//	 private String videoUrl =
//	 "http://v.iask.com/v_play_ipad.php?vid=138152839";
	private String videoUrl = "http://v.iask.com/v_play_ipad.php?vid=138152839";
	/*************************************************/
	private SurfaceView video_sv;// ��ͼ�����������ڰ���Ƶ��ʾ����Ļ��
	private ProgressBar video_pb;
	private LinearLayout video_ll_title;
	private Button video_btn_back;
	private TextView video_tv_name;// ��Ƶ������ʾ��view
	private LinearLayout video_ll_bottom;
	private Button video_btn_play;// ���ڿ�ʼ����ͣ�İ�ť
	private TextView video_tv_otime;
	private SeekBar video_seekbar_time;// �������ؼ�
	private TextView video_tv_ctime;
	private Button video_btn_full;
	private Button video_btn_lock;

	private MediaPlayer mediaPlayer; // �������ؼ�
	private upDateSeekBar playingSeekBar; // ���½�������
	private int postSize; // �����岥��Ƶ��С
	private boolean flag = true; // �����ж���Ƶ�Ƿ��ڲ�����

	private static long lastClickTime;
	private int position = 0;

	private boolean isLocked = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		/* ȥ��title */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		/* ������Ļ���� *//* flag����� �� */
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.activity_video); // ���ز����ļ�
		initView(); // ��ʼ������

		playVideo();
		setListener(); // ������¼�

	}
	
	@SuppressWarnings("deprecation")
	private void playVideo() {
		video_pb.setVisibility(View.VISIBLE);
		video_tv_name.setText("��������xxx");// ��Ƶ����
		video_btn_play.setEnabled(false); // �ս����������䲻�ɵ��
		video_sv.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		video_sv.getHolder().setKeepScreenOn(true); // ������Ļ����
		video_sv.getHolder().addCallback(new surFaceView()); // ���ü����¼�
		mHandler.sendMessageDelayed(mHandler.obtainMessage(0x124), 3000);// ���ؿؼ�
	}

	private void initView() {
		video_sv = (SurfaceView) findViewById(R.id.video_sv);
		video_pb = (ProgressBar) findViewById(R.id.video_pb);

		video_ll_title = (LinearLayout) findViewById(R.id.video_ll_title);
		video_btn_back = (Button) findViewById(R.id.video_btn_back);
		video_btn_back.setOnClickListener(this);
		video_tv_name = (TextView) findViewById(R.id.video_tv_name);

		video_ll_bottom = (LinearLayout) findViewById(R.id.video_ll_bottom);
		video_btn_play = (Button) findViewById(R.id.video_btn_play);
		video_btn_play.setOnClickListener(this);
		video_tv_otime = (TextView) findViewById(R.id.video_tv_otime);
		video_seekbar_time = (SeekBar) findViewById(R.id.video_seekbar_time);
		video_tv_ctime = (TextView) findViewById(R.id.video_tv_ctime);
		video_btn_full = (Button) findViewById(R.id.video_btn_full);
		video_btn_full.setOnClickListener(this);

		video_btn_lock = (Button) findViewById(R.id.video_btn_lock);
		video_btn_lock.setOnClickListener(this);

		mediaPlayer = new MediaPlayer(); // ����һ������������
		playingSeekBar = new upDateSeekBar(); // �������½���������
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.video_btn_back:// ����С������ҳ��
			startActivity(new Intent(getApplication(),every_learn_activity.class));
			finish();
			break;
		case R.id.video_btn_lock:
			if (isLocked) {
				unLockScreen();// ����
				isLocked = false;
			} else {
				lockScreen();// ����
				isLocked = true;
			}
			break;
		default:
			break;
		}

	}

	private void lockScreen() {
		video_btn_lock
				.setBackgroundResource(R.drawable.player_landscape_screen_off_normal);
		video_ll_title.setVisibility(View.GONE);
		video_ll_bottom.setVisibility(View.GONE);
	}

	private void unLockScreen() {
		video_btn_lock
				.setBackgroundResource(R.drawable.player_landscape_screen_on_noraml);
		video_ll_title.setVisibility(View.VISIBLE);
		video_ll_bottom.setVisibility(View.VISIBLE);
	}

	/**
	 * ���½�����
	 */
	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.what == 0x124) {
				video_ll_title.setVisibility(View.GONE);
				video_ll_bottom.setVisibility(View.GONE);
			} else {
				if (mediaPlayer == null) {
					flag = false;
				} else if (mediaPlayer.isPlaying()) {
					flag = true;
					int position = mediaPlayer.getCurrentPosition();
					int mMax = mediaPlayer.getDuration();
					int sMax = video_seekbar_time.getMax();
					if (mMax > 0) {
						video_tv_otime.setText(change(position / 1000));
						video_tv_ctime.setText(change(mMax / 1000));
						video_seekbar_time.setProgress(position * sMax / mMax);
					} else {
						Toast.makeText(VideoPlayerActivity.this, "�޷�����",
								Toast.LENGTH_LONG).show();
					}
				}
			}
		};
	};

	class upDateSeekBar implements Runnable {

		@Override
		public void run() {
			mHandler.sendMessage(Message.obtain());
			if (flag) {
				mHandler.postDelayed(playingSeekBar, 1000);
			}
		}
	}

	class PlayMovie extends Thread { // ������Ƶ���߳�
		int post = 0;

		public PlayMovie(int post) {
			this.post = post;
		}

		@Override
		public void run() {
			super.run();
			try {
				mediaPlayer.reset(); // �ظ�������Ĭ��
				mediaPlayer.setDataSource(videoUrl); // ���ò���·��
				mediaPlayer.setDisplay(video_sv.getHolder()); // ����Ƶ��ʾ��SurfaceView��
				mediaPlayer.setOnPreparedListener(new PreparedListener(post)); // ���ü����¼�
				mediaPlayer.prepare(); // ׼������
					mediaPlayer.seekTo(50000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class PreparedListener implements OnPreparedListener {
		int postSize;

		public PreparedListener(int postSize) {
			this.postSize = postSize;
		}

		@Override
		public void onPrepared(MediaPlayer mp) {
			Log.e("onPrepared", "----onPrepared");
			video_pb.setVisibility(View.GONE); // ׼����ɺ����ؿؼ�
			video_btn_play
					.setBackgroundResource(R.drawable.qiyi_sdk_play_btn_pause);
			if (mediaPlayer != null) {
				mediaPlayer.start(); // ��ʼ������Ƶ
			} else {
				return;
			}
			if (postSize > 0) { // ˵����;ֹͣ����activity���ù�pase�����������û����ֹͣ��ť��������ֹͣʱ��λ�ÿ�ʼ����
				mediaPlayer.seekTo(postSize); // ����postSize��Сλ�ô����в���
			}
			new Thread(playingSeekBar).start(); // �����̣߳����½�����
		}
	}

	private class surFaceView implements Callback { // ����󶨵ļ������¼�

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			mediaPlayer.setDisplay(holder);
		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) { // ������ɺ����
			if (postSize > 0 && videoUrl != null) { // ˵����ֹͣ��activity���ù�pase����������ֹͣλ�ò���
				new PlayMovie(postSize).start();
				flag = true;
				int sMax = video_seekbar_time.getMax();
				int mMax = mediaPlayer.getDuration();

				video_tv_otime
						.setText(change(mediaPlayer.getCurrentPosition() / 1000));
				video_tv_ctime
						.setText(change(mediaPlayer.getDuration() / 1000));

				video_seekbar_time.setProgress(postSize * sMax / mMax);
				postSize = 0;
				video_pb.setVisibility(View.GONE);
			} else {
				new PlayMovie(0).start();// �����ǵ�һ�ο�ʼ����
			}
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) { // activity���ù�pase���������浱ǰ����λ��
			if (mediaPlayer != null && mediaPlayer.isPlaying()) {
				postSize = mediaPlayer.getCurrentPosition();
				mediaPlayer.stop();
				flag = false;
				video_pb.setVisibility(View.VISIBLE);
			}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		video_btn_play.setEnabled(true);
		video_btn_play
				.setBackgroundResource(R.drawable.qiyi_sdk_play_btn_pause);
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (mediaPlayer != null) {
			if (mediaPlayer.isPlaying()) {
				position = mediaPlayer.getCurrentPosition();
				mediaPlayer.stop();
				SharedPreferences share = getSharedPreferences("video_player",
						0);
				Editor editor = share.edit();
				editor.putInt("position", position);
				editor.commit();
			}
		}
	}

	@Override
	protected void onDestroy() { // activity���ٺ��ͷ���Դ
		super.onDestroy();
		if (mediaPlayer != null) {
			if (mediaPlayer.isPlaying()) {
				mediaPlayer.stop();
			}
			mediaPlayer.release();
			mediaPlayer = null;
		}
		System.gc();
	}

	private void setListener() {
		if (mediaPlayer == null) {
			return;
		}
		mediaPlayer
				.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
					@Override
					public void onBufferingUpdate(MediaPlayer mp, int percent) {
						video_seekbar_time.setSecondaryProgress(percent);
					}
				});

		mediaPlayer
				.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // ��Ƶ�������
					@Override
					public void onCompletion(MediaPlayer mp) {
						flag = false;
						video_tv_otime.setText(change(mediaPlayer.getDuration() / 1000));
						video_btn_play
								.setBackgroundResource(R.drawable.qiyi_sdk_play_btn_player);
						// ������ɺ���Ҫ�Զ�������һ��
						Log.e("mediaPlayer", "��������");
					}
				});

		mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mp) {

			}
		});
		mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {

			@Override
			public boolean onError(MediaPlayer arg0, int arg1, int arg2) {
				Log.e("mediaPlayer", "�޷����ţ�" + arg1 + "��" + arg2);
				return false;
			}
		});
		/**
		 * �����Ƶ�ڲ��ţ������mediaPlayer.pause();��ֹͣ������Ƶ����֮��mediaPlayer.start()
		 * ��ͬʱ����ť����
		 */
		video_btn_play.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mediaPlayer.isPlaying()) {
					video_btn_play
							.setBackgroundResource(R.drawable.qiyi_sdk_play_btn_player);
					mediaPlayer.pause();
					postSize = mediaPlayer.getCurrentPosition();
				} else {
					video_btn_play
							.setBackgroundResource(R.drawable.qiyi_sdk_play_btn_pause);
					mediaPlayer.start();
					if (flag == false) {
						flag = true;
						new Thread(playingSeekBar).start();
					}
				}
			}
		});
		video_seekbar_time
				.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {

						if (isFastDoubleClick()) {
							int value = video_seekbar_time.getProgress()
									* mediaPlayer.getDuration() // �����������Ҫǰ����λ�����ݴ�С
									/ video_seekbar_time.getMax();
							video_tv_otime.setText(change(value / 1000));
							mediaPlayer.seekTo(value);
						}
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {

					}

					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {

					}
				});
		/**
		 * �����Ļ���л��ؼ�����ʾ����ʾ��Ӧ�أ����أ�����ʾ
		 */
		video_sv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// ֻ��ȫ��ʱ����ʾ������ť
//				 if (!isFullScreen) {
//				 return;
//				 }
				if (isLocked) {
					video_ll_title.setVisibility(View.GONE);
					video_ll_bottom.setVisibility(View.GONE);
				} else {
					video_ll_title.setVisibility(View.VISIBLE);
					video_ll_bottom.setVisibility(View.VISIBLE);
					mHandler.sendMessageDelayed(mHandler.obtainMessage(0x124),
							3000);// ���ؿؼ�
				}
			}
		});

	}

	// ��ֹ�û�Ƶ������
	public static boolean isFastDoubleClick() {
		long time = System.currentTimeMillis();
		long timeD = time - lastClickTime;
		if (3000 < timeD) {
			return true;
		}
		lastClickTime = time;
		return false;
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// ���������״̬������ʹ��ϵͳ���˼�
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if (isLocked) {
				return true;
			}
		}
		return super.dispatchKeyEvent(event);
	}

	public static String change(int second) {
		int h = 0;
		int d = 0;
		int s = 0;
		int temp = second % 3600;
		if (second > 3600) {
			h = second / 3600;
			if (temp != 0) {
				if (temp > 60) {
					d = temp / 60;
					if (temp % 60 != 0) {
						s = temp % 60;
					}
				} else {
					s = temp;
				}
			}
		} else {
			d = second / 60;
			if (second % 60 != 0) {
				s = second % 60;
			}
		}

		return h + ":" + d + ":" + s;
	}

}
