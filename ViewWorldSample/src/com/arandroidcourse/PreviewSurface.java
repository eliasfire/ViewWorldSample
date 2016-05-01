package com.arandroidcourse;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class PreviewSurface extends SurfaceView implements Callback {

	private SurfaceHolder m_Holder;
	private Camera m_Camara;

	public PreviewSurface(Context context, Camera camara) {
		super(context);
		
		m_Camara = camara;
		m_Holder = getHolder();
		m_Holder.addCallback(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

		if (m_Holder.getSurface() == null) return;

		try {
			m_Camara.stopPreview();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			m_Camara.setPreviewDisplay(m_Holder);
			m_Camara.startPreview();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
