/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domainmodels.User;

/**
 *
 * @author longv
 */
public interface LoginServices {
    User loginCheck(String idNV,String mk);
}
