package fithou.duogwas.onthigplxa1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import fithou.duogwas.onthigplxa1.Adapter.ListBienBaoAdapter;
import fithou.duogwas.onthigplxa1.Class.BienBao;
import fithou.duogwas.onthigplxa1.R;

public class HocBienBao extends AppCompatActivity implements View.OnClickListener {
    ListView lv_hocbienbao;
    ImageButton img_btnHome, img_btnChange;
    ArrayList<BienBao> bienbao;
    TextView tv_loaiBien;
    int begin, end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoc_bien_bao);
        AnhXa();
        setOnClick();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new docJson().execute("https://duogwas.github.io/listbienbao.json");
            }
        });

        String loaiBien = getIntent().getStringExtra("loaiBienSelect");
        tv_loaiBien.setText(loaiBien);
        begin = getIntent().getIntExtra("begin",0);
        end = getIntent().getIntExtra("end",71);

    }

    private void AnhXa() {
        bienbao = new ArrayList<BienBao>();
        lv_hocbienbao = findViewById(R.id.lv_bienbao);
        img_btnHome = findViewById(R.id.img_btnHome);
        img_btnChange = findViewById(R.id.img_btnChange);
        tv_loaiBien = findViewById(R.id.tv_loaiBien);
    }

    private void setOnClick() {
        img_btnHome.setOnClickListener(this);
        img_btnChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.img_btnHome:
                intent = new Intent(HocBienBao.this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.img_btnChange:
                OpenDialog(Gravity.CENTER);
                break;

            default:
                break;
        }
    }

    class docJson extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return docnoidungtuUrl(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = begin; i < end +1 ; i++) {
                    JSONObject bien = jsonArray.getJSONObject(i);
                    bienbao.add(new BienBao(
                            bien.getString("Hinh"),
                            bien.getString("TenBien"),
                            bien.getString("MoTa")
                    ));
                }
                ListBienBaoAdapter listBienBaoAdapter = new ListBienBaoAdapter(getApplicationContext(), R.layout.custom_lv_bienbao, bienbao);
                lv_hocbienbao.setAdapter(listBienBaoAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private static String docnoidungtuUrl(String TheUrl) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(TheUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private void OpenDialog(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog_chonbienbao);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttribute = window.getAttributes();
        windowAttribute.gravity = gravity;
        window.setAttributes(windowAttribute);

        if (Gravity.CENTER == gravity) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }

        AppCompatButton btn_biencam, btn_nguyhiem, btn_chidan, btn_hieulenh, btn_phu;

        btn_biencam = dialog.findViewById(R.id.btn_cam);
        btn_nguyhiem = dialog.findViewById(R.id.btn_nguyhiem);
        btn_chidan = dialog.findViewById(R.id.btn_chidan);
        btn_hieulenh = dialog.findViewById(R.id.btn_hieulenh);
        btn_phu = dialog.findViewById(R.id.btn_phu);

        btn_biencam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HocBienBao.this, "Bi???n b??o c???m", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HocBienBao.this,HocBienBao.class);
                intent.putExtra("loaiBienSelect","BI???N B??O C???M");
                intent.putExtra("begin",0);
                intent.putExtra("end",15);
                startActivity(intent);
            }
        });
        dialog.show();

        btn_chidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HocBienBao.this, "Bi???n ch??? d???n", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HocBienBao.this,HocBienBao.class);
                intent.putExtra("loaiBienSelect","BI???N CH??? D???N");
                intent.putExtra("begin",16);
                intent.putExtra("end",30);
                startActivity(intent);
            }
        });
        dialog.show();

        btn_hieulenh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HocBienBao.this, "Bi???n hi???u l???nh", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HocBienBao.this,HocBienBao.class);
                intent.putExtra("loaiBienSelect","BI???N HI???U L???NH");
                intent.putExtra("begin",31);
                intent.putExtra("end",45);
                startActivity(intent);
            }
        });
        dialog.show();

        btn_nguyhiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HocBienBao.this, "Bi???n b??o nguy hi???m v?? c???nh b??o", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HocBienBao.this,HocBienBao.class);
                intent.putExtra("loaiBienSelect","BI???N B??O NGUY HI???M V?? C???NH B??O");
                intent.putExtra("begin",46);
                intent.putExtra("end",60);
                startActivity(intent);
            }
        });
        dialog.show();

        btn_phu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HocBienBao.this, "Bi???n ph???", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HocBienBao.this,HocBienBao.class);
                intent.putExtra("loaiBienSelect","BI???N PH???");
                intent.putExtra("begin",61);
                intent.putExtra("end",71);
                startActivity(intent);
            }
        });
        dialog.show();
    }
}