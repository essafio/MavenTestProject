package com.dao;

import com.beans.Cours;

import java.util.List;

public interface CoursDAO {

    Cours getCour(Long id);

    List<Cours> getCours();

    Cours addCours(Cours cours);

    void deleteCours(Long id);

    Cours updateCours(Cours Cours);
}
