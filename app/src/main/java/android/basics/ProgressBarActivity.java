package android.basics;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ProgressBarActivity extends Activity {

    ProgressBar pb;
    TextView tvResult;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);

        pb = findViewById(R.id.pgDownloading);
        tvResult = findViewById(R.id.txtUrlOutput);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_progress_bar,menu);
        return true;
    }

    public void startFourUrlAsync(){
        new DelayTask().execute();
    }

    public class DelayTask extends AsyncTask<Void,Integer,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }



    }

}
