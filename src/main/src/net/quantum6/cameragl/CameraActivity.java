package net.quantum6.cameragl;

import net.quantum6.cameragl.video.CameraCapture;
import net.quantum6.cameragl.video.CameraGLSurfaceView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author liyachao 296777513
 * @version 1.0
 * @date 2017/3/1
 */
public class CameraActivity extends Activity implements View.OnClickListener {

    CameraGLSurfaceView mCameraGLSurfaceView;
    Button mSwitchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCameraGLSurfaceView = (CameraGLSurfaceView) findViewById(R.id.camera_gl_surface_view);

        mSwitchBtn = (Button) findViewById(R.id.switch_camera);
        mSwitchBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        mCameraGLSurfaceView.bringToFront();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        mCameraGLSurfaceView.onPause();
    }


    @Override
    public void onClick(View v) {
        CameraCapture.get().switchCamera(1);
    }
}
