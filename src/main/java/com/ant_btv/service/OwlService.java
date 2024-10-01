package com.ant_btv.service;

import com.ant_btv.model.Element;
import com.ant_btv.dao.ElementDao;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class OwlService {

    @Autowired
    private ElementDao elementDao;

    public void saveElementsToOwl(String owlFilePath) {
        Model model = ModelFactory.createDefaultModel();

        // Define namespaces
        String ns = "http://example.org/ontology#";

        // Retrieve elements from the database
        List<Element> elements = elementDao.getAllElements();

        for (Element element : elements) {
            Resource resource = model.createResource(ns + element.getId());
            model.add(resource, model.createProperty(ns + "name"), element.getName());
            model.add(resource, model.createProperty(ns + "hour"), String.valueOf(element.getHour()));
        }

        // Save the model to a file
        try (FileOutputStream out = new FileOutputStream(owlFilePath)) {
            model.write(out, "RDF/XML");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
