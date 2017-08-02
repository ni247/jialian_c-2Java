package utils;

import java.util.UUID;

public class UUIDUtils {
	public static String getID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void main(String[] args) {
		System.out.println(getID());
	}

	public static String getCode() {
		return getID();
	}
}
