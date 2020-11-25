package android.basics;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button drugiGumb = findViewById(R.id.drugiGumb);
        Button prviGumb = findViewById(R.id.prviGumb);

        drugiGumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drugiGumbKliknut(v);
            }
        });

        prviGumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prviGumbKliknut(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.basic_click_handlers,menu);
        return true;
    }

    private void prviGumbKliknut(View view){
        Toast.makeText(this,"Prvi gumb kliknut!",Toast.LENGTH_SHORT).show();
    }

    private void drugiGumbKliknut(View view){
        Toast.makeText(this,"Drugi gumb kliknut!",Toast.LENGTH_SHORT).show();
    }

}