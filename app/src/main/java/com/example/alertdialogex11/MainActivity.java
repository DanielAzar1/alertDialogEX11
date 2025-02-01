package com.example.alertdialogex11;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;
/**
 *  Displays 5 buttons that show different alert dialogs
 */
public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5;
    AlertDialog.Builder adb;
    AlertDialog ad1, ad2, ad3, ad4, ad5;

    /**
     * Creates the activity
     * @param savedInstanceState The saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button2);
        btn2 = findViewById(R.id.button3);
        btn3 = findViewById(R.id.button4);
        btn4 = findViewById(R.id.button5);
        btn5 = findViewById(R.id.button6);

        adb = new AlertDialog.Builder(this);

        adb.setTitle("First example: only text");
        adb.setMessage("This is a simple alert dialog");
        ad1 = adb.create();

        adb.setTitle("Second example: text with photo");
        adb.setMessage("This is a simple alert dialog with photo");
        adb.setIcon(R.drawable.ic_launcher_foreground);
        ad2 = adb.create();

        adb.setTitle("Third example: text with photo and close button");
        adb.setMessage("This is a simple alert dialog with photo and button");
        adb.setIcon(R.drawable.ic_launcher_foreground);
        adb.setCancelable(false);
        adb.setNeutralButton("Close", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ad3 = adb.create();


        adb.setTitle("Forth example: text with two button");
        adb.setMessage("This button changes the background");
        adb.setIcon(R.drawable.ic_launcher_foreground);
        adb.setPositiveButton("Close", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        adb.setNeutralButton("Change Background", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Random rnd = new Random();

                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

                MainActivity.this.getWindow().getDecorView().setBackgroundColor(color);
            }
        });

        ad4 = adb.create();


        adb.setTitle("Fifth example: text with three button");
        adb.setMessage("This button changes the background and the other returns the color to white");
        adb.setNegativeButton("ResetBackground", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Random rnd = new Random();

                int color = Color.argb(255,255,255,255);

                MainActivity.this.getWindow().getDecorView().setBackgroundColor(color);
            }
        });
        ad5 = adb.create();
    }


    /**
     * Function creates the first alert dialog
     * @param view The View that was clicked
     */
    public void msgOnly(View view)
    {;
        ad1.show();
    }

    /**
     * Function creates the second alert dialog
     * @param view The View that was clicked
     */
    public void msgWithPhoto(View view)
    {
        ad2.show();
    }

    /**
     * Function creates the third alert dialog
     * @param view The View that was clicked
     */
    public void msgWithPhotoAndClose(View view)
    {
        ad3.show();
    }

    /**
     * Function creates the fourth alert dialog
     * @param view The View that was clicked
     */
    public void msgWithTwoButtons(View view)
    {
        ad4.show();
    }

    /**
     * Function creates the fifth alert dialog
     * @param view The View that was clicked.
     */
    public void msgWithThreeButtons(View view)
    {
        ad5.show();
    }

    /**
     * Function creates the menu
     * @param menu the menu to inflate
     * @return true if the menu was inflated
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Function Manages the menu
     * @param item the item selected
     * @return true if the item was selected
     */
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        // Launch credit screen
        Intent si = new Intent(this, creditActivity.class);
        startActivity(si);

        // Returns to the main menu
        return super.onOptionsItemSelected(item);
    }
}