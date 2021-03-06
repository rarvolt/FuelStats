package net.rarvolt.fuelstats;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton addRefuelingFab = (FloatingActionButton) findViewById(R.id.add_refueling_fab);
        assert addRefuelingFab != null;
        addRefuelingFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRefueling(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        } else if (id == R.id.action_history) {
            startActivity(new Intent(this, RefuelingHistoryActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addRefueling(View view) {
        startActivity(new Intent(this, AddRefuelingActivity.class));
    }
}
