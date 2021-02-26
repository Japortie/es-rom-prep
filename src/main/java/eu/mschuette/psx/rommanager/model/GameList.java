package eu.mschuette.psx.rommanager.model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;

public class GameList extends LinkedList<Game> {
    private Document gamelistXml;

    public GameList(Document gamelistXml) {
        this.gamelistXml = gamelistXml;
    }

    public List<Game> getGames() {
        NodeList games = gamelistXml.getElementsByTagName("game");
        List<Game> list = new LinkedList<>();
        for(int i = 0; i < games.getLength(); i++) {
            list.add(new Game((Element) games.item(i)));
        }
        return list;
    }
//
//    public GameList(List<Game> games) {
//        this.games = games;
//    }
//
//    public List<Game> getGames() {
//        return games;
//    }
//
//    public void setGames(List<Game> games) {
//        this.games = games;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        GameList gameList = (GameList) o;
//        return Objects.equals(games, gameList.games);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(games);
//    }
//
//    @Override
//    public String toString() {
//        return "GameList{" +
//                "games=" + games +
//                '}';
//    }
}

