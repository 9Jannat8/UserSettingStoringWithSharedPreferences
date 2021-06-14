package com.example.usersettingstoringwithsharedpreferences;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearlayoutId);

        if (loadColor() != getResources().getColor(R.color.teal_200))
        {
            linearLayout.setBackgroundColor(loadColor());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_layout, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.redColorMenuItemId)
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.red));
            storeColor(getResources().getColor(R.color.red));
        }

        else if (item.getItemId() == R.id.blueColorMenuItemId)
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.blue));
            storeColor(getResources().getColor(R.color.blue));
        }

        else if (item.getItemId() == R.id.greenColorMenuItemId)
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.green));
            storeColor(getResources().getColor(R.color.green));
        }

        else if (item.getItemId() == R.id.yellowColorMenuItemId)
        {
            linearLayout.setBackgroundColor(getResources().getColor(R.color.yellow));
            storeColor(getResources().getColor(R.color.yellow));
        }
        return super.onOptionsItemSelected(item);
    }

    private void storeColor(int color) {
        //data reading
        SharedPreferences sharedPreferences = getSharedPreferences("color", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("backgroundColor", color);
        editor.commit();
    }

    private int loadColor() {
        //data writing
        SharedPreferences sharedPreferences = getSharedPreferences("color", Context.MODE_PRIVATE);
        int selectedColor = sharedPreferences.getInt("backgroundColor", getResources().getColor(R.color.teal_200));
        return selectedColor;
    }
}