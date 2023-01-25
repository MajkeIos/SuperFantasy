package utils;

import controllers.AlertBoxController;
import models.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

import static java.lang.System.exit;

public class UsersHandler {

    ArrayList<User> users;
    private static UsersHandler usersHandler;
    private final String usersFilename = "users.json";

    private UsersHandler() {
        try {
            initialize();
        } catch (Exception e) {
            e.printStackTrace();
            exit(-1);
        }
    }

    public static UsersHandler getInstance() {
        if (usersHandler != null) {
            return usersHandler;
        }
        return new UsersHandler();
    }

    public void saveUsers() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.putAll(users.stream().map(User::serialize).toArray());
        jsonObject.put("users", jsonArray);
        FileHandler.saveJsonToFile(jsonObject, usersFilename);
    }

    public void addUser(String username, String password) {
        users.add(new User(username, password));
        saveUsers();
    }

    public User getUser(String username) {
        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }

    public void addPointsToUser(String username, int pointsToAdd) {
        User user = getUser(username);
        user.setPoints(user.getPoints() + pointsToAdd);
        saveUsers();
    }

    private void initialize() throws Exception {
        users = new ArrayList<>();
        JSONObject jsonObject = FileHandler.readJsonFromFile(FileHandler.folderPathname + usersFilename);
        if (jsonObject == null) {
            return;
        }
        JSONArray jsonArray = jsonObject.getJSONArray("users");
        IntStream.range(0, jsonArray.length())
                .forEach(i -> users.add(User.deserialize(jsonArray.getJSONObject(i))));
    }
}
