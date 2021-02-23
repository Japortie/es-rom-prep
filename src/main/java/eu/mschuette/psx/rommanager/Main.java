package eu.mschuette.psx.rommanager;

import com.thoughtworks.xstream.XStream;

import java.util.List;

public class Main {
    public static void main(String... args) {
        String gamelistFile = "";

//        System.out.println("Huhu");
//        Rom rom = new Rom("/home/schuette/Downloads/Bin2Pbp/testroms/Firestorm - Thunderhawk 2 (Europe) (En,Fr) (Track 01).bin");
//        System.out.println(String.format("Rom: '%s'", rom.getDiscId().getId()));
//        System.out.println(String.format("Rom Pretty: '%s'", rom.getDiscId().getPretty()));
//        System.out.println(String.format("%d", 10 << 20));

//        Gamelist gamelist = parseGamelist(gamelistFile);
//        List<Rom> roms = gamelist.findRoms();
//        roms.forEach(rom -> {
//            compressToChd(rom);
//            createOutputDir(rom);
//            copy(rom);
//            copySbi(rom);
//        });
//        generateGamelist();

        GameList gameList = new GameList();
        Game game = new Game();
        game.setName("FF8");
        game.setPath("/roms/FF8.cue");
        gameList.add(game);

        XStream xStream = new XStream();
        xStream.alias("game", Game.class);
        xStream.alias("gameList", GameList.class);

        String s = xStream.toXML(gameList);
        System.out.println(s);
    }
}
