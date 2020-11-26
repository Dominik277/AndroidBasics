package android.basics;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

public class ContactListActivity extends AppCompatActivity {

    private static final int REQUEST_READ_CONTACTS = 1;
    ArrayList<String> names = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
    }

    private void populateListView(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,names);
        ListView listView = findViewById(R.id.listViewContact);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ContactListActivity.this,names.get(position),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_READ_CONTACTS){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                loadContacts();
            }else {
                Toast.makeText(this,"Permission Denied,Not able to load contact",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    private void loadContacts(){
        Uri allContacts = Uri.parse("content://contacts/people");
        CursorLoader cursorLoader = new CursorLoader(this,allContacts,
                null,
                null,
                null,
                null
                );

        Cursor cursor = cursorLoader.loadInBackground();
        if (cursor.moveToFirst()){
            do{
               int idIndex = cursor.getColumnIndex(ContactsContract.Contacts._ID);
               String contactID = cursor.getString(idIndex);

               int nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
               String contactDisplayName = cursor.getString(nameIndex);
               names.add(contactDisplayName);
            }while (cursor.moveToNext());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_list, menu);
        return true;
    }

}
