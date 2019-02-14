package com.example.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Show a toast with the resourceID.
     * @param resId
     */
    public void showToast(int resId) {
        String str = getString(R.string.button_clicked, getString(resId));
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    /**
     * Show a toast with the string of parameter.
     * @param resId
     */
    public void showToast(String resId) {
        String str = getString(R.string.button_clicked, resId);
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    /**
     * Simple Alert Dialog with confirm button.
     * @param view
     */
    public void clickADConfirm(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alert_dialog_title);
        builder.setMessage(R.string.alert_dialog_message);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast(R.string.ok);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * AlertDialog with positive and negative button.
     * @param view
     */
    public void clickADMultiple(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alert_dialog_title);
        builder.setMessage(R.string.alert_dialog_message);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast(R.string.ok);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast(R.string.cancel);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * AlertDialog with a list of items
     * @param view
     */
    public void clickADList(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alert_dialog_title);
        builder.setItems(R.array.items_array, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String item = getResources().getStringArray(R.array.items_array)[which];
                showToast(item);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * AlertDialog with list with selectable items.
     * @param view
     */
    public void clickADPicker(View view) {
        final ArrayList<String> selectedItems = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alert_dialog_title);
        builder.setMultiChoiceItems(R.array.items_array, null,
                new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                String item = getResources().getStringArray(R.array.items_array)[which];
                if(isChecked) {
                    selectedItems.add(item);
                }else if(selectedItems.contains(item)) {
                    selectedItems.remove(item);
                }
            }
        });
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               showToast(selectedItems.toString());
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast(R.string.cancel);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    /**
     * AlertDialog with a custom view.
     * @param view
     */
    public void clickADCustom(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();

        builder.setTitle(R.string.alert_dialog_title);

        // Instance the custom view and get the edittexts
        View alertView = getLayoutInflater().inflate(R.layout.dialog_view, null);
        builder.setView(alertView);
        final EditText etUsername = alertView.findViewById(R.id.username);
        final EditText etPassword = alertView.findViewById(R.id.password);

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                Toast.makeText(getApplicationContext(), username + " " + password,
                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast(R.string.cancel);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
