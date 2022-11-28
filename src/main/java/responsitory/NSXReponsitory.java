/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory;

import domainmodels.Nsx;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface NSXReponsitory {
    public List<Nsx> getNSX();
    public boolean them(Nsx a);
    public boolean sua(Nsx a);
    public boolean xoa(Nsx a);
}
