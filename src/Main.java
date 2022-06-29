import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    static final StringBuilder sb = new StringBuilder();

    private static File createDir(File path) {
        if (path.exists()) {
            sb.append("Директория ").append(path.getAbsolutePath()).append(" не создана, т.к уже существует \n");
        } else {
            if (path.mkdir()) {
                sb.append("Директория ").append(path.getAbsolutePath()).append(" успешно создана \n");
            } else {
                sb.append("Директория ").append(path.getAbsolutePath()).append(" не создана, потому что что-то пошло не так \n");
            }
        }
        return new File(String.valueOf(path));
    }

    //todo доделать метод создания нового файла в директории, проверку на существование
    private static File createFile(File path) {
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
        return new File(String.valueOf(path));
    }


    //TODO ОСНОВНОЙ МЕТОД MAIN
    public static void main(String[] args) throws IOException {

        List<File> dirs = Arrays.asList(
                new File("F://Games//src"),
                new File("F://Games//temp"),
                new File("F://Games//res"),
                new File("F://Games//savegames"),
                new File("F://Games//src/main"),
                new File("F://Games//src//test"),
                new File("F://Games//res//drawables"),
                new File("F://Games//res//vectors"),
                new File("F://Games//res//icons")
        );

        List<File> files = Arrays.asList(
                new File("F://Games//src//main//Main.java"),
                new File("F://Games//src//main//Utils.java"),
                new File("F://Games//temp//temp.txt")
        );

        //todo пробежать потоком по списку ссылок




        File temp = new File("F://Games/temp/temp.txt");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(temp));
            writer.append(sb);
            writer.flush();
        } finally {
            if (writer != null) writer.close();
        }

    }
}