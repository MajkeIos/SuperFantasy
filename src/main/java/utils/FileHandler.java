package utils;

import models.Game;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.lang.System.exit;

public class FileHandler {

    public static final String folderPathname = "src/data/";
    public static final String gamesPathname = "src/data/games";

    public static Game readGameFromFile(String pathname) throws Exception {
        File file = new File(pathname);
        if (!file.exists()) {
            throw new Exception("No such file: " + pathname);
        }
        return Game.deserialize(new JSONObject(Files.readString(Path.of(pathname))));
    }

    public static JSONObject readJsonFromFile(String pathname) throws Exception {
        File file = new File(pathname);
        if (!file.exists()) {
            return null;
        }
        return new JSONObject(Files.readString(Path.of(pathname)));
    }

    public static void saveJsonToFile(JSONObject jsonObject, String filename) {
        String pathname = folderPathname + filename;
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(pathname);
            fileWriter.write(jsonObject.toString(2));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            exit(-1);
        }
    }

    public static List<String> getAllFiles(String pathname) {
        File folder = new File(pathname);
        List<String> files = new ArrayList<>();
        Arrays.stream(Objects.requireNonNull(folder.listFiles())).
                forEach(file -> files.add(file.getAbsolutePath()));
        return files;
    }

}
