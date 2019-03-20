package com.racic.lib.business.service.impl;


import com.racic.lib.business.service.contract.SessionService;

import com.racic.lib.business.service.exception.SessionException;
import com.racic.lib.consumer.repository.MemberRepository;
import com.racic.lib.consumer.repository.SessionRepository;
import com.racic.lib.consumer.repository.UserRepository;
import com.racic.lib.model.Member;
import com.racic.lib.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;


import java.time.Instant;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    //String timeStamp

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session findSessionById(Integer sessionId) {
        return sessionRepository.findById(sessionId).get();
    }


    //methode security
    //private -- not exposed as webmethod
    @Override
    public boolean findAndCheckSession(Member member) {
        boolean toreturn;
        Session foundSession;
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        Timestamp timeOut;
        Timestamp newTimeOut;
        List<Session> sessionsFoundForAMember = sessionRepository.findSessionsByMember(member);
        int addtime = 60;


        if (member != null) {
       //TODO
            for (Session s : sessionsFoundForAMember) {
                timeOut = s.getSessionTimeOut() ;
                if (timeOut.after(timeNow)) {
                    Instant durationSession = timeOut.toInstant().plusSeconds(addtime);
                    newTimeOut = Timestamp.from(durationSession);
                    s.setSessionTimeOut(newTimeOut);
                    sessionRepository.save(s);
                } else {
                    try {
                        throw new SessionException("problem with session.. no session is valid");
                    } catch (SessionException e) {
                        e.printStackTrace();
                    }
                }
            }

            toreturn = true;
        } else {
            this.createSession(member);
            toreturn = false;
        }
        return toreturn;


    }


    @Override
    public boolean createSession(Member member) {
        boolean creationOk;
        Session session = new Session();
        int limitSession = 60; //in second- so the time limit for one session is 1minute

        //define the beginning of the session with type timestamp
        Timestamp sessionStart = new Timestamp(System.currentTimeMillis());

        Instant durationSession = sessionStart.toInstant().plusSeconds(limitSession);
        Timestamp sessionEnd = Timestamp.from(durationSession);

        session.setMember(member);
        session.setSessionStart(sessionStart);
        session.setSessionTimeOut(sessionEnd);
        sessionRepository.save(session);

        creationOk = true;
        return creationOk;
    }

    @Override
    public List<Session> findSessionsByMember(Member member) {
        return sessionRepository.findSessionsByMember(member);
    }


}
