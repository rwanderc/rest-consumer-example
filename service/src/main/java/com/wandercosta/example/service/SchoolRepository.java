package com.wandercosta.example.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SchoolRepository {

    private final List<School> db = new ArrayList<>();

    public SchoolRepository() {
        populateDatabase();
    }

    private void populateDatabase() {
        final School school1 = new School();
        school1.setId(1);
        school1.setName("School1");
        school1.setAddress("Addr1");

        final School school2 = new School();
        school2.setId(2);
        school2.setName("School2");
        school2.setAddress("Addr2");

        final School school3 = new School();
        school3.setId(3);
        school3.setName("School3");
        school3.setAddress("Addr3");

        db.add(school1);
        db.add(school2);
        db.add(school3);
    }

    public List<School> getSchools() {
        return db;
    }

    public School getSchool(long id) {
        return db.stream()
                .filter(school -> school.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
