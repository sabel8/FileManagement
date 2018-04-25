package feladatok;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author ati
 */
public class RenameJPG extends JFrame{

    JFileChooser fc;
    static int n = 0;

    public RenameJPG() {
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.showOpenDialog(this);
        File dir = fc.getSelectedFile();
        for (File img : dir.listFiles()) {
            if (img.getName().endsWith(".jpg")) {
                try {
                    img.renameTo(new File(img.getParentFile().getCanonicalPath() +"\\"+ ++n + ".jpg"));
                } catch (IOException ex) {
                    Logger.getLogger(RenameJPG.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println("Változások: " + n);
        System.exit(0);
    }

    public static void main(String[] args) {
        new RenameJPG();
    }

}
