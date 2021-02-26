package eu.mschuette.psx.rommanager.model;

import org.w3c.dom.Element;


public class Game {
    private Element node;

    public Game(Element node) {
        this.node = node;
    }

    public String getTitle() {
        return getElementContent("name");
    }

    public String getElementContent(String element) {
        return node.getElementsByTagName(element).item(0).getTextContent();
    }

    public Rom getRom() {
        return new Rom(getElementContent("path"));
    }
}
