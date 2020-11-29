package android.basics;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class PersistSettingsActivity extends Activity {

    SharedPreferences prefs;
    SharedPreferences.Editor edits;
    TextView txtPersist;
    CheckBox chkPersist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persist_settings);

        txtPersist = findViewById(R.id.txtPersistText);
        chkPersist = findViewById(R.id.chkPersistState);

        prefs = getSharedPreferences("view",0);
        edits = prefs.edit();
        populateValues();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_persist_settings,menu);
        return true;
    }

    public void populateValues(){
        String persistedText = prefs.getString("txtVal","None stored yet");
        boolean isChecked = prefs.getBoolean("chkState",false);
        txtPersist.setText(persistedText);
        chkPersist.setChecked(isChecked);
    }

    public void persistValues(View view){
        edits.putString("txtVal",txtPersist.getText().toString());
        edits.putBoolean("chkState",chkPersist.isChecked());
        edits.commit();
        Toast.makeText(this,"Persisted",Toast.LENGTH_SHORT).show();
    }

}
