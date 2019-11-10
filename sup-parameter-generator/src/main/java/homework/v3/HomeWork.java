package homework.v3;

import homework.v3.entity.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Задание
 * 1) Составить файл с JSON-объектом, который "разложен" в пакете homework.v3.entity.
 * Определить какой элемент является корневым
 * Дать имя файлу homework.parameters.json
 * 2) Заполнить его значениями (как пример "parameters.v1.json")
 * 3) Считать получившийся homework.parameters.json в память
 * 4) Сериализовать его с помощью встроенного механиза сериализации в файл с именем homework.parameters.ser
 * 5) Сериализовать его с использованием интерфейса Externalizable в файл с именем homework.parameters.exter
 * 6) Считать данные из файла homework.parameters.ser в память и сохранить в формате JSON в файл с именем homework.result.ser.parameters.json
 * 7) Считать данные из файла homework.parameters.exter в память и сохранить в формате JSON в файл с именем homework.result.exter.parameters.json
 * 8) Убедиться, что файлы homework.result.ser.parameters.json и  homework.result.exter.parameters.json
 * совпадают с homework.parameters.json
 */
public class HomeWork {
	public final static String FILE_1 = "homework.parameters.json";
	public final static String FILE_2 = "homework.parameters.ser";
	public final static String FILE_3 = "homework.result.ser.parameters.json";
	public final static String FILE_4 = "homework.parameters.exter";
	public final static String FILE_5 = "homework.result.exter.parameters.json";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//1,2
		JsonFileClass jsonFileClass = new JsonFileClass();
		init(jsonFileClass);

		File file = new File(FILE_1);
		JsonParameterHandler jsonParameterHandler = new JsonParameterHandler();
		System.out.println("Записываем данные в файл " + FILE_1);
		jsonParameterHandler.write(file, jsonFileClass);
		System.out.println("Данные записаны на диск в файл " + FILE_1);
		//3
		System.out.println("Считываем данные из файла " + FILE_1);
		JsonFileClass objectFromFile = jsonParameterHandler.read(file, JsonFileClass.class);
		System.out.println("Данные считаны с файла " + FILE_1);
		//4
		System.out.println("Записываем данные в файл " + FILE_2);
		JsonParameterSerializeHandler.write(FILE_2, objectFromFile);
		System.out.println("Данные записаны на диск в файл " + FILE_2);
		//6
		System.out.println("Считываем данные из файла " + FILE_2);
		JsonFileClass deserializedObject = JsonParameterSerializeHandler.read(FILE_2);
		System.out.println("Данные считаны с файла " + FILE_2);
		System.out.println("Записываем данные в файл " + FILE_3);
		jsonParameterHandler.write(new File(FILE_3), deserializedObject);
		System.out.println("Данные записаны на диск в файл " + FILE_3);
		//5
		homework.v3.extentity.JsonFileClass o = new homework.v3.extentity.JsonFileClass();
		System.out.println("Записываем данные в файл " + FILE_4);
		JsonParameterExternalizeHandler.write(FILE_4, o);
		System.out.println("Данные записаны на диск в файл " + FILE_4);
		//7
		System.out.println("Считываем данные из файла " + FILE_4);
		homework.v3.extentity.JsonFileClass deserializeObjectExt = JsonParameterExternalizeHandler.read(FILE_4);
		System.out.println("Данные считаны с файла " + FILE_4);
		System.out.println("Записываем данные в файл " + FILE_5);
		jsonParameterHandler.write(new File(FILE_5), deserializeObjectExt);
		System.out.println("Данные записаны на диск в файл " + FILE_5);
	}

	private static void init(JsonFileClass jsonFileClass) {
		jsonFileClass.setVersion("v1");
		JsonParameters parameters = new JsonParameters();

		parameters.setName("param name");
		parameters.setType("param type");
		parameters.setList(false);
		parameters.setDescription("param description");

		Path path1 = new Path();
		path1.setCode("code 1");
		path1.setValue("value 1");
		Path path2 = new Path();
		path2.setCode("code 2");
		path2.setValue("value 2");
		ArrayList<Path> paths = new ArrayList<>();
		paths.add(path1);
		paths.add(path2);

		Bundle bundle = new Bundle();
		bundle.setPath(paths);
		ArrayList<Bundle> bundles = new ArrayList<>();
		bundles.add(bundle);
		parameters.setBundle(bundles);

		ArrayList<String> roles = new ArrayList<>();
		roles.add("role 1");
		roles.add("role 2");

		parameters.setRoles(roles);
		ArrayList<JsonParameters> params = new ArrayList<>();
		params.add(parameters);
		jsonFileClass.setParameters(params);
	}
}
