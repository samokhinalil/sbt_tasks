package homework.v3;

import homework.v3.entity.JsonFileClass;
import homework.v3.entity.JsonParameters;

import java.io.*;

public class JsonParameterSerializeHandler {
    public static void write(String fileName, JsonFileClass jsonFileClass) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)){
            try (ObjectOutputStream oos = new ObjectOutputStream(fos)){
                oos.writeObject(jsonFileClass);
            }
        }
    }

    public static JsonFileClass read(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(filename)){
            try (ObjectInputStream ois = new ObjectInputStream(fis)){
                return (JsonFileClass)ois.readObject();
            }
        }

    }
}
