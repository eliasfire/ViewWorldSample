package com.arandroidcourse;

import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import edu.dhbw.andar.ARObject;
import edu.dhbw.andar.ARToolkit;
import edu.dhbw.andar.AndARActivity;
import edu.dhbw.andar.pub.CustomRenderer;

public class MainActivity extends AndARActivity {

	private View m_RootLayout;

	private TextView m_MessageTextView;
	private TextView XposLabel;
	private TextView YposLabel;
	private TextView ZposLabel;
	private TextView m_MarkerNameLabel;
	private TextView XposValue;
	private TextView YposValue;
	private TextView ZposValue;
	private TextView m_MarkerNameValue;

	private ARToolkit m_ARToolKit;
	
	private ARObject m_customObject1;
	private ARObject m_customObject2;
	private ARObject m_customObject3;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		m_RootLayout = findViewById(android.R.id.content);
		CreateLayout((FrameLayout) m_RootLayout);

		CustomRenderer renderer = new CustomRenderer();
		setNonARRenderer(renderer);
		
/*		try {
			m_ARToolKit = getArtoolkit();
			
			m_customObject1 = new Cube("Cube1", "PatternCube1_16.ptt", 80.0, new double[]{0,0});
			m_ARToolKit.registerARObject(m_customObject1);
			
			m_customObject2 = new Cube("Cube2", "PatternCubeA_16.patt", 80.0, new double[]{0,0});
			m_ARToolKit.registerARObject(m_customObject2);
			
			m_customObject3 = new Cube("Cube3", "PatternCubeB_16.patt", 80.0, new double[]{0,0});
			m_ARToolKit.registerARObject(m_customObject3);
			
		} catch (AndARException ex){
			Log.e("AndAR EXCEPTION", ex.getMessage());

		}		
	}
*/	

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onPause() {
		super.onPause(); // Always call the superclass method first

		/*// Release the Camera because we don't need it when paused
		// and other activities might need to use it.
		if (m_Camera != null) {
			m_Camera.release();
			m_Camera = null;
		}*/
	}

	public void onResume() {
		super.onResume(); // Always call the superclass method first

		/*m_Camera = getCameraInstance();

		initializeCameraParameters();

		if (m_Camera == null) {
			// initializeCamera(); // Local method to handle camera init
		} else {
			m_Preview = new PreviewSurface(this, m_Camera);
			setContentView(m_Preview);
		}*/

	}

	/*public static Camera getCameraInstance() {
		Camera c = null;
		try {
			c = Camera.open(0); // attempt to get a Camera instance
		} catch (Exception e) {
			// Camera is not available (in use or does not exist)
		}
		return c; // returns null if camera is unavailable
	}

	private void initializeCameraParameters() {
		Camera.Parameters parameters = m_Camera.getParameters();

		List<Camera.Size> sizes = parameters.getSupportedPreviewSizes();

		Camera.Size size = getBestPreviewSize(640, 840);

		int currentWidth = 0;
		int currentHeight = 0;

		boolean foundDesiredWidth = false;

		for (Camera.Size s : sizes) {
			if (s.width == size.width) {
				currentWidth = s.width;
				currentHeight = s.height;
				foundDesiredWidth = true;
				break;
			}
		}
		if (foundDesiredWidth) {
			parameters.setPreviewSize(currentWidth, currentHeight);
		}
		m_Camera.setParameters(parameters);
	}

	private Camera.Size getBestPreviewSize(int width, int height) {
		Camera.Size result = null;
		Camera.Parameters p = m_Camera.getParameters();
		for (Camera.Size size : p.getSupportedPreviewSizes()) {
			if (size.width <= width && size.height <= height) {
				if (result == null) {
					result = size;
				} else {
					int resultArea = result.width * result.height;
					int newArea = size.width * size.height;

					if (newArea > resultArea) {
						result = size;
					}
				}
			}
		}
		return result;
	}*/

	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		// TODO Auto-generated method stub

	}

	private void CreateLayout(FrameLayout rootLayout) {

		float densityDpi = this.getResources().getDisplayMetrics().density;
		int marginPixel = (int) densityDpi * 5;

		LinearLayout labelsLayouts = new LinearLayout(this);
		LinearLayout.LayoutParams layoutParamRoot = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT, 0);
		labelsLayouts.setOrientation(LinearLayout.VERTICAL);
		labelsLayouts.setLayoutParams(layoutParamRoot);

		LinearLayout.LayoutParams layoutParams;

		XposLabel = new TextView(this);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		XposLabel.setLayoutParams(layoutParams);
		XposLabel.setText(R.string.xPosLabel);

		XposValue = new TextView(this);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		XposValue.setLayoutParams(layoutParams);
		XposValue.setText(R.string.emptyString);

		LinearLayout xlabelsLayouts = new LinearLayout(this);
		xlabelsLayouts.setOrientation(LinearLayout.HORIZONTAL);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		xlabelsLayouts.setLayoutParams(layoutParamRoot);
		xlabelsLayouts.addView(XposLabel);
		xlabelsLayouts.addView(XposValue);
		
		YposLabel = new TextView(this);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		YposLabel.setLayoutParams(layoutParams);
		YposLabel.setText(R.string.yPosLabel);

		YposValue = new TextView(this);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		YposValue.setLayoutParams(layoutParams);
		YposValue.setText(R.string.emptyString);

		LinearLayout ylabelsLayouts = new LinearLayout(this);
		ylabelsLayouts.setOrientation(LinearLayout.HORIZONTAL);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		ylabelsLayouts.setLayoutParams(layoutParamRoot);
		ylabelsLayouts.addView(YposLabel);
		ylabelsLayouts.addView(YposValue);
		
		ZposLabel = new TextView(this);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		ZposLabel.setLayoutParams(layoutParams);
		ZposLabel.setText(R.string.yPosLabel);

		ZposValue = new TextView(this);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		ZposValue.setLayoutParams(layoutParams);
		ZposValue.setText(R.string.emptyString);

		LinearLayout zlabelsLayouts = new LinearLayout(this);
		zlabelsLayouts.setOrientation(LinearLayout.HORIZONTAL);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		zlabelsLayouts.setLayoutParams(layoutParamRoot);
		zlabelsLayouts.addView(ZposLabel);
		zlabelsLayouts.addView(ZposValue);
		
		m_MarkerNameLabel = new TextView(this);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		m_MarkerNameLabel.setLayoutParams(layoutParams);
		m_MarkerNameLabel.setText(R.string.MarkerNameLabel);

		m_MarkerNameValue = new TextView(this);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		m_MarkerNameValue.setLayoutParams(layoutParams);
		m_MarkerNameValue.setText(R.string.emptyString);

		LinearLayout markerNameLabelsLayouts = new LinearLayout(this);
		markerNameLabelsLayouts.setOrientation(LinearLayout.HORIZONTAL);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		markerNameLabelsLayouts.setLayoutParams(layoutParamRoot);
		markerNameLabelsLayouts.addView(m_MarkerNameLabel);
		markerNameLabelsLayouts.addView(m_MarkerNameValue);
		
		m_MessageTextView = new TextView(this);
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(marginPixel, 0, 0, 0);
		m_MessageTextView.setLayoutParams(layoutParams);

		labelsLayouts.addView(xlabelsLayouts);
		labelsLayouts.addView(ylabelsLayouts);
		labelsLayouts.addView(zlabelsLayouts);
		labelsLayouts.addView(markerNameLabelsLayouts);
		labelsLayouts.addView(m_MessageTextView);

		rootLayout.addView(labelsLayouts);
	}
}
