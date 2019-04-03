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


    @Override
    public Integer createSession(Member member) {
        Integer sessionId = 0;
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

        return sessionId;
    }

    @Override
    public boolean checkSession(Member member) {
        boolean toreturn;

        Session foundSession;
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        Timestamp timeOut;
        Timestamp newTimeOut;
        List<Session> sessionsFound = sessionRepository.findSessionsByMember(member);

        Session lastSessionFromThisMember = sessionsFound.get(sessionsFound.size() - 1);
        int addtime = 60;


            if (lastSessionFromThisMember.getSessionTimeOut().after(timeNow) && lastSessionFromThisMember != null) {
                timeOut = lastSessionFromThisMember.getSessionTimeOut();
                Instant durationSession = timeOut.toInstant().plusSeconds(addtime);
                newTimeOut = Timestamp.from(durationSession);
                lastSessionFromThisMember.setSessionTimeOut(newTimeOut);
                sessionRepository.save(lastSessionFromThisMember);
                toreturn = true;
                System.out.println("list session not null and session is renewed");
            } else {
                try {
                    throw new SessionException("problem with session.. this session is already expired");
                } catch (SessionException e) {
                    e.printStackTrace();
                }
                toreturn = false;
                System.out.println("list session not null or session is expired");
            }




        return toreturn;

    }

    public boolean checkSession(Integer sessionId) {
        Session foundSession;
        boolean toreturn;

        int addtime = 60;

        Session sessionsFound = sessionRepository.findById(sessionId).get();
        Timestamp timeNow = new Timestamp(System.currentTimeMillis());
        Timestamp timeOut;
        Timestamp newTimeOut;


        timeOut = sessionsFound.getSessionTimeOut();

            if (timeOut.after(timeNow) && sessionsFound != null) {

                Instant durationSession = timeOut.toInstant().plusSeconds(addtime);

                newTimeOut = Timestamp.from(durationSession);

                sessionsFound.setSessionTimeOut(newTimeOut);

                sessionRepository.save(sessionsFound);
                System.out.println("session time out is renewed: " + sessionsFound.getSessionTimeOut());
                toreturn = true;
            } else {
                try {
                    throw new SessionException("problem with session.. this session is already expired");
                } catch (SessionException e) {
                    e.printStackTrace();
                }
                System.out.println("session time out is already passed: " + sessionsFound.getSessionTimeOut());

                toreturn = false;
            }



        return toreturn;

    }




}
