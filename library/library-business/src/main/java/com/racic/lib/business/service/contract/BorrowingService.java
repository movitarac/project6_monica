package com.racic.lib.business.service.contract;

import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BorrowingService {

    boolean verifyBoksListAvailableSize(Integer worksid);

    boolean borrowBook(Integer worksId, Member member);

    boolean borrowBook(Integer worksId, Member member, Integer sessionId);

    boolean returnBorrowing(Integer borrowingid, Member member);

    boolean returnBorrowing(Integer borrowingid, Member member, Integer sessionId);

    boolean extendBorrowing (Integer borrowingId, Member member);

    boolean extendBorrowing (Integer borrowingId, Member member, Integer sessionId);

    List<Borrowing> getNotReturnedBorrowing(Date today);

    List<Borrowing> findByMember(Member member);

    Borrowing findByBorrowingId(Integer borrowingid);

    boolean launchSendEmail();
}
