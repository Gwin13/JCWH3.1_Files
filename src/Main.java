import javax.xml.namespace.QName;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.awt.SystemColor.text;

public class Main {
    static final StringBuilder sb = new StringBuilder();


    private static File createDir(File path, String name) {
        if (path.exists()) {
            sb.append("Директория " + path.getAbsolutePath() + " не создана, т.к уже существует \n");
        } else {
            if (path.mkdir()) {
                sb.append("Директория " + path.getAbsolutePath() + " успешно создана \n");
            } else {
                sb.append("Директория " + path.getAbsolutePath() + " не создана, потому что что-то пошло не так \n");
            }
        }
        return new File(name);
    }
//todo доделать метод создания нового файла, проверку на существование
    private static File createFile(File path, String name) {
        return null;
    }

    public static void main(String[] args) throws IOException {

        createDir(new File("F://Games/src"),"src");
        createDir(new File("F://Games/test"),"test");
        createDir(new File("F://Games/res"),"res");
        createDir(new File("F://Games/savegames"),"savegames");


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

