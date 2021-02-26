package eu.mschuette.psx.rommanager.model;

import com.google.common.primitives.Chars;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class Rom {
    private static final char[] BOOT = new char[] { 'c', 'd', 'r', 'o', 'm', ':' };
    private String file;

    public Rom(String file) {
        this.file = file;
    }

    public DiscId getDiscId() {
        Cue cue = new Cue(file);
        List<String> bins = cue.getBins();
//        return boot.toString();
        char[] buffer = new char[BOOT.length + (10 << 20)];
//        File fiel;
//        fiel.read
//        return "";
        try {
            Path cueFile = Path.of(file);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(cueFile.resolveSibling(bins.get(0)).toFile()));
            bufferedReader.read(buffer, 0, buffer.length);
            int i = Chars.indexOf(buffer, BOOT);
            if (i != -1) {
                String chunk = new String(buffer, i + BOOT.length, 40);
                int start = chunk.contains("\\") ? chunk.indexOf("\\") : 0;
                int end = chunk.contains(";") ? chunk.indexOf(";") : chunk.length() -1;
                String id = chunk.substring(start, end);
                return new DiscId(id);
            } else {
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DiscId("UNKNN001");
    }
}
