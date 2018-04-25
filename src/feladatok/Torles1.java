package feladatok;

import java.io.File;

/**
 *
 * @author Sarandi Abel
 */
public class Torles1 {
    
    private static final String EXTENSION = "~jav";
    
    public static void main(String[] args) {
        File f;
        if (args.length == 0) {
            System.err.println("Nincs paraméter!");
            return;
        }
        try {
            f = new File(args[0]);
        } catch (Exception e) {
            System.err.print("Nem jó a paraméter!");
            System.err.print(e);
            return;
        }
        if (!f.isDirectory()) {
            System.err.println("Nem könyvtár!");
            return;
        }
        for (File currFile : f.listFiles()) {
            if (nameScan(currFile)) {
                try {
                    currFile.delete();
                    System.out.println("Sikeres törlés: "+currFile.getName());
                } catch (Exception e) {
                    System.err.println("Nem sikerült a törlés!");
                    System.err.println(e);
                }
            }
        }
    }
    
    static boolean nameScan (File n) {
        return n.getName().toUpperCase().endsWith(EXTENSION.toUpperCase());
    }
}
