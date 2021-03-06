package eu.mschuette.psx.rommanager.model;

public class DiscId {
    private String id;

    public DiscId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getPretty() {
        return id.replace("\\","")
                .replace("-", "")
                .replace(";", "")
                .replace("_", "")
                .replace(".", "")
                .toUpperCase();
    }
}
