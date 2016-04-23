package com.example.weike;



import android.app.TabActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;


/**
 * @author ����
 *   ÿһ�ڿγ��߼�����ҳ��
 */
public class every_course_activity extends TabActivity implements OnClickListener, OnErrorListener, OnCompletionListener {
	
	
		private VideoView sv_video;// ������Ƶ����
//		private TextView tv_title;
		private Button play,pause,stop,reset,all,share;//������
//		private String path ="weike\res\raw\rjgc_jiegoutu.mp4";
		private String path = "http://v.iask.com/v_play_ipad.php?vid=138152839";//��Ƶ��ַ
		private int currentPosition = 0;// ��¼��ͣ���ŵ�λ��
		private int backPosition = 0;// ����һ���طŵļ�¼λ��
		private MediaController mMediaController;//���ſ�����

		String[] mTitle = new String[] { "���", "Ŀ¼","����" };
		private TabHost tabHost;
		private LayoutInflater layoutInflater;
		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			//������Ļ���� �� flag����� 
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
			setContentView(R.layout.activity_every_course);

			sv_video = (VideoView) findViewById(R.id.sv_video);
//			tv_title = (TextView) findViewById(R.id.tv_title);
//			Intent i = getIntent();
//			path = i.getStringExtra("uri");
//			tv_title.setText(i.getStringExtra("title"));
			
			// Create media controller���  ���Կ�����Ƶ�Ĳ��ţ���ͣ���ظ���seek�Ȳ���������Ҫ��ʵ��
			mMediaController = new MediaController(this);
			sv_video.setMediaController(mMediaController);
			
			//����URI �� ָ������ 
			sv_video.setVideoURI(Uri.parse(path));
			sv_video.requestFocus();  
			play = (Button) findViewById(R.id.every_list_play);
			play.setOnClickListener(this);
			pause = (Button) findViewById(R.id.every_list_pasue);
			pause.setOnClickListener(this);
			stop = (Button) findViewById(R.id.every_list_stop);
			stop.setOnClickListener(this);
			reset = (Button) findViewById(R.id.every_list_reset);
			reset.setOnClickListener(this);
			all = (Button) findViewById(R.id.every_list_all);
			all.setOnClickListener(this);
			share = (Button) findViewById(R.id.every_list_share);
			share.setOnClickListener(this);
			
			initTabView();
		}
	
		private View getTabItemView(int i) {
			LayoutInflater inflater = LayoutInflater.from(getBaseContext());
			View view = inflater.inflate(R.layout.everyclass_tab_widget_item, null);
			TextView textView = (TextView) view.findViewById(R.id.textView1);
			textView.setText(mTitle[i]);
			return  view;
		}
		
		private void initTabView() {
			
			tabHost = getTabHost();
			layoutInflater = LayoutInflater.from(this);
			TabHost.TabSpec spec;
			Intent intent1 = new Intent(this, activity_course_details.class);
			spec = tabHost.newTabSpec(mTitle[0]).setIndicator(getTabItemView(0))
					.setContent(intent1);
			tabHost.addTab(spec);

			Intent intent2 = new Intent(this, activity_course_list.class);
			spec = tabHost.newTabSpec(mTitle[1]).setIndicator(getTabItemView(1))
					.setContent(intent2);
			tabHost.addTab(spec);
			
			Intent intent3 = new Intent(this, activity__course_evaluate.class);
			spec = tabHost.newTabSpec(mTitle[2]).setIndicator(getTabItemView(2))
					.setContent(intent3);
			tabHost.addTab(spec);
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.every_list_play:
				if (sv_video.isPlaying()) {
					pause.setClickable(false);
				} else {
					sv_video.start();
					if (currentPosition >= 0) {
						sv_video.seekTo(currentPosition);
						currentPosition = -1;
					}
				}
				break;
			case R.id.every_list_pasue:
				if (sv_video.canPause()) {
					sv_video.resume();
				} else {
					sv_video.pause();
				}
				break;
			case R.id.every_list_stop:
				currentPosition = sv_video.getCurrentPosition();
				sv_video.stopPlayback();
				break;
			case R.id.every_list_all:
				startActivity(new Intent(this, VideoPlayerActivity.class));
				break;
			case R.id.every_list_share:
//				Toast.makeText(getApplicationContext(), "��δʵ��", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(Intent.ACTION_SEND);  
			    intent.setType("text/plain");  
//			    intent.putExtra(Intent.EXTRA_SUBJECT, title);  
//			    intent.putExtra(Intent.EXTRA_TEXT, text);  
//			    startActivity(Intent.createChooser(intent, title)); 
			    startActivity(intent);
				break;
			default:
				break;
			}
		}

		@Override
		public void onCompletion(MediaPlayer mp) {
			finish();
		}

		@Override
		public boolean onError(MediaPlayer mp, int what, int extra) {
			Toast.makeText(getApplicationContext(), "��Ƶ���ų���", Toast.LENGTH_LONG).show();
			return false;
		}
}
