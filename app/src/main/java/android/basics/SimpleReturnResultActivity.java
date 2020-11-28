package android.basics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class SimpleReturnResultActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_return_result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_simple_return_result,menu);
        return true;
    }

    public void sendResult(View v){
        String result = ((EditText)findViewById(R.id.txtRandomResultText)).getText().toString();
        Intent i = new Intent();
        i.putExtra("result",result);
        setResult(RESULT_OK,i);
        finish();
    }
}
