package fithou.duogwas.onthigplxa1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import fithou.duogwas.onthigplxa1.R;

public class HoTro extends AppCompatActivity {
    ImageButton img_BtnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ho_tro);
        img_BtnHome = findViewById(R.id.img_btnHome);
        img_BtnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HoTro.this, MainActivity.class));
            }
        });
    }
}
