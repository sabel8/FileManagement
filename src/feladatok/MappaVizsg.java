package feladatok;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sarandi Abel
 */
public class MappaVizsg {

    public static void main(String[] args) {
        try {
            File f = new File(".").getCanonicalFile();
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getParent());
        } catch (IOException ex) {
            Logger.getLogger(MappaVizsg.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
