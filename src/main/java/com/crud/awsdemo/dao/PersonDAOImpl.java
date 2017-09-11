package com.crud.awsdemo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crud.awsdemo.spring.model.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {

    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addPerson(Person prsn) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(prsn);
        logger.info("Person *saved* successfully; Deets = " + prsn);
    }

    @Override
    public void updatePerson(Person prsn) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(prsn);
        logger.info("Person *updated* successfully; Deets = " + prsn);

    }

    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person prsn = (Person) session.load(Person.class, new Integer(id));
        logger.info(("Person *loaded* successfully; Deets = "+prsn));

        return prsn;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personList = session.createQuery("from PERSON").list();

        for (Person p : personList) {
            logger.info("Person List::" + p);
        }

        return personList;
    }


    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person prsn = (Person) session.load(Person.class, new Integer(id));

        if (null != prsn) {
            session.delete(prsn);
        }

        logger.info("Person *deleted* successfully; Deets = " + prsn);

    }


}
