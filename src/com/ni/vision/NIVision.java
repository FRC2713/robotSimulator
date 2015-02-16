package com.ni.vision;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class NIVision {

	public class ImageType {

		public static final int IMAGE_RGB = 0;

	}

	public static class Rect {
		public Rect(int x1, int y1, int x2, int y2) {

		}
	}

	public static Image imaqCreateImage(int imageRgb, int i) {
		return null;
	}

	public static int IMAQdxOpenCamera(String stuff, String cameracontrolmodecontroller) {
		return 0;
	}

	public class IMAQdxCameraControlMode {

		public static final String CameraControlModeController = " ";

	}

	public static void IMAQdxConfigureGrab(int session) {
		// TODO Auto-generated method stub

	}

	public static void IMAQdxStartAcquisition(int session) {
		// TODO Auto-generated method stub

	}

	public static void IMAQdxGrab(int session, Image frame, int i) {
		// TODO Auto-generated method stub

	}

	public class Image extends java.awt.Image {

		@Override
		public int getWidth(ImageObserver observer) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getHeight(ImageObserver observer) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ImageProducer getSource() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Graphics getGraphics() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object getProperty(String name, ImageObserver observer) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
