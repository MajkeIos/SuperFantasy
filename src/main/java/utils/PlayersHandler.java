package utils;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayersHandler {

    private static final ArrayList<String> topPlayers = new ArrayList<>(Arrays.asList("G2 Broken Blade", "AST Vizicsacsi",
            "RGE Odoamne", "FNC Wunder", "VIT Alphari", "MAD Armut", "XL Finn", "MSF Irrelevant", "BDS Agresivoo", "SK JNX"));

    private static final ArrayList<String> junglePlayers = new ArrayList<>(Arrays.asList("G2 Jankos", "AST Xerxe",
            "RGE Malrang", "FNC Razork", "VIT Haru", "MAD Elyoya", "XL Markoon", "MSF Shlatan", "BDS Cinkrof", "SK Gilius"));

    private static final ArrayList<String> middlePlayers = new ArrayList<>(Arrays.asList("G2 Jankos", "AST Dajor",
            "RGE Larssen", "FNC Humanoid", "VIT Perkz", "MAD Nisqy", "XL Nukeduck", "MSF Vetheo", "BDS NUCLEARINT", "SK Sertuss"));

    private static final ArrayList<String> bottomPlayers = new ArrayList<>(Arrays.asList("G2 Jankos", "AST Kobbe",
            "RGE Comp", "FNC Upset", "VIT Carzzy", "MAD UNF0RGIVEN", "XL Patrik", "MSF Neon", "BDS xMatty", "SK Jezu"));

    private static final ArrayList<String> supportPlayers = new ArrayList<>(Arrays.asList("G2 Jankos", "AST JeongHoon",
            "RGE Trymbi", "FNC Hylissang", "VIT Labrov", "MAD Kaiser", "XL Mikyx", "MSF Mersa", "BDS Erdote", "SK Treatz"));


    public static ArrayList<String> getPlayersFromPosition(String position) {
        switch (position) {
            case "top" -> { return topPlayers;}
            case "jungle" -> { return junglePlayers; }
            case "middle" -> { return middlePlayers; }
            case "bottom" -> { return bottomPlayers; }
            case "support" -> { return supportPlayers; }
        }
        return new ArrayList<>();
    }

}
