package android.basics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BasicImageDownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_image_download);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

        downloadImageFromUri("https://oecdenvironmentfocusblog.files.wordpress.com/2020/06/wed-blog-shutterstock_1703194387_low_nwm.jpg?w=640");
    }

    private void downloadImageFromUri(String adresa){
        URL url;
        try {
            url = new URL(adresa);
        }catch (Exception e){
            url = null;
        }

        URLConnection urlConnection;
        InputStream inputStream;
        Bitmap bitmap;

        try {
            urlConnection = url.openConnection();
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        }catch (Exception e){
            bitmap = null;
        }

        if (bitmap != null){
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_basic_image_download,menu);
        return true;
    }
}
