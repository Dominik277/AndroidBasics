package android.basics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class IntentWithResultActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_with_result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_intent_with_result,menu);
        return true;
    }

    public void enterText(View v){
        startActivityForResult(new Intent
                (IntentWithResultActivity.this,SimpleReturnResultActivity.class)
                ,GET_RESULT_TEXT);
    }

    protected void onActivityResult(int requstCode, int resultCode, Intent data){
        if (requstCode == 0){
            if (requstCode == RESULT_OK){
                TextView tvResult = findViewById(R.id.txtDisplayResult);
                tvResult.setText(data.getStringExtra("result"));
                Toast.makeText(this,data.getStringExtra("result"),Toast.LENGTH_LONG).show();
            }
        }
    }

}
