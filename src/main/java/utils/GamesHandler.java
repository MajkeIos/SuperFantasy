package utils;

import models.Game;

import java.util.ArrayList;
import java.util.List;

public class GamesHandler {

    private final List<Game> games;
    private static GamesHandler gamesHandler;

    private GamesHandler() {
        games = new ArrayList<>();
        updateGames();
    }

    public static GamesHandler getInstance() {
        if (gamesHandler == null)
            return new GamesHandler();
        return gamesHandler;
    }

    public List<Game> getGames() {
        return games;
    }

    public int countPlayerGames(String summonerName) {
        return games.stream().filter(game -> game.hasPlayer(summonerName)).toList().size();
    }

    private void updateGames() {
        FileHandler.getAllFiles(FileHandler.folderPathname).forEach(folder ->
            FileHandler.getAllFiles(folder).forEach(file -> {
                try {
                    games.add(FileHandler.readGameFromFile(file));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            })
        );
    }
}
