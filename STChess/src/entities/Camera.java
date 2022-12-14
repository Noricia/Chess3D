package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {

	private Vector3f position = new Vector3f(0f, 0f, 0f);
	private float pitch = 15f;
	private float yaw = 340f;
	private float roll;

	private float zoom = 1f;

	public Camera() {

	}

	public void move() {

		if (Keyboard.isKeyDown(Keyboard.KEY_I)) {
			zoom -= zoom / 100f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_K)) {
			zoom += zoom / 100f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			yaw = (yaw + 1f) % 360f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			yaw = (yaw - 1f) % 360f;
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			pitch = (pitch + 1f) > 90f ? 90f : (pitch + 1f);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			pitch = (pitch - 1f) < 0 ? 0 : (pitch - 1f);
		}

		position.x = -(float) (Math.sin(yaw / Math.toDegrees(1)) * Math.cos(pitch / Math.toDegrees(1))) * zoom;
		position.z = (float) (Math.cos(yaw / Math.toDegrees(1)) * Math.cos(pitch / Math.toDegrees(1))) * zoom;
		position.y = (float) Math.sin(pitch / Math.toDegrees(1)) * zoom;
	}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}
}
