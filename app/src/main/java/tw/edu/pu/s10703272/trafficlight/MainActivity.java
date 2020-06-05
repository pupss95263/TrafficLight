package tw.edu.pu.s10703272.trafficlight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt1;
    EditText edt2;
    EditText edt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //設定全螢幕顯示
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //設定螢幕為橫式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);
        edt1= (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        edt3 = (EditText) findViewById(R.id.edt3);



    }
    public void StartGame(View v){
        if(edt1.getText().toString().equals("")||edt2.getText().toString().equals("")||edt3.getText().toString().equals("")){
            Toast.makeText(this, "燈號的秒數不能為空白",Toast.LENGTH_SHORT).show();
        }else if(edt1.getText().toString().equals("0")||edt2.getText().toString().equals("0")||edt3.getText().toString().equals("0")){
            Toast.makeText(this, "燈號的秒數不能為0",Toast.LENGTH_SHORT).show();
        }else{
            Intent it = new Intent();
            it.setClass(this, GameActivity.class);
            it.putExtra("綠燈",Integer.parseInt(edt1.getText().toString()));
            it.putExtra("黃燈",Integer.parseInt(edt2.getText().toString()));
            it.putExtra("紅燈",Integer.parseInt(edt3.getText().toString()));
            startActivity(it);
            finish();
        }

    }

    public void EndApp(View v){
        finish();
    }

}
