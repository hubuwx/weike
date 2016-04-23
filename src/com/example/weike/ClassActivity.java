package com.example.weike;

import com.example.weike.lisenter.OnFoldListener;
import com.example.weike.widget.FoldingLayout;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ClassActivity extends Activity {
    
    private String TAG_ARROW = "service_arrow";
    private String TAG_ITEM = "service_item";
    private TextView  txt_className =null;
    
    private View mBottomView;
    private LinearLayout mTestLayout,mTrafficLayout, mLifeLayout, mMedicalLayout, mLiveLayout, mPublicLayout;
    private RelativeLayout mTestBarLayout,mTrafficBarLayout, mLifeBarLayout, mMedicalBarLayout, mLiveBarLayout, mPublicBarLayout;
    private FoldingLayout mTestFoldingLayout,mTrafficFoldingLayout, mLifeFoldingLayout, mMedicalFoldingLayout, mLiveFoldingLayout, mPublicFoldingLayout;
    
    private final int FOLD_ANIMATION_DURATION = 1000;
    
    private int mNumberOfFolds = 3;

    private Button btn_more;
    
    private Button list01_btn01,list01_btn02,list01_btn03,list01_btn04;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.activity_class);
        
        findViews() ;
        
        initViews() ;
    }
    

    private void findViews() {
        
    	txt_className = (TextView) findViewById(R.id.class_name);
    	
    	mTestLayout = (LinearLayout) findViewById(R.id.test_layout);
        mTrafficLayout = (LinearLayout) findViewById(R.id.traffic_layout);
        mLifeLayout = (LinearLayout) findViewById(R.id.life_layout);
        mMedicalLayout = (LinearLayout) findViewById(R.id.medical_layout);
        mLiveLayout = (LinearLayout) findViewById(R.id.live_layout);
        mPublicLayout = (LinearLayout) findViewById(R.id.public_layout);
                
        mTestBarLayout = (RelativeLayout) findViewById(R.id.test_bar_layout);
        mTrafficBarLayout = (RelativeLayout) findViewById(R.id.traffic_bar_layout);
        mLifeBarLayout = (RelativeLayout) findViewById(R.id.life_bar_layout);
        mMedicalBarLayout = (RelativeLayout) findViewById(R.id.medical_bar_layout);
        mLiveBarLayout = (RelativeLayout) findViewById(R.id.live_bar_layout);
        mPublicBarLayout = (RelativeLayout) findViewById(R.id.public_bar_layout);
        
        mTestFoldingLayout = (FoldingLayout) mTestLayout.findViewWithTag(TAG_ITEM);
        mTrafficFoldingLayout = ((FoldingLayout) mTrafficLayout.findViewWithTag(TAG_ITEM));
        mLifeFoldingLayout = ((FoldingLayout) mLifeLayout.findViewWithTag(TAG_ITEM));
        mMedicalFoldingLayout = ((FoldingLayout) mMedicalLayout.findViewWithTag(TAG_ITEM));
        mLiveFoldingLayout = ((FoldingLayout) mLiveLayout.findViewWithTag(TAG_ITEM));
        mPublicFoldingLayout = ((FoldingLayout) mPublicLayout.findViewWithTag(TAG_ITEM));
        
        list01_btn01 =(Button) findViewById(R.id.list01_btn01);
        list01_btn02 =(Button) findViewById(R.id.list01_btn02);
        list01_btn03 =(Button) findViewById(R.id.list01_btn03);
        list01_btn04 =(Button) findViewById(R.id.list01_btn04);
        btn_more = (Button) findViewById(R.id.list01_more); 
        		
        mBottomView = findViewById(R.id.bottom_view);
        
        
        
    }

    private void initViews() {
        
    	mTestBarLayout.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                handleAnimation(v, mTestFoldingLayout, mTestLayout, mTrafficLayout);
            }
        });
        mTrafficBarLayout.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                handleAnimation(v, mTrafficFoldingLayout, mTrafficLayout, mLifeLayout);
            }
        });
        mLifeBarLayout.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                handleAnimation(v, mLifeFoldingLayout, mLifeLayout, mMedicalLayout);
            }
        });
        mMedicalBarLayout.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                handleAnimation(v, mMedicalFoldingLayout, mMedicalLayout, mLiveLayout);
            }
        });
        mLiveBarLayout.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                handleAnimation(v, mLiveFoldingLayout, mLiveLayout, mPublicLayout);
            }
        });
        mPublicBarLayout.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                handleAnimation(v, mPublicFoldingLayout, mPublicLayout, mBottomView);
            }
        });
        
        btn_more.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(), activity_course_list.class);
				i.putExtra("name", "大学（测试）");//
				startActivity(i);
			}
		});
        
        list01_btn01.setOnClickListener(new OnClickListener() {
        	//测试课程按钮
			@Override
			public void onClick(View v) {
					Toast.makeText(getApplicationContext(), "课程正在制作中！", Toast.LENGTH_SHORT).show();
			}
		});
        list01_btn02.setOnClickListener(new OnClickListener() {
        	//六级课程按钮
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "课程正在制作中！", Toast.LENGTH_SHORT).show();
			}
		});
        list01_btn03.setOnClickListener(new OnClickListener() {
        	//软件工程课程学习按钮
			@Override
			public void onClick(View v) {
					Intent i =new Intent(getApplicationContext(),VideoPlayerActivity.class);
//					i.putExtra("uri", "http://pan.baidu.com/play/video#video/path=%2Fweike%2Frjgc_jiegoutu.mp4&t=-1");
					
//					i.putExtra("title", "软件工程----结构图");
					startActivity(i);
			}
		});
        list01_btn04.setOnClickListener(new OnClickListener() {
        	//Java学习课程按钮
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "课程正在制作中！", Toast.LENGTH_SHORT).show();
			}
		});
        
        mTestFoldingLayout.setNumberOfFolds(mNumberOfFolds);
        mTrafficFoldingLayout.setNumberOfFolds(mNumberOfFolds);
        mLifeFoldingLayout.setNumberOfFolds(mNumberOfFolds);
        mMedicalFoldingLayout.setNumberOfFolds(mNumberOfFolds);
        mLiveFoldingLayout.setNumberOfFolds(mNumberOfFolds);
        mPublicFoldingLayout.setNumberOfFolds(mNumberOfFolds);
        
        animateFold(mTestFoldingLayout, 350);
        setMarginToTop(1, mTrafficLayout);
        
        animateFold(mTrafficFoldingLayout, 350);
        setMarginToTop(1, mLifeLayout);
        
        animateFold(mLifeFoldingLayout, 350);
        setMarginToTop(1, mMedicalLayout);
        
        animateFold(mMedicalFoldingLayout, 350);
        setMarginToTop(1, mLiveLayout);
        
        animateFold(mLiveFoldingLayout, 350);
        setMarginToTop(1, mPublicLayout);
        
        animateFold(mPublicFoldingLayout, 350);
        setMarginToTop(1, mBottomView);
        
