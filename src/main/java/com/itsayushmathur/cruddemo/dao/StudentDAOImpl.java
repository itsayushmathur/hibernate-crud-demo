package com.itsayushmathur.cruddemo.dao;

import com.itsayushmathur.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    //implement save method
    @Transactional
    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findByID(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student ", Student.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student where lastName = :theData ", Student.class);

        //set query params
        theQuery.setParameter("theData",theLastName);

        //return query result
        return theQuery.getResultList();
    }
}
