/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feladatok;

import java.io.File;
import java.util.Vector;

/**
 *
 * @author ati
 */
public class JDKKereses {
    
    static Vector jdkDirList = new Vector();

    public static void main(String[] args) {
        File[] l = File.listRoots();
        for (File file : l) {
            System.out.println("Vizsgálat itt: " + file.getPath());
            searchJDK(file);
        }
    }

    private static void searchJDK(File dir) {
        if (dir.listFiles()==null) {
            return ;
        }
        for (File aktFile : dir.listFiles()) {
            if (aktFile.isDirectory()) {
                if (aktFile.getName().startsWith("jdk")) {
                    System.out.println(aktFile);
                    jdkDirList.add(aktFile);
                    return ;
                } else {
                    searchJDK(aktFile);
                }
            }
        }
    }

}
