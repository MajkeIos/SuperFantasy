package utils;

import items.*;
import items.epic.*;
import items.legendary.*;
import models.Game;
import models.player.Player;

import java.util.HashMap;

public class ItemsHandler {

    private static final HashMap<String, ItemFormula> legendaryItems = new HashMap<>() {{
       put("Divine Ascent", DivineAscent::getPoints);
       put("Guardian Totem", GuardianTotem::getPoints);
       put("Incapacitor", Incapacitor::getPoints);
       put("Legend Aura", Scythe::getPoints);
       put("Scythe", Scythe::getPoints);
       put("Sharp Blade", SharpBlade::getPoints);
       put("Spirit Of The Squire", SpiritOfTheSquire::getPoints);
       put("The Stalker", TheStalker::getPoints);
       put("Thirsty Scythes", ThirstyScythes::getPoints);
       put("Wild Claw", WildClaw::getPoints);
    }};

    private static final HashMap<String, ItemFormula> epicItems = new HashMap<>() {{
        put("Beast Hunter", BeastHunter::getPoints);
        put("Berseker Ax", BersekerAx::getPoints);
        put("Bloody Instinct", BloodyInstinct::getPoints);
        put("Conquering Staff", ConqueringStaff::getPoints);
        put("Fast Furious Blade", FastFuriousBlade::getPoints);
        put("Heavenly Vision", HeavenlyVision::getPoints);
        put("Obsidian Battle Plate", ObsidianBattlePlate::getPoints);
        put("Omnipresent Spirit", OmnipresentSpirit::getPoints);
        put("Rampage Momentum", RampageMomentum::getPoints);
        put("Sacred Help", SacredHelp::getPoints);
        put("Secret Scroll", SecretScroll::getPoints);
        put("Steel Aura", SteelAura::getPoints);
        put("The Puppeteer", ThePuppeteer::getPoints);
        put("The Visionary", TheVisionary::getPoints);
        put("Treasurer's Wisdom", TreasurersWisdom::getPoints);
    }};

    private static final HashMap<String, ItemFormula> rareItems = new HashMap<>() {{
//        put("", ::getPoints);
    }};

    private static final HashMap<String, ItemFormula> commonItems = new HashMap<>() {{
//        put("", ::getPoints);
    }};

    public static HashMap<String, ItemFormula> getLegendaryItems() {
        return legendaryItems;
    }

    public static HashMap<String, ItemFormula> getEpicItems() {
        return epicItems;
    }

    public static HashMap<String, ItemFormula> getRareItems() {
        return rareItems;
    }

    public static HashMap<String, ItemFormula> getCommonItems() {
        return commonItems;
    }

    public static double getItemPoints(String itemName, String summonerName) {
        double itemPoints = 0;
        ItemFormula itemFormula = getItemFormula(itemName);
        for (Game game : GamesHandler.getInstance().getGames()) {
            if (game.hasPlayer(summonerName)) {
                Player player = game.getPlayer(summonerName);
                itemPoints += itemFormula.getPoints(game, player);
            }
        }
        return itemPoints;
    }

    public static double getAverageItemPoints(String itemName, String summonerName) {
        double itemPoints = ItemsHandler.getItemPoints(itemName, summonerName);
        double gamesPlayed = GamesHandler.getInstance().countPlayerGames(summonerName);
        return itemPoints / gamesPlayed;
    }

    private static ItemFormula getItemFormula(String itemName) {
        HashMap<String, ItemFormula> tmpMap = new HashMap<>();
        tmpMap.putAll(legendaryItems);
        tmpMap.putAll(epicItems);
        tmpMap.putAll(rareItems);
        tmpMap.putAll(commonItems);
        return tmpMap.get(itemName);
    }

}

