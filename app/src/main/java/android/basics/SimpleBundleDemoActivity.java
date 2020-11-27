package android.basics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SimpleBundleDemoActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_bunde_demo);

        String initialText = getIntent().getStringExtra("text");
        TextView tvDisplayText = findViewById(R.id.tvDisplayText);

        if (initialText != null){
            tvDisplayText.setText(initialText);
            getActionBar().setHomeButtonEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_simple_bundle_demo,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent i = new Intent(this,ActionBarMenuActivity.class);
                startActivity(i);
                break;
            default:
                break;
        }
        return true;
    }
}
