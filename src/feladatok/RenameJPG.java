package feladatok;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ati
 */
public class RenameJPG extends JFrame {

    JFileChooser fc;
    static int n = 0;

    public RenameJPG() {
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if (fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "Érvénytelen mappa!", "Hiba",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        File dir = fc.getSelectedFile();
        for (File img : dir.listFiles()) {
            if (img.getName().endsWith(".jpg")) {
                try {
                    img.renameTo(new File(img.getParentFile().getCanonicalPath()
                            + "\\" + ++n + ".jpg"));
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        }
        String msg = "Sikeres átnevezés\nÁtnevezett fájlok: " + n;
        JOptionPane.showMessageDialog(this, msg, "Siker", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    public static void main(String[] args) {
        new RenameJPG();
    }

}
