/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilsHuy;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;

/**
 *
 * @author huyki
 */
public class ShareHelper {
    public  static  final Image App_Icon;
    static {
        String file = "/imgs/fpt.png";
        App_Icon = new ImageIcon(ShareHelper.class.getResource(file)).getImage();
    }
    
    public static final String PATH_IMAGE = "E:\\icon_Sof203\\Hinh";
    
    public  static  boolean  saveLogo(File file){
        File dir = new File("logo");
        if(!dir.exists()){
            dir.mkdirs();
        }
        File newfile = new File(dir,file.getName());
        try {
            Path sourse = Paths.get(newfile.getAbsolutePath());
            Path desti = Paths.get(file.getAbsolutePath());
            Files.copy(sourse, desti,StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
