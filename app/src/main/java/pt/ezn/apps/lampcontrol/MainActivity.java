package pt.ezn.apps.lampcontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

  /*  public void clickEvent (View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            String x = String.valueOf(event.getX());
            String y = String.valueOf(event.getY());
            //Toast.makeText(this, x + y, Toast.LENGTH_LONG).show();
        }
    }*/

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // MotionEvent object holds X-Y values
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            String text = "You click at x = " + event.getX() + " and y = " + event.getY();
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }

        return super.onTouchEvent(event);
    }
}
