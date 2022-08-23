package jp.syoboi.a2chMate.activity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import jp.co.airfront.android.a2chMate.R;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void removeMonakey(View view) {
        SharedPreferences pref = getSharedPreferences("2chapi", 0);
        pref.edit().remove("2chapi_monakey").commit();
        view.setEnabled(false);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setVisibility(View.VISIBLE);
    }
}