//      mTrafficFoldingLayout.setFoldFactor(1.0f);
//        mLifeFoldingLayout.setFoldFactor(1.0f);
//        mMedicalFoldingLayout.setFoldFactor(1.0f);
//        mLiveFoldingLayout.setFoldFactor(1.0f);
//        mPublicFoldingLayout.setFoldFactor(1.0f);
    }
    
    private void handleAnimation(final View bar, final FoldingLayout foldingLayout, View parent, final View nextParent) {
        
        final ImageView arrow = (ImageView) parent.findViewWithTag(TAG_ARROW);
        
        foldingLayout.setFoldListener(new OnFoldListener() {
            
            @Override
            public void onStartFold(float foldFactor) {
                
                bar.setClickable(true);
                arrow.setBackgroundResource(R.drawable.service_arrow_up);
                resetMarginToTop(foldingLayout, foldFactor, nextParent);
            }
            
            @Override
            public void onFoldingState(float foldFactor, float foldDrawHeight) {
                bar.setClickable(false);
                resetMarginToTop(foldingLayout, foldFactor, nextParent);
            }
            
            @Override
            public void onEndFold(float foldFactor) {
                
                bar.setClickable(true);
                arrow.setBackgroundResource(R.drawable.service_arrow_down);
                resetMarginToTop(foldingLayout, foldFactor, nextParent);
            }
        });
        
//      foldingLayout.setNumberOfFolds(mNumberOfFolds);
        animateFold(foldingLayout, FOLD_ANIMATION_DURATION);
        
    }
    
    private void resetMarginToTop(View view, float foldFactor, View nextParent) {
        
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) nextParent.getLayoutParams();
        lp.topMargin =(int)( - view.getMeasuredHeight() * foldFactor) + dp2px(ClassActivity.this, 10);
        nextParent.setLayoutParams(lp);
    }
    
    private void setMarginToTop(float foldFactor, View nextParent) {
        
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) nextParent.getLayoutParams();
        lp.topMargin =(int)( - dp2px(ClassActivity.this, 135) * foldFactor) + dp2px(ClassActivity.this, 10);
        nextParent.setLayoutParams(lp);
    }
    
    @SuppressLint("NewApi") 
    public void animateFold(FoldingLayout foldLayout, int duration) {
        float foldFactor = foldLayout.getFoldFactor();

        ObjectAnimator animator = ObjectAnimator.ofFloat(foldLayout,
                "foldFactor", foldFactor, foldFactor > 0 ? 0 : 1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(0);
        animator.setDuration(duration);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }
    
    public final static int dp2px(Context context, float dpValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5f);
    }
}
