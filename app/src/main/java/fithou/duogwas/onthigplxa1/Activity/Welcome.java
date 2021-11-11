package fithou.duogwas.onthigplxa1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import fithou.duogwas.onthigplxa1.R;

public class Welcome extends AppCompatActivity {
    private static int Welcome_screen = 5000;
    Animation top_ani, bottom_ani;
    ImageView img_welcome;
    TextView tv_name, tv_copyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        AnhXa();
        ConnectAni();
        NextScreen();
    }

    private void AnhXa() {
        img_welcome = findViewById(R.id.img_welcome);
        tv_name = findViewById(R.id.tv_name);
        tv_copyright = findViewById(R.id.tv_copyright);
        top_ani = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottom_ani = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
    }

    private void ConnectAni() {
        img_welcome.setAnimation(top_ani);
        tv_name.setAnimation(bottom_ani);
        tv_copyright.setAnimation(bottom_ani);

    }

    private void NextScreen() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this,DangNhap.class);
                startActivity(intent);
                finish();
            }
        },Welcome_screen);
    }
}