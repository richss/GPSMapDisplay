package erau.edu.mapdisplay;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.view.View;
import android.util.Log;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    protected EditText latitudeView;
    protected EditText longitudeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create variables for Edit Text Views
        latitudeView = (EditText) findViewById(R.id.latitude);
        longitudeView = (EditText) findViewById(R.id.longitude);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This method launches a map view in response to the button being pressed.
     * @param v - view of clicked object.
     */
    public void launchView(View v) {

        //Grab current values.
        String latStr = latitudeView.getText().toString();
        String longStr = longitudeView.getText().toString();

        //Output results to log for testing
        Log.i("MainActivity", "values=" + latStr + ", " + longStr);
        Toast.makeText(this, "Loading Map", Toast.LENGTH_SHORT).show();

        //Launch Map
        Uri uri = Uri.parse("geo:" + latStr + "," + longStr);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
