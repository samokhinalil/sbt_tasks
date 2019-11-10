package homework.v3;

import classwork.params.entity.template.v2.Fallback;
import homework.v3.entity.JsonFileClass;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonParameterHandler {
    private ObjectMapper mapper = new ObjectMapper();

    public <T> void write(File file, T o) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, o);
    }

    public <T> T read(File file, Class<T> tClass) throws IOException {
        return mapper.readValue(file, tClass);
    }
//    public void write(File file, JsonFileClass jsonFileClass) throws IOException {
//        mapper.writerWithDefaultPrettyPrinter().writeValue(file, jsonFileClass);
//    }
//
//    public JsonFileClass read(File file) throws IOException {
//        return mapper.readValue(file, JsonFileClass.class);
//    }
}
