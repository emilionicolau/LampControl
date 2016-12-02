package pt.ezn.apps.lampcontrol;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        FrameLayout frame = (FrameLayout) findViewById(R.id.activity_main);
        Rect rectf = new Rect();
        frame.getGlobalVisibleRect(rectf);
        float x_center = (rectf.right - rectf.left)/2;
        float y_center = (rectf.bottom - rectf.top)/2;

        // MotionEvent object holds X-Y values
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            String text = "Center is: " + x_center + "," + y_center + "You click at x = " +
                    event.getX() + " and y = " + event.getY();
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }

        Log.d("WIDTH        :",String.valueOf(rectf.width()));
        Log.d("HEIGHT       :",String.valueOf(rectf.height()));
        Log.d("left         :",String.valueOf(rectf.left));
        Log.d("right        :",String.valueOf(rectf.right));
        Log.d("top          :",String.valueOf(rectf.top));
        Log.d("bottom       :",String.valueOf(rectf.bottom));

        return super.onTouchEvent(event);
    }


}
