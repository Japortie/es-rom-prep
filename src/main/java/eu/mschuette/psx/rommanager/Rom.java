package eu.mschuette.psx.rommanager;

import com.google.common.primitives.Chars;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class Rom {
    private static final char[] BOOT = new char[] { 'c', 'd', 'r', 'o', 'm', ':' };
    private String file;

    public Rom(String file) {
        this.file = file;
    }

    public DiscId getDiscId() {
//        return boot.toString();
        char[] buffer = new char[BOOT.length + (10 << 20)];
//        File fiel;
//        fiel.read
//        return "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.read(buffer, 0, buffer.length);
            int i = Chars.indexOf(buffer, BOOT);
            if (i != -1) {
                System.out.println("Yeah");
                String chunk = new String(buffer, i + BOOT.length, 40);
                int start = chunk.contains("\\") ? chunk.indexOf("\\") : 0;
                int end = chunk.contains(";") ? chunk.indexOf(";") : chunk.length() -1;
                String id = chunk.substring(start, end);
                return new DiscId(id);
            } else {
                System.out.println("No");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DiscId("UNKNN001");
    }
}
