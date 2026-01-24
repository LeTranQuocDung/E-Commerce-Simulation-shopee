
package util;
import java.io.*;
import java.util.*;

public class CSVReader {
    public static List<String[]> read(String path) throws Exception {
        List<String[]> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        boolean header = true;

        while ((line = br.readLine()) != null) {
            if (header) { header = false; continue; }
            list.add(line.split(","));
        }
        br.close();
        return list;
    }
}
