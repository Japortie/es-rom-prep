package eu.mschuette.psx.rommanager.io;

import eu.mschuette.psx.rommanager.model.GameList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class GameListReader {
    private static final Logger log = LoggerFactory.getLogger(GameListReader.class);

    public GameList read(String file) {
        log.info("Load file {}", file);
        File inputFile = new File(file);
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputFile);
            return new GameList(doc);
        } catch (ParserConfigurationException e) {
            log.error("Error configuring parser", e);
            throw new RuntimeException(e);
        } catch (SAXException e) {
            log.error("Could not parse Gamelist file", e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            log.error("Could not read Gamelist file", e);
            throw new RuntimeException(e);
        }

    }
}
