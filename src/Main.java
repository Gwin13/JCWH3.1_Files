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

    //todo доделать метод создания нового файла, проверку на существование
    private static File createFile(String path, String name) {
        return null;
    }


    //TODO ОСНОВНОЙ МЕТОД MAIN
    public static void main(String[] args) throws IOException {

        List<File> dirs = Arrays.asList(
        new File("F://Games/src"),
        new File("F://Games/temp"),
        new File("F://Games/res"),
        new File("F://Games/savegames"),
                new File("F://Games/src/main"),
                new File("F://Games/src/test"),
                new File("F://Games/res/drawables"),
                new File("F://Games/res/vectors"),
                new File("F://Games/res/icons")
        );

        List<File> files = Arrays.asList(
          new File("F://Games/src/main","Main.java"),
                new File("F://Games/src/main","Utils.java"),
                new File("F://Games/temp","temp.txt")
        );

        //todo пробежать потоком по списку ссылок

        File srcF1 = new File("F://Games/src/main/Main.java");

        try {
            if (srcF1.createNewFile()) {
                sb.append("Файл " + srcF1.getAbsolutePath() + " создан \n");
            } else {
                sb.append("Файл " + srcF1.getAbsolutePath() + " не создан, т.к уже существует \n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File srcF2 = new File("F://Games/src/main/Utils.java");

        try {
            if (srcF2.createNewFile()) {
                sb.append("Файл " + srcF2.getAbsolutePath() + " создан \n");
            } else {
                sb.append("Файл " + srcF2.getAbsolutePath() + " не создан, т.к уже существует \n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

//            File srcDir2 = new File("F://Games/src/test");
//            if (srcDir2.mkdir()) {
//                sb.append("Директория " + srcDir2.getAbsolutePath() + " создана \n");
//            } else {
//                sb.append("Директория " + srcDir2.getAbsolutePath() + " не создана, т.к уже существует \n");
//            }
//
//
//            File dir2 = new File("F://Games/res");
//            if (dir2.mkdir()) {
//                sb.append("Директория " + dir2.getAbsolutePath() + " создана \n");
//            } else {
//                sb.append("Директория " + dir2.getAbsolutePath() + " не создана, т.к уже существует \n");
//            }
//            File dir3 = new File("F://Games/savegames");
//            if (dir3.mkdir()) {
//                sb.append("Директория " + dir3.getAbsolutePath() + " создана \n");
//            } else {
//                sb.append("Директория " + dir3.getAbsolutePath() + " не создана, т.к уже существует \n");
//            }

        File dir4 = new File("F://Games/temp");
        if (dir4.mkdir()) {
            sb.append("Директория " + dir4.getAbsolutePath() + " создана \n");
        } else {
            sb.append("Директория " + dir4.getAbsolutePath() + " не создана, т.к уже существует \n");
        }
        File resDir1 = new File("F://Games/res/drawables");
        if (resDir1.mkdir()) {
            sb.append("Подкаталог " + resDir1.getAbsolutePath() + " создан \n");
        } else {
            sb.append("Подкаталог " + resDir1.getAbsolutePath() + " не создан, т.к уже существует \n");
        }
        File resDir2 = new File("F://Games/res/vectors");
        if (resDir2.mkdir()) {
            sb.append("Подкаталог " + resDir2.getAbsolutePath() + " создан \n");
        } else {
            sb.append("Подкаталог " + resDir2.getAbsolutePath() + " не создан, т.к уже существует \n");
        }
        File resDir3 = new File("F://Games/res/icons");
        if (resDir3.mkdir()) {
            sb.append("Подкаталог " + resDir3.getAbsolutePath() + " создан \n");
        } else {
            sb.append("Подкаталог " + resDir3.getAbsolutePath() + " не создан, т.к уже существует \n");
        }


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