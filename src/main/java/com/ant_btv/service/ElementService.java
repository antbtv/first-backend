package com.ant_btv.service;

import com.ant_btv.dao.ElementDao;
import com.ant_btv.model.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;

@Service
public class ElementService {

    @Autowired
    private ElementDao elementDao;

    @Autowired
    private JsonReaderService jsonReaderService;

    @Transactional
    public void saveElementsFromJson(String jsonFilePath) throws IOException {
        Map<String, Element> elements = jsonReaderService.readElementsFromJson(jsonFilePath);
        for (Element element : elements.values()) {
            elementDao.saveElement(element);
        }
    }
}
