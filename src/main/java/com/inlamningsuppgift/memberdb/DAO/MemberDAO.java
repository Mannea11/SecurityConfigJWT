package com.inlamningsuppgift.memberdb.DAO;

import com.inlamningsuppgift.memberdb.Entity.Member;

import java.util.List;

public interface MemberDAO {

    List<Member> findAll();

    Member findById(int id);
    Member save(Member member);

    void deleteById(int id);




}
