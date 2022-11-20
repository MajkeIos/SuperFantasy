package utils;

import models.Game;

import java.util.ArrayList;
import java.util.List;

public class WeeksHandler {

    private final List<Game> games = new ArrayList<>();

    public WeeksHandler(String folderName) {
        List<String> gamesFromFolder = FileHandler.getAllFiles(FileHandler.folderPathname + folderName);
        gamesFromFolder.forEach(path -> {
            try {
                games.add(FileHandler.readGameFromFile(path));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public List<Game> getGames() {
        return games;
    }
}
