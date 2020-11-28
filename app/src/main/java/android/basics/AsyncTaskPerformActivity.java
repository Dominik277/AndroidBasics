package android.basics;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AsyncTaskPerformActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_perform);
        new MyAsyncTask().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_async_task_perform,menu);
        return true;
    }

    public void doneCounting(){
        SimpleAlertDialogActivity.displayWithOK(this,"Zavrseno odbrojavanja");
    }

    @SuppressLint("StaticFieldLeak")
    private class MyAsyncTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            for (long i=0; i<100; i++){
                System.out.println(i);
            }
            return null;
        }
        protected void onPostExecute(Void result){
            doneCounting();
        }
    }
}
