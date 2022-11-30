/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import com.raven.component.Menu;
import com.raven.main.Main;

/**
 *
 * @author longv
 */
public class Test {

    public static void main(String[] args) {
        String id = "hd10";
        int co = id.length();
        String txt = id.substring(0, 2);
        String num = id.substring(2, co);
        int n = Integer.valueOf(num);
        n++;
        String snum = String.valueOf(n);
        System.out.println("");
        id = txt + snum;
        System.out.println(id);

    }
}
