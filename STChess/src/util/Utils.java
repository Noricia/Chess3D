package util;

import java.io.InputStream;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.lwjgl.BufferUtils;

public class Utils {

	public static FloatBuffer storeDataInFloatBuffer(float[] data) {
		FloatBuffer buffer = BufferUtils.createFloatBuffer(data.length);
		buffer.put(data).flip();
		return buffer;
	}
	
	public static IntBuffer storeDataInIntBuffer(int[] data) {
		IntBuffer buffer = BufferUtils.createIntBuffer(data.length);
		buffer.put(data).flip();
		return buffer;
	}
	
	public static String loadResource(String filename) throws Exception {
		String result;
		try(InputStream in = Utils.class.getResourceAsStream(filename);
				Scanner scanner = new Scanner(in, StandardCharsets.UTF_8.name())){
			result = scanner.useDelimiter("\\A").next();
		}
		return result;
	}
}
