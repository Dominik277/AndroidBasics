package android.basics;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class ActionBarMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_action_bar_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_bar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuToastDesni:
                Toast.makeText(this,"Desni gumb kliknut",Toast.LENGTH_LONG).show();
                break;
            case R.id.menuToastLijevi:
                Toast.makeText(this,"Lijevi gumb kliknut",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true;
    }
}
