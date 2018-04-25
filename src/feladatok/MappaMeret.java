package feladatok;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author Sarandi Abel
 */
public class MappaMeret extends JFrame {

    private JMenuBar mb;
    private JMenu fileMenu = new JMenu("Fájl");
    private KonyvtarMeretPanel kmp = new KonyvtarMeretPanel(new File(".."));
    private JFileChooser fc;
    private JWindow loading;

    public MappaMeret() {
        setTitle("Könyvtárlista mérettel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        loading = new JWindow(this);
        loading.add(new JLabel("Loading..."));
        loading.setSize(100, 30);
        loading.setLocationRelativeTo(this);
        
                loading.setVisible(true);

        setJMenuBar(mb = new JMenuBar());
        mb.add(fileMenu);
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                fc.showOpenDialog(mb);
                loading.setVisible(true);
                kmp.setWd(fc.getSelectedFile());
                loading.setVisible(false);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
        setSize(500, 300);
        JScrollPane sp = new JScrollPane(kmp);
        add(sp);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MappaMeret();
    }
}

class KonyvtarMeretPanel extends JTextArea {

    private File wd;
    private int szint = 0;

    public KonyvtarMeretPanel(File f) {
        setEditable(false);
        setWd(f);
    }

    public void setWd(File wd) {
        this.wd = wd;
        setText("");
        refreshText();
//        loading.setVisible(false);
    }

    private void refreshText() {
        refreshText(wd);
    }

    private void refreshText(File wd) {
        for (int i = 0; i < wd.list().length; i++) {
            String szokozok = "";
            File aktFile = wd.listFiles()[i];
            for (int n = 0; n < szint; n++) {
                szokozok += "  | ";
            }
            if (aktFile.isDirectory()) {
                append(szokozok + aktFile.getName() + " "
                        + getFolderSize(aktFile) + "\n");
                szint++;
                refreshText(wd.listFiles()[i]);
                szint--;
            } else {
                append(szokozok + "> " + aktFile.getName() + "\n");
            }
        }

    }

    private int getFolderSize(File f) {
        int osszeg = 0;
        for (int i = 0; i < f.list().length; i++) {
            File aktF = f.listFiles()[i];
            if (aktF.isDirectory()) {
                osszeg += getFolderSize(aktF);
            } else {
                osszeg += aktF.length();
            }
        }
        return osszeg;
    }
}
