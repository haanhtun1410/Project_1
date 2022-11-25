/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilsHuy;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author huyki
 */
public class MsgBox {
    public  static  void alert(Component pa,String mess){
        JOptionPane.showMessageDialog(pa, mess, "Hệ thống quản lý laptop", JOptionPane.INFORMATION_MESSAGE);
    }
    public  static  boolean  comfirm(Component pa,String mess){
        int kq = JOptionPane.showConfirmDialog(pa, mess, "Hệ thống quản lý laptop", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return kq == JOptionPane.YES_OPTION;
    }
   
}
