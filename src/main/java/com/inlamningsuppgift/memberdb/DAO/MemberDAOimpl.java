package com.inlamningsuppgift.memberdb.DAO;

import com.inlamningsuppgift.memberdb.Entity.Member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberDAOimpl implements MemberDAO {


private EntityManager entityManager;

@Autowired
public void MemberDAO(EntityManager manager){
    entityManager = manager;}

    @Override
    public List<Member> findAll() {
        TypedQuery<Member>query = entityManager.createQuery("FROM Member", Member.class);
        List<Member>members = query.getResultList();
        return members;
    }

    @Override
    public Member findById(int id) {
    Member member = entityManager.find(Member.class, id);
        return member;
    }

    @Override
    public Member save(Member memb) {
    Member member =  entityManager.merge(memb);
    return member;
    }

    @Override
    public void deleteById(int id) {
        Member member = entityManager.find(Member.class,id);
        entityManager.remove(member);
    }
}
