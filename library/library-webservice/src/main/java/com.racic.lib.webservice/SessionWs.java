package com.racic.lib.webservice;

import com.racic.lib.business.service.contract.SessionService;
import com.racic.lib.model.Member;
import com.racic.lib.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
@WebService(serviceName = "sessionWeb",name = "sessionWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SessionWs {

    @Autowired
    SessionService sessionService;


    @WebMethod
    public List<Session> getAllSession() {
        return sessionService.getAll();
    }


    @WebMethod
    public boolean checkSession (Member member) {
      return sessionService.checkSession(member);
    }

    @WebMethod
    public boolean checkSessionWithSession (Integer idSession) {
        return sessionService.checkSession(idSession);
    }


    @WebMethod
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }


}
