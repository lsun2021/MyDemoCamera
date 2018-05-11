package com.example.mydemotest3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.picasso.Picasso;

import cn.jzvd.JZVideoPlayerStandard;

public class MainActivity extends AppCompatActivity {
    private JZVideoPlayerStandard jzVideoPlayerStandard ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jzVideoPlayerStandard  = (JZVideoPlayerStandard) findViewById(R.id.videoplayer);
        //JC 视频播放的URl 地址 的方法是用到了setUP( URL , )
        jzVideoPlayerStandard.setUp("http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4"
                , JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,"请闭眼");
        //picass 图片加载框架
        Picasso.with(this)
                .load("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640")
                .into(jzVideoPlayerStandard.thumbImageView);


    }

    /**
     * backPress函数判断了点击回退按钮的相应，
     * 如果全屏会退出全屏播放，如果不是全屏则会交给Activity
     */
    @Override
    public void onBackPressed() {
        if(JZVideoPlayerStandard.backPress()){
            return;
        }
        super.onBackPressed();
    }

    /**
     * 暂停 /失去焦点
     * Activity或者按Home键之后会视频就会releas(释放)
     */
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayerStandard.releaseAllVideos();
    }
}