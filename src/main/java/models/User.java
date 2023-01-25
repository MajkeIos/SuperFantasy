package models;

import controllers.AlertBoxController;
import org.json.JSONObject;

import java.io.IOException;

public class User {

    private final String username;
    private final String password;
    private final boolean adminPrivileges;
    private int points;

    public User(String username, String password, boolean adminPrivileges, int points) {
        this.username = username;
        this.password = password;
        this.adminPrivileges = adminPrivileges;
        this.points = points;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.adminPrivileges = false;
        this.points = 0;
    }

    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.adminPrivileges = user.adminPrivileges;
        this.points = user.points;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getAdminPrivileges() {
        return adminPrivileges;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public JSONObject serialize() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        jsonObject.put("adminPrivileges", adminPrivileges);
        jsonObject.put("points", points);
        return jsonObject;
    }

    public static User deserialize(JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        boolean adminPrivileges = jsonObject.getBoolean("adminPrivileges");
        int points = jsonObject.getInt("points");
        return new User(username, password, adminPrivileges, points);
    }

}
