package feladatok;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 *
 * @author Sarandi Abel
 */
public class KonyvtarLista extends JFrame {

    private JMenuBar mb;
    private JMenu fileMenu = new JMenu("Fájl");
    private KonyvtarPanel kp = new KonyvtarPanel(new File(".."));
    private JFileChooser fc;

    public KonyvtarLista() {
        setTitle("Könyvtárlista");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setJMenuBar(mb = new JMenuBar());
        mb.add(fileMenu);
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                fc.showOpenDialog(mb);
                kp.setWd(fc.getSelectedFile());
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });
        setSize(500, 300);
        JScrollPane sp = new JScrollPane(kp);
        add(sp);
        setVisible(true);
    }

    public static void main(String[] args) {
        new KonyvtarLista();
    }
}

class KonyvtarPanel extends JTextArea {

    private File wd;
    private int szint = 0;

    public KonyvtarPanel(File f) {
        setEditable(false);
        setWd(f);
    }

    public void setWd(File wd) {
        this.wd = wd;
        setText("");
        refreshText();
    }

    private void refreshText() {
        refreshText(wd);
    }

    private void refreshText(File wd) {
        String[] dirList = wd.list();
        for (int i = 0; i < dirList.length; i++) {
            String szokozok = "";
            for (int n = 0; n < szint; n++) {
                szokozok += "  | ";
            }
            append(szokozok + dirList[i] + "\n");
            if (wd.listFiles()[i].isDirectory()) {
                szint++;
                refreshText(wd.listFiles()[i]);
                szint--;
            }
        }
    }
}
