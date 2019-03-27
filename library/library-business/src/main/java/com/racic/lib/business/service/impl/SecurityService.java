package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.exception.SessionException;
import com.racic.lib.consumer.repository.SessionRepository;

import com.racic.lib.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@Service
public class SecurityService {

    @Autowired
    SessionRepository sessionRepository;

    //TODO problem with private method!!!! and during repository call
    //methode security
    //private -- not exposed as webmethod
    public boolean checkSession (Integer sessionId) {
        boolean toreturn;

           Session foundSession;
            Timestamp timeNow = new Timestamp(System.currentTimeMillis());
            Timestamp timeOut;
            Timestamp newTimeOut;
            Session sessionsFound =sessionRepository.findById(sessionId).get();

            int addtime = 60;


            if (sessionsFound !=null) {
                //TODO

                    timeOut = sessionsFound.getSessionTimeOut() ;
                    if (timeOut.after(timeNow)) {
                        Instant durationSession = timeOut.toInstant().plusSeconds(addtime);
                        newTimeOut = Timestamp.from(durationSession);
                        sessionsFound.setSessionTimeOut(newTimeOut);
                        sessionRepository.save(sessionsFound);
                    } else {
                        try {
                            throw new SessionException("problem with session.. this session is already expired");
                        } catch (SessionException e) {
                            e.printStackTrace();
                        }
                    }
                toreturn = true;


            } else {
                try {
                    throw new SessionException("problem with session.. no session is found");
                } catch (SessionException e) {
                    e.printStackTrace();
                }

                toreturn = false;
            }
            return toreturn;

    }
}
