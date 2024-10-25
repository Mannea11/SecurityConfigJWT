package com.inlamningsuppgift.memberdb.Services;

import com.inlamningsuppgift.memberdb.Entity.Member;

import java.util.List;

public interface MemberService {

    List<Member> findAll();

    Member findById(int id);

    Member save(Member member);

    void deleteById(int id);
}
