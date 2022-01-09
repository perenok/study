package com.perenok.study.jpa;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Parent parent;

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY)
    private List<GrandChild> grandChildren = new ArrayList<>();

    public Child(String name, Parent parent) {
        this.name = name;
        this.parent = parent;
    }

    public void addGrandChild(GrandChild grandChild) {
        this.grandChildren.add(grandChild);
    }

    public void addGrandChildren(List<GrandChild> grandChildren){
        this.grandChildren = grandChildren;
    }
}
