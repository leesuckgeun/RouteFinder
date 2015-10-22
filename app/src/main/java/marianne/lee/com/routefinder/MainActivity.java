package marianne.lee.com.routefinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CanvasView customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCanvas = (CanvasView)findViewById(R.id.canvas);
    }

    public void clearCanvas(View view) {
        customCanvas.clearCanvas();
    }
}
