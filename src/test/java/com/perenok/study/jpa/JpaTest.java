package com.perenok.study.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class JpaTest {

    Logger log = LoggerFactory.getLogger(JpaTest.class);

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    @Autowired
    private GrandChildRepository grandChildRepository;

    private Parent savedParent1;

    @BeforeEach
    void setup() {
        log.info("currentTransactionName : {}", TransactionSynchronizationManager.getCurrentTransactionName());

        Parent parent1 = new Parent("부모1");
        savedParent1 = parentRepository.save(parent1);

        Child child1 = new Child("자식1", savedParent1);
        Child child2 = new Child("자식2", savedParent1);
        Child child3 = new Child("자식3", savedParent1);
        Child savedChild1 = childRepository.save(child1);
        Child savedChild2 = childRepository.save(child2);
        Child savedChild3 = childRepository.save(child3);
        savedParent1.addChildren(List.of(savedChild1, savedChild2, savedChild3));

        GrandChild grandChild1 = new GrandChild("손주1", savedChild1);
        GrandChild grandChild2 = new GrandChild("손주2", savedChild1);
        GrandChild grandChild3 = new GrandChild("손주3", savedChild1);
        GrandChild grandChild4 = new GrandChild("손주4", savedChild2);
        GrandChild grandChild5 = new GrandChild("손주5", savedChild2);
        GrandChild grandChild6 = new GrandChild("손주6", savedChild2);
        GrandChild grandChild7 = new GrandChild("손주7", savedChild3);
        GrandChild grandChild8 = new GrandChild("손주8", savedChild3);
        GrandChild grandChild9 = new GrandChild("손주9", savedChild3);

        grandChildRepository.saveAll(Arrays.asList(grandChild1, grandChild2, grandChild3, grandChild4, grandChild5, grandChild6, grandChild7, grandChild8, grandChild9));

        savedChild1.addGrandChildren(grandChildRepository.findByChild(savedChild1));
        savedChild2.addGrandChildren(grandChildRepository.findByChild(savedChild2));
        savedChild3.addGrandChildren(grandChildRepository.findByChild(savedChild3));
        em.flush();
        em.clear();
    }

    @Test
    @DisplayName("ManyToOne fetch 조인 가능 테스트")
    @Transactional
    @Rollback(value = false)
    void manyToOneTest() {
        log.info("currentTransactionName : {}", TransactionSynchronizationManager.getCurrentTransactionName());

//        PageRequest pageRequest = PageRequest.of(1, 4);

        List<GrandChild> allForTesting = grandChildRepository.findAll();

        for (GrandChild grandChild : allForTesting) {
            System.out.println(grandChild.getName() + ", " + grandChild.getChild().getName() + ", " + grandChild.getChild().getParent().getName());
        }
    }

    @Test
    @DisplayName("OneToMany fetch 조인 가능 테스트")
    @Transactional
    @Rollback(value = false)
    void oneToManyTest() {
        log.info("currentTransactionName : {}", TransactionSynchronizationManager.getCurrentTransactionName());

        PageRequest pageRequest = PageRequest.of(0, 3);

//        Page<Parent> allForTesting = parentRepository.findAllFetches(pageRequest);
//        for (Parent parent : allForTesting) {
//            for (Child child : parent.getChildren()) {
//                for (GrandChild grandChild : child.getGrandChildren()) {
//                    System.out.println("부모 : " + parent.getName() + ", 자식 : " + child.getName() + ", 손주 : " + grandChild.getName());
//                }
//            }
//        }
    }
}
