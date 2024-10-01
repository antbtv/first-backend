package com.ant_btv;

import com.ant_btv.service.ElementService;
import com.ant_btv.service.OwlService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ElementService elementService = context.getBean(ElementService.class);
        OwlService owlService = context.getBean(OwlService.class);

        try {
            // Загрузка элементов из JSON в БД
            elementService.saveElementsFromJson("scheme.json");
            System.out.println("Elements saved to database.");

            // Сохранение элементов из БД в OWL
            owlService.saveElementsToOwl("output.owl");
            System.out.println("Elements saved to OWL file.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }
}
