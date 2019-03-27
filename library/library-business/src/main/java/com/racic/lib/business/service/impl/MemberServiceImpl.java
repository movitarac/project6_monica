package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.contract.MemberService;
import com.racic.lib.business.service.contract.SessionService;
import com.racic.lib.consumer.repository.MemberRepository;
import com.racic.lib.consumer.repository.UserRepository;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import com.racic.lib.model.Session;
import com.racic.lib.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	SessionService sessionService;

    public List<Member> findAll() {
    	return memberRepository.findAll();
    }


    public Member findMemberByEmail (String email) {
    	return memberRepository.findByEmail(email);
    }


	@Override
	public Member findByUsernameAndPassword(String username, String password){

    return memberRepository.findByUsernameAndPassword(username,password);
	}



	@Override
	public Integer isValidUser(String userName, String passWord) {

    	Integer sessionToBeReturned = 0;
		Member validMember = memberRepository.findByUsernameAndPassword(userName, passWord);

		Integer idSession;
		if (validMember !=null) {
			idSession = sessionService.createSession(validMember);

		} else{
			idSession = 0;
		}
		return idSession;
	}



	//private ne met pas dans le contract no override

	@Override
	public void updateMemberInfo(Member member) {

    	memberRepository.save(member);
	}


}
