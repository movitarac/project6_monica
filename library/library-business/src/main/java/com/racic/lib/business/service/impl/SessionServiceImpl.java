package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.Util.Utils;
import com.racic.lib.business.service.contract.SessionService;
import com.racic.lib.consumer.repository.SessionRepository;
import com.racic.lib.consumer.repository.UserRepository;
import com.racic.lib.model.Member;
import com.racic.lib.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {

    //String timeStamp

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session findSessionById(Integer sessionId) {
        return sessionRepository.findById(sessionId).get();
    }

    @Override
    public Session findSessionByMember(Member member) {
        return sessionRepository.findByMember(member);
    }


    @Override
    public boolean determineSession(Member member) {
        Session session = new Session();
        Date sessionTimeIn = new Date();
        boolean toreturn;
        session.setSessionTimeIN(sessionTimeIn);

        Date sessionTimeOut = sessionTimeIn;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sessionTimeOut);
        calendar.add(Calendar.MINUTE,30);
        sessionTimeOut = calendar.getTime();
        String sessionTimeOutString= new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(sessionTimeOut);

        session.setMember(member);
        session.setStatusSession(Utils.SessionStatusEnum.VALID.getValue());
        session.setSessionTimeIN(sessionTimeIn);
        session.setSessionTimeOut(sessionTimeOut);
        sessionRepository.save(session);
        toreturn = true;
        return toreturn;
    }

}
