package utils;

import models.Game;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FileHandler {

    public static final String folderPathname = "src/data/";

    public static Game readGameFromFile(String pathToFile) throws Exception {
        File file = new File(pathToFile);
        if (!file.exists()) {
            throw new Exception("No such file: " + pathToFile);
        }
        return Game.deserialize(new JSONObject(Files.readString(Path.of(pathToFile))));
    }

    public static List<String> getAllFiles(String pathname) {
        File folder = new File(pathname);
        List<String> files = new ArrayList<>();
        Arrays.stream(Objects.requireNonNull(folder.listFiles())).
                forEach(file -> files.add(file.getAbsolutePath()));
        return files;
    }
}
