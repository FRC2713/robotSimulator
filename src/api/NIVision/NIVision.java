package api.NIVision;

import java.awt.Image;
import java.awt.Rectangle;

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

}
