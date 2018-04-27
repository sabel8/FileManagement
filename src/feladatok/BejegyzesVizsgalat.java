package feladatok;

import java.io.File;
import java.text.DateFormat;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author ati
 */
public class BejegyzesVizsgalat extends JFrame {

    private final JFileChooser FC;
    private File fajl;

    public BejegyzesVizsgalat() {
        setTitle("Bejegyzés vizsgálat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        FC = new JFileChooser();
        if (FC.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(this, "Rossz fájl lett kiválasztva!",
                    "Hiba", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        fajl = FC.getSelectedFile();
        DateFormat d = DateFormat.getDateInstance();
        String datum = d.format(fajl.lastModified());
        JTextArea ta = new JTextArea();
        ta.append("Abszolút útvonal: \t" + fajl.getAbsolutePath() + "\n");
        ta.append("Könyvtár neve:    \t" + fajl.getParent() + "\n");
        ta.append("Állomány neve:    \t" + fajl.getName() + "\n");
        ta.append("Méret (bájt):     \t" + fajl.length() + "\n");
        ta.append("Utolsó módosítás: \t" + datum + "\n");
        ta.append(fajl.isHidden() ? "Rejtett, " : "Nyilvános, ");
        ta.append(fajl.canRead() ? "olvasható, " : "nem olvasható, ");
        ta.append(fajl.canWrite() ? "írható, " : "nem írható, ");
        ta.append(fajl.canExecute()? "futtatható." : "nem futtatható.");
        add(ta);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new BejegyzesVizsgalat();
    }

}
