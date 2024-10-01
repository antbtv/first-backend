package com.ant_btv.dao;

import com.ant_btv.model.Element;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ElementDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveElement(Element element) {
        sessionFactory.getCurrentSession().save(element);
    }

    @SuppressWarnings("unchecked")
    public List<Element> getAllElements() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Element")
                .list();
    }

}
