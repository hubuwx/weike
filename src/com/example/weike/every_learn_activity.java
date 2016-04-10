package com.example.weike;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


/**
 * @author ����
 *   ÿһ�ڿγ��߼�����ҳ��
 */
public class every_learn_activity extends Activity implements OnClickListener, OnErrorListener, OnCompletionListener {
	
	// ������Ƶ����
		private VideoView sv_video;

		private String path = "http://v.iask.com/v_play_ipad.php?vid=138152839";

		// ��¼��ͣ���ŵ�λ��
		private int currentPosition = 0;

		// ����һ���طŵļ�¼λ��
		private int backPosition = 0;
		private MediaController mMediaController;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			/* ȥ��title */
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			/* ������Ļ���� *//* flag����� �� */
			getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
			setContentView(R.layout.activity_every_learn);

			sv_video = (VideoView) findViewById(R.id.sv_video);

			// Create media controller��������Կ�����Ƶ�Ĳ��ţ���ͣ���ظ���seek�Ȳ���������Ҫ��ʵ��
			mMediaController = new MediaController(this);
			sv_video.setMediaController(mMediaController);
			
			/* ����URI �� ָ������ */
			sv_video.setVideoURI(Uri.parse(path));
//			sv_video.requestFocus();  
			Button button1 = (Button) findViewById(R.id.every_list_play);
			button1.setOnClickListener(this);
			Button button2 = (Button) findViewById(R.id.every_list_pasue);
			button2.setOnClickListener(this);
			Button button3 = (Button) findViewById(R.id.every_list_stop);
			button3.setOnClickListener(this);
			Button button4 = (Button) findViewById(R.id.every_list_reset);
			button4.setOnClickListener(this);
			Button button11 = (Button) findViewById(R.id.every_list_all);
			button11.setOnClickListener(this);
			
			Button button12 = (Button) findViewById(R.id.every_list_share);
			button12.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.every_list_play:
				if (sv_video.isPlaying()) {

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
