package com.racic.lib.webservice;


import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

@Service
@WebService(serviceName = "borrowingWeb",name = "borrowingWs")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
//@SOAPBinding(style = SOAPBinding.Style.RPC)
public class BorrowingWs{

    @Autowired
    BorrowingService borrowingService;

    @WebMethod
    public boolean borrowBook(Integer worksId, Member member) {
        return borrowingService.borrowBook(worksId, member);
    }

    @WebMethod
    public boolean borrowBookWithSession(Integer worksId, Member member,Integer sessionId) {
        return borrowingService.borrowBook(worksId, member,sessionId);
    }

    @WebMethod
    public boolean returnBorrowing(Integer borrowingid, Member member) {
        return borrowingService.returnBorrowing(borrowingid, member);
    }

    @WebMethod
    public boolean returnBorrowingWithSession(Integer borrowingid, Member member,Integer sessionId) {
        return borrowingService.returnBorrowing(borrowingid, member, sessionId);
    }

    @WebMethod
    public boolean extendBorrowing(Integer borrowingId, Member member) {
        return borrowingService.extendBorrowing(borrowingId, member);
    }

    @WebMethod
    public boolean extendBorrowingWithSession(Integer borrowingId, Member member,Integer sessionId) {
        return borrowingService.extendBorrowing(borrowingId, member,sessionId);
    }

    @WebMethod
    public boolean verifyBoksListAvailableSize(Integer worksid) {
        return borrowingService.verifyBoksListAvailableSize(worksid);
    }

    @WebMethod
    public List<Borrowing> getNotReturnedBorrowing(Date today) {
        return borrowingService.getNotReturnedBorrowing(today);
    }

    @WebMethod
    public List<Borrowing> findByMember(Member member) {
        return borrowingService.findByMember(member);
    }

    @WebMethod
    public Borrowing findByBorrowingId(Integer borrowingid) {
        return borrowingService.findByBorrowingId(borrowingid);
    }

    @WebMethod
    public boolean launchSendEmail(){

       return borrowingService.launchSendEmail();
    }

    @WebMethod
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
}
