package pt.ezn.apps.lampcontrol;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static int REQUEST_ENABLE_BT = 0;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBluetoothAdapter == null) {
            // Device does not support Bluetooth
            String text = getResources().getString(R.string.noBluetooth);
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }

        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return true;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        Rect rectf = new Rect();
        frame.getGlobalVisibleRect(rectf);
        float x_center = (rectf.right) / 2;
        float y_center = (rectf.bottom) / 2;
        int position = 0;

        // MotionEvent object holds X-Y values
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if ((event.getX() <= x_center) && (event.getY() <= y_center)) {
                position = 1;
            }
            if ((event.getX() > x_center) && (event.getY() < y_center)) {
                position = 2;
            }
            if ((event.getX() < x_center) && (event.getY() > y_center)) {
                position = 3;
            }
            if ((event.getX() >= x_center) && (event.getY() >= y_center)) {
                position = 4;
            }

            String text = "Center is: " + x_center + ", " + y_center + "  You click at x = " +
                    event.getX() + " and y = " + event.getY() + " Your position is: " + position;
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }

        /*Log.d("WIDTH        :",String.valueOf(rectf.width()));
        Log.d("HEIGHT       :",String.valueOf(rectf.height()));
        Log.d("left         :",String.valueOf(rectf.left));
        Log.d("right        :",String.valueOf(rectf.right));
        Log.d("top          :",String.valueOf(rectf.top));
        Log.d("bottom       :",String.valueOf(rectf.bottom));*/

        return super.onTouchEvent(event);
    }


}
