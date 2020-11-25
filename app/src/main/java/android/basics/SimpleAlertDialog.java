package android.basics;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class SimpleAlertDialog {

    public static void displayWithOK(Context context,String poruka){
            displayWithOK(context,poruka,"Alert Dialog Primjer");
    }

    public static void displayWithOK(Context context,String poruka,String naslov){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        alertDialog.setTitle(naslov);
        alertDialog.setMessage(poruka);

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.hide();
            }
        });
        alertDialog.show();
    }

}
