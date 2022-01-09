package com.perenok.study.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GrandChildRepository extends JpaRepository<GrandChild, Long> {

    @Query(value = "select g from GrandChild g where g.child= :child")
    List<GrandChild> findByChild(Child child);
}
