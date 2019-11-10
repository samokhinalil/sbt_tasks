package homework.v3;

import homework.v3.extentity.JsonFileClass;

import java.io.*;

public class JsonParameterExternalizeHandler {
	public static void write(String fileName, JsonFileClass o) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName)){
			try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
				o.writeExternal(oos);
			}
		}
	}

	public static JsonFileClass read(String fileName) throws IOException, ClassNotFoundException {
		try (FileInputStream fis = new FileInputStream(fileName)){
			try (ObjectInputStream ois = new ObjectInputStream(fis)){
				JsonFileClass o = (JsonFileClass) ois.readObject();
				return o;
			}
		}
	}
}
