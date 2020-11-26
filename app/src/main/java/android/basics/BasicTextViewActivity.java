package android.basics;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BasicTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_text_view);
        Log.d("DEBUG","onCreate was just called!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DEBUG","onResume was just called!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("DEBUG","onPause was just called!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_basic_text_view,menu);
        return true;
    }
}
