package com.inlamningsuppgift.memberdb.Services;

import com.inlamningsuppgift.memberdb.DAO.MemberDAO;
import com.inlamningsuppgift.memberdb.Entity.Member;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberServiceImpl implements MemberService {

    private MemberDAO memberDAO;

    @Autowired
    public MemberServiceImpl(MemberDAO membDAO){
    memberDAO = membDAO;
    }

    @Override
    public List<Member> findAll() {
        return memberDAO.findAll();
    }

    @Override
    public Member findById(int id) {
        return memberDAO.findById(id);
    }
    @Transactional
    @Override
    public Member save(Member member) {
        return memberDAO.save(member);
    }
    @Transactional
    @Override
    public void deleteById(int id) {
    memberDAO.deleteById(id);
    }
}
