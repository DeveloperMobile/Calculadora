package com.blogspot.codigosandroid.calculadora.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Tiago on 29/10/2016.
 */

public class AlertUtils {

    public static void alert(Activity activity, String title, String message, int sim) {

        alert(activity, title, message, 0, 0);

    }

    public static void alert(Activity activity, String message, int sim) {

        alert(activity, null, message, 0, 0);

    }

    public static void alert(Activity activity, String title, String message, int okButton, int icon) {

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);

        if (icon > 0) {

            builder.setIcon(icon);

        }

        if (title != null) {

            builder.setTitle(title);

        }

        builder.setMessage(message);
        String okString = okButton > 0 ? activity.getString(okButton) : "OK";

        android.app.AlertDialog dialog = builder.create();
        dialog.setButton(android.app.AlertDialog.BUTTON_POSITIVE, okString, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                return;

            }

        });
        dialog.show();

    }

    public static void alert(Context context, String title, String message, int okButton, final DialogCallback dialogCallback) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title).setMessage(message);
        String ok = okButton > 0 ? context.getString(okButton) : "OK";
        // Add the buttons
        builder.setPositiveButton(ok, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (dialogCallback != null) {

                    dialogCallback.dialogcallback();

                }

            }

        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public interface DialogCallback {

        void dialogcallback();

    }

}
