import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    static final String SEPARATOR = File.separator;
    static final StringBuilder sb = new StringBuilder();

    private static void createDir(File path) {
        if (path.exists()) {
            sb.append("Директория ").append(path.getAbsolutePath()).append(" не создана, т.к уже существует \n");
        } else {
            if (path.mkdir()) {
                sb.append("Директория ").append(path.getAbsolutePath()).append(" успешно создана \n");
            } else {
                sb.append("Директория ").append(path.getAbsolutePath()).append(" не создана, потому что что-то пошло не так \n");
            }
        }
        new File(String.valueOf(path));
    }

    // метод создания нового файла в директории, проверка на существование
    private static void createFile(File path) {
        if (path.exists()) {
            sb.append("Файл ").append(path.getAbsolutePath()).append(" не создан, т.к уже существует \n");
        } else {
            try {
                if (path.createNewFile()) {
                    sb.append("Файл ").append(path.getAbsolutePath()).append(" создан \n");
                } else {
                    sb.append("Файл ").append(path.getAbsolutePath()).append(" не создан по неясной причине \n");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        new File(String.valueOf(path));
    }


    // ОСНОВНОЙ МЕТОД MAIN
    public static void main(String[] args) throws IOException {
        String f = "F:" + SEPARATOR +"Games" + SEPARATOR;

        List<File> dirs = Arrays.asList(
                new File(f + SEPARATOR + "src"),
                new File(f + SEPARATOR + "temp"),
                new File(f + SEPARATOR + "res"),
                new File(f + SEPARATOR + "savegames"),
                new File(f + SEPARATOR + "src" + SEPARATOR +"main"),
                new File(f + SEPARATOR + "src" + SEPARATOR + "test"),
                new File(f + SEPARATOR + "res" + SEPARATOR + "drawables"),
                new File(f + SEPARATOR + "res" + SEPARATOR + "vectors"),
                new File(f + SEPARATOR + "res" + SEPARATOR + "icons")
        );

        List<File> files = Arrays.asList(
                new File(f + SEPARATOR + "src" + SEPARATOR +"main" + SEPARATOR + "Main.java"),
                new File(f + SEPARATOR + "src" + SEPARATOR +"main" + SEPARATOR + "Utils.java"),
                new File(f + SEPARATOR + "temp" + SEPARATOR + "temp.txt")
        );

        //пробежать потоком по списку ссылок
        dirs.forEach(Main::createDir);
        files.forEach(Main::createFile);


        //записываем лог
        File temp = new File(f + SEPARATOR + "temp" + SEPARATOR + "temp.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(temp))) {
            writer.append(sb);
            writer.flush();
        }
    }
}