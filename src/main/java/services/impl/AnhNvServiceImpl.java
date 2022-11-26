/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import domainmodels.AnhNv;
import java.util.List;
import responsitory.AnhNvResponsitory;
import responsitory.impl.AnhNvResponsitoryImpl;
import services.AnhNvService;

/**
 *
 * @author huyki
 */
public class AnhNvServiceImpl implements AnhNvService{
    private AnhNvResponsitory anhNvResponsitory = new AnhNvResponsitoryImpl();

    @Override
    public List<AnhNv> getAll() {
        return anhNvResponsitory.getAll();
    }

    @Override
    public AnhNv getById(String id) {
        return anhNvResponsitory.getById(id);
    }
}
