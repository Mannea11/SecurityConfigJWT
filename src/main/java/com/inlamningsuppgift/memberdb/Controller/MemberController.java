package com.inlamningsuppgift.memberdb.Controller;

import com.inlamningsuppgift.memberdb.Entity.Member;
import com.inlamningsuppgift.memberdb.Exception.MemberError;
import com.inlamningsuppgift.memberdb.Exception.MemberNotFoundException;
import com.inlamningsuppgift.memberdb.Services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mypages")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService membService){
        memberService = membService;
    }

    @GetMapping("/members")
    @PreAuthorize("hasRole('client_USER')")
    public List<Member> findAll() {
        List<Member> members = memberService.findAll();

        if (members.isEmpty()) {
            throw new MemberNotFoundException("Inga medlemmar hittades.");
        }
        return members;
    }

    @PutMapping("/members/{id}")
    @PreAuthorize("hasRole('client_USER')")
    public Member updateMember(@PathVariable int id, @RequestBody Member s){
        Member existingMember = memberService.findById(id);

        if (existingMember == null) {
            throw new MemberNotFoundException("Medlem med ID: " + id + " kunde ej hittas.");
        }
        s.setMemberId(id);
        Member updatedMember = memberService.save(s);
        return updatedMember;
    }
    @ExceptionHandler
    public ResponseEntity<MemberError> exceptionHandler(MemberNotFoundException memberNotFoundException){
        MemberError error = new MemberError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(memberNotFoundException.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<MemberError>exceptionHandler(Exception exception){
        MemberError error = new MemberError();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Du har glömt att mata in eller angivit fel värde");
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}