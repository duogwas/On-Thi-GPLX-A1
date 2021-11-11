package fithou.duogwas.onthigplxa1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import fithou.duogwas.onthigplxa1.Class.DBHelper;
import fithou.duogwas.onthigplxa1.R;

public class DangNhap extends AppCompatActivity implements View.OnClickListener {
    AppCompatButton btn_dangnhaphw, btn_dangnhap, btn_dangkyngay;
    TextInputEditText username_log, pass_log;
    DBHelper MyDB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dang_nhap);
        AnhXa();
        setOnClick();
    }

    private void AnhXa() {
        btn_dangnhap = findViewById(R.id.btn_dangnhap);
        btn_dangkyngay = findViewById(R.id.btn_dangkyngay);
        btn_dangnhaphw = findViewById(R.id.btn_dangnhaphw);
        username_log = findViewById(R.id.username_log);
        pass_log = findViewById(R.id.pass_log);
        MyDB = new DBHelper(this);
    }

    private void setOnClick() {
        btn_dangnhap.setOnClickListener(this);
        btn_dangkyngay.setOnClickListener(this);
        btn_dangnhaphw.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_dangkyngay:
                intent = new Intent(DangNhap.this,DangKy.class);
                startActivity(intent);
                break;

            case R.id.btn_dangnhap:
                String user = username_log.getText().toString();
                String pass = pass_log.getText().toString();
                if (user.equals("") || pass.equals(""))
                {
                    Toast.makeText(DangNhap.this, "Vui lòng điền tất cả thông tin", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Boolean checkuserpassword = MyDB.checkuserpassword(user, pass);
                    if (checkuserpassword == true)
                    {
                        intent = new Intent(DangNhap.this,MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(DangNhap.this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(DangNhap.this, "Tên tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_LONG).show();
                    }
                }
                break;

            default:
                break;
        }
    }
}