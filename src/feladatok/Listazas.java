package feladatok;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author Sarandi Abel
 */
public class Listazas {

    public static void main(String[] args) {
        File f = new File("c:");
        File[] list = f.listFiles();
        for (int i = 0; i < list.length; i++) {
            DateFormat df = DateFormat.getDateTimeInstance();
            String datum = df.format(new Date(list[i].lastModified()));
            System.out.println(list[i] + "\t  |  " + datum);
        }
    }
}
