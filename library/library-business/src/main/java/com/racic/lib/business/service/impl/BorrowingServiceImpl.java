package com.racic.lib.business.service.impl;

import com.racic.lib.business.service.Util.Utils;
import com.racic.lib.business.service.contract.BookService;
import com.racic.lib.business.service.contract.BorrowingService;
import com.racic.lib.business.service.contract.SessionService;
import com.racic.lib.business.service.exception.BorrowFunctionalException;
import com.racic.lib.business.service.exception.ExtendFunctionnalException;
import com.racic.lib.business.service.exception.SessionException;
import com.racic.lib.consumer.repository.BookRepository;
import com.racic.lib.consumer.repository.BorrowingRepository;
import com.racic.lib.consumer.repository.WorkRepository;
import com.racic.lib.model.Book;
import com.racic.lib.model.Borrowing;
import com.racic.lib.model.Member;

import com.racic.lib.model.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Service("borrowingService")
public class BorrowingServiceImpl implements BorrowingService {


    @Autowired
    BorrowingRepository borrowingRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    WorkRepository workRepository;
    @Autowired
    BookService bookService;
    @Autowired
    SessionService sessionService;


    @Override
    public boolean borrowBook(Integer worksId, Member member) {
        boolean toReturn;

        Work workWithToBeBorrowed = workRepository.findById(worksId).get();
        //make a book list from the given id work (only available books)
        List<Book> booksAvailable = bookService.findAvailableBooksFromWork(worksId);

        Borrowing borrowToBeAdded = new Borrowing();
        boolean checkSession = sessionService.checkSession(member);
        /**
         * if a session  is still valid (not false)
         * set new session time out
         */

        if (checkSession = true) {


            /**
             * if a booksavailable list isn't null
             * set new borrowing
             */
            if (booksAvailable.size() > 0) {
                borrowToBeAdded.setMember(member);

                //set Issue Date
                Date issueDate = new Date();

                borrowToBeAdded.setIssueDate(issueDate);
                //calculate the return date
                Date returnDate = issueDate;

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(returnDate);
                calendar.add(Calendar.WEEK_OF_MONTH, 4);
                returnDate = calendar.getTime();

                borrowToBeAdded.setReturnDate(returnDate);

                borrowToBeAdded.setStatus(Utils.BorrowStatusEnum.ONGOING.getValue());
                borrowToBeAdded.setExtended(false);

                //the latest book on the available list will be borrowed
                Book bookToBeAdded = booksAvailable.get(booksAvailable.size() - 1);
                borrowToBeAdded.setBook(bookToBeAdded);

                //save the borrowing
                borrowingRepository.save(borrowToBeAdded);

                //change the availability of this book and the borrowing
                bookToBeAdded.setAvailable(false);
                bookToBeAdded.setBorrowing(borrowToBeAdded);

                System.out.println(bookToBeAdded.getBookId() + " is "
                        + bookToBeAdded.isAvailable());
                //update and save the modification for book in database
                bookRepository.save(bookToBeAdded);

                //remove the borrowed book from the list of available books
                booksAvailable.remove(bookToBeAdded);

                //update the total of available copy for the related work
                workWithToBeBorrowed.setCopiesAvailable(booksAvailable.size());

                //save the modification
                workRepository.save(workWithToBeBorrowed);

                System.out.println("book " + bookToBeAdded.getBookId() + " is succesfully borrowed by "
                        + member.getFirstName());
            } else {
                try {
                    throw new BorrowFunctionalException("Problem! Cannot borrow " + workWithToBeBorrowed.getTitle() + "!");
                } catch (BorrowFunctionalException e) {
                    e.printStackTrace();
                    System.out.println("problem occured");
                }

            }
        } else {
            try {
                throw new SessionException("Session is not valid");
            } catch (SessionException e) {
                e.printStackTrace();
            }
        }


        toReturn = true;
        return toReturn;
    }

    @Override
    public boolean borrowBook(Integer worksId, Member member, Integer sessionId) {
        //find a work by given id
        Work workWithToBeBorrowed = workRepository.findById(worksId).get();

        //make a book list from the same work (only available books)
        List<Book> booksAvailable = bookService.findAvailableBooksFromWork(worksId);
        //boolean for return
        boolean toReturn;
        //call method check session by given id //initiate SecurityService
        //SecurityService securityService = new SecurityService();
        //securityService;
        boolean checkSession = sessionService.checkSession(sessionId);
        Borrowing borrowToBeAdded = new Borrowing();
        //set Issue Date
        //calculate the return date
        Date issueDate = new Date();
        Date returnDate = issueDate;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(returnDate);
        /**
         * if a session  is still valid (not false)
         * set new session time out
         */

        if (checkSession = true) {


            /**
             * if a booksavailable list isn't null
             * set new borrowing
             */
            if (booksAvailable.size() > 0) {
                borrowToBeAdded.setMember(member);
                borrowToBeAdded.setExtended(false);

                calendar.add(Calendar.WEEK_OF_MONTH, 4);
                returnDate = calendar.getTime();
                borrowToBeAdded.setIssueDate(issueDate);

                borrowToBeAdded.setStatus(Utils.BorrowStatusEnum.ONGOING.getValue());
                borrowToBeAdded.setReturnDate(returnDate);

                //the latest book on the available list will be borrowed
                Book bookToBeAdded = booksAvailable.get(booksAvailable.size() - 1);
                //change the availability of this book and the borrowing
                borrowToBeAdded.setBook(bookToBeAdded);
                bookToBeAdded.setAvailable(false);
                bookToBeAdded.setBorrowing(borrowToBeAdded);
                //save the borrowing
                borrowingRepository.save(borrowToBeAdded);
                //update and save the modification for book in database
                bookRepository.save(bookToBeAdded);

                //remove the borrowed book from the list of available books
                booksAvailable.remove(bookToBeAdded);

                System.out.println(bookToBeAdded.getBookId() + " is "
                        + bookToBeAdded.isAvailable());

                 //update the total of available copy for the related work
                workWithToBeBorrowed.setCopiesAvailable(booksAvailable.size());

                //save the modification
                workRepository.save(workWithToBeBorrowed);

                System.out.println("book " + bookToBeAdded.getBookId() + " is succesfully borrowed by "
                        + member.getFirstName());
            } else {
                try {
                    throw new BorrowFunctionalException("Problem! Cannot borrow " + workWithToBeBorrowed.getTitle() + "!");
                } catch (BorrowFunctionalException e) {
                    e.printStackTrace();
                    System.out.println("problem occured");
                }
            }
        } else {
            try {
                throw new SessionException("Session is not valid");
            } catch (SessionException e) {
                e.printStackTrace();
            }
        }
        toReturn = true;
        return toReturn;
    }


    @Override
    public boolean returnBorrowing(Integer borrowingid, Member member) {
        boolean returnOk;

        Borrowing borrowingToBeReturned = borrowingRepository.findById(borrowingid).get();

        boolean checkSession = sessionService.checkSession(member);

        /**
         * if a session  is still valid (not false)
         * set new session time out
         */

        if (checkSession = true) {

            if (borrowingToBeReturned.getStatus().equals(Utils.BorrowStatusEnum.ONGOING.getValue())
                    || borrowingToBeReturned.getStatus().equals(Utils.BorrowStatusEnum.EXTENDED.getValue())) {
                //change the status
                borrowingToBeReturned.setStatus(Utils.BorrowStatusEnum.RETURNED.getValue());
                Book bookToBeReturned = borrowingToBeReturned.getBook();

                //modify the book availability and the borrowing id
                bookToBeReturned.setAvailable(true);
                bookToBeReturned.setBorrowing(null);

                //save the modification for book and borrowing
                bookRepository.save(bookToBeReturned);
                borrowingRepository.save(borrowingToBeReturned);

                //update the copies available
                Work bookFromWorkToBeReturned = bookToBeReturned.getWork();
                List<Book> availableBooks = bookService.findAvailableBooksFromWork(bookFromWorkToBeReturned.getWorksId());

                bookFromWorkToBeReturned.setCopiesAvailable(availableBooks.size());
                workRepository.save(bookFromWorkToBeReturned);


                System.out.println(bookToBeReturned.getBookId() + " is being returned");

            } else {
                try {
                    throw new SessionException("Session is not valid");
                } catch (SessionException e) {
                    e.printStackTrace();
                }
            }
            returnOk = true;
        } else {

            System.out.println("Book has been already returned");
            returnOk = false;
        }

        return returnOk;
    }

    @Override
    public boolean returnBorrowing(Integer borrowingid, Member member, Integer sessionId) {
        boolean returnOk;

        Borrowing borrowingToBeReturned = borrowingRepository.findById(borrowingid).get();

        boolean checkSession = sessionService.checkSession(sessionId);

        /**
         * if a session  is still valid (not false)
         * set new session time out
         */

        if (checkSession = true) {

            if (borrowingToBeReturned.getStatus().equals(Utils.BorrowStatusEnum.ONGOING.getValue())
                    || borrowingToBeReturned.getStatus().equals(Utils.BorrowStatusEnum.EXTENDED.getValue())) {
                //change the status
                borrowingToBeReturned.setStatus(Utils.BorrowStatusEnum.RETURNED.getValue());
                Book bookToBeReturned = borrowingToBeReturned.getBook();

                //modify the book availability and the borrowing id
                bookToBeReturned.setAvailable(true);
                bookToBeReturned.setBorrowing(null);

                //save the modification for book and borrowing
                bookRepository.save(bookToBeReturned);
                borrowingRepository.save(borrowingToBeReturned);

                //update the copies available
                Work bookFromWorkToBeReturned = bookToBeReturned.getWork();
                List<Book> availableBooks = bookService.findAvailableBooksFromWork(bookFromWorkToBeReturned.getWorksId());

                bookFromWorkToBeReturned.setCopiesAvailable(availableBooks.size());
                workRepository.save(bookFromWorkToBeReturned);


                System.out.println(bookToBeReturned.getBookId() + " is being returned");

            } else {
                try {
                    throw new SessionException("Session is not valid");
                } catch (SessionException e) {
                    e.printStackTrace();
                }
            }
            returnOk = true;
        } else {

            System.out.println("Book has been already returned");
            returnOk = false;
        }

        return returnOk;
    }

    public boolean extendBorrowing(Integer borrowingId, Member member) {
        boolean toreturn;
        Borrowing borrowingtoBeExtended = borrowingRepository.findById(borrowingId).get();

        Date returnDate = borrowingtoBeExtended.getReturnDate();
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(returnDate);
        calendar.add(Calendar.WEEK_OF_MONTH, 4);
        returnDate = calendar.getTime();
        boolean checkSession = sessionService.checkSession(member);
        /**
         * if a session  is still valid (not false)
         * set new session time out
         */
        if (checkSession = true) {
            /**
             * if a booksavailable list isn't null
             * set new borrowing
             */
            System.out.println("session is valid = " + checkSession + " before if");

            if (!borrowingtoBeExtended.isExtended() && today.before(borrowingtoBeExtended.getReturnDate())) {

                System.out.println("new date : " + returnDate + " we are in method extend borrowing");

                borrowingtoBeExtended.setReturnDate(returnDate);
                borrowingtoBeExtended.setExtended(true);
                borrowingtoBeExtended.setStatus(Utils.BorrowStatusEnum.EXTENDED.getValue());

                borrowingRepository.save(borrowingtoBeExtended);

                toreturn = true;
            } else if (borrowingtoBeExtended.isExtended()) {
                try {
                    throw new ExtendFunctionnalException("the book is already extended, the member cannot extend twice");
                } catch (ExtendFunctionnalException e) {
                    e.printStackTrace();
                }
                System.out.println("cannot extend the borrowing because it has been already extended - an exception is thrown");
                toreturn = false;
            } else {
                try {
                    throw new ExtendFunctionnalException("Cannot extend the borrowing, the loan period is already passed");
                } catch (ExtendFunctionnalException e) {
                    e.printStackTrace();
                }
                toreturn = false;
                System.out.println("cannot extend the borrowing because of the loan period - an exception is thrown");
            }
            System.out.println(returnDate + " we are at the end of the method extend borrowing");
        } else {
            try {
                throw new SessionException("Session is not valid");
            } catch (SessionException e) {
                e.printStackTrace();
            }
            toreturn = true;
        }




        return toreturn;
    }

    @Override
    public boolean extendBorrowing(Integer borrowingId, Member member, Integer sessionId) {

        Borrowing borrowingtoBeExtended = borrowingRepository.findById(borrowingId).get();
        boolean toreturn;
        Date returnDate = borrowingtoBeExtended.getReturnDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(returnDate);
        calendar.add(Calendar.WEEK_OF_MONTH, 4);
        returnDate = calendar.getTime();
        Date today = new Date();


        boolean checkSession = sessionService.checkSession(sessionId);

        /**
         * if a session  is still valid (not false)
         * set new session time out
         */

        if (checkSession = true) {

            /**
             * if a booksavailable list isn't null
             * set new borrowing
             */
            System.out.println("session is valid = " + checkSession);

            if (!borrowingtoBeExtended.isExtended() && today.before(borrowingtoBeExtended.getReturnDate())) {

                System.out.println("new date : " + returnDate + " we are in method extend borrowing");

                borrowingtoBeExtended.setReturnDate(returnDate);
                borrowingtoBeExtended.setStatus(Utils.BorrowStatusEnum.EXTENDED.getValue());
                borrowingtoBeExtended.setExtended(true);
                borrowingRepository.save(borrowingtoBeExtended);

                toreturn = true;
            } else if (borrowingtoBeExtended.isExtended()) {
                try {
                    throw new ExtendFunctionnalException("the book is already extended, the member cannot extend twice");
                } catch (ExtendFunctionnalException e) {
                    e.printStackTrace();
                }
                System.out.println("cannot extend the borrowing because it has been already extended- an exception is thrown");
                toreturn = false;
            } else {
                try {
                    throw new ExtendFunctionnalException("Cannot extend the borrowing, the loan period is already passed");
                } catch (ExtendFunctionnalException e) {
                    e.printStackTrace();
                }
                toreturn = false;
                System.out.println("cannot extend the borrowing because of the loan period- an exception is thrown");
            }
            System.out.println(returnDate + " we are in method extend borrowing");


        } else {
            try {
                throw new SessionException("Session is not valid");
            } catch (SessionException e) {
                e.printStackTrace();
            }
            toreturn = true;
        }




        return toreturn;
    }

    @Override
    public boolean verifyBoksListAvailableSize(Integer worksid) {
        boolean toReturn;
        List<Book> availableBooks = bookService.findAvailableBooksFromWork(worksid);

        if (availableBooks.size() > 0) {
            System.out.println(availableBooks.size());
            toReturn = true;
        } else {
            System.out.println("the size of this list is 0");
            toReturn = false;
        }

        return toReturn;
    }


    @Override
    public List<Borrowing> getNotReturnedBorrowing(Date today) {
        List<Borrowing> borrowList = borrowingRepository.findAllByReturnDateBefore(today);

        return borrowList;
    }



    @Override
    public List<Borrowing> findByMember(Member member) {



        List<Borrowing> borrowingList = new ArrayList<>();
        boolean sessionValid = sessionService.checkSession(member);
        if (sessionValid = true) {
            borrowingList = borrowingRepository.findByMember(member);
            System.out.println("session is valid = " + sessionValid);

        } else {
            try {
                throw new SessionException("Session is not valid");
            } catch (SessionException e) {
                e.printStackTrace();
            }
            borrowingList = null;
        }
        return borrowingList;
    }

    @Override
    public Borrowing findByBorrowingId(Integer borrowingid) {
        return borrowingRepository.findById(borrowingid).get();
    }


    public boolean launchSendEmail() {
        boolean sendOk;
        String username = "stherblain.library@gmail.com";
        String password = "ABC12345BATCHSt.HerBlain";

        /*SMPT Server configuration*/
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Date today = new Date();
        List<Borrowing> borrowList = borrowingRepository.findAllByReturnDateBefore(today);


        if (borrowList.size() > 0) {
            for (Borrowing borrow : borrowList) {
                if (today.after(borrow.getReturnDate())) {
                    System.out.println(borrow.getMember().getFirstName() + " " + borrow.getBook().getWork().getTitle());
                    Session session = Session.getInstance(props,
                            new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                                }
                            });

                    try {

                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress("stherblain.library@gmail.com"));

                        message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse(borrow.getMember().getEmail()));

                        message.setSubject("---Returning Book--City Library---");
                        message.setText(" Dear " + borrow.getMember().getFirstName() + " ,"
                                + "\n\n you haven't returned your loan for " +
                                borrow.getBook().getWork().getTitle() +
                                " . Please return it as soon as possible because you have exceed your period loan "
                                + borrow.getReturnDate());

                        Transport.send(message);

                        System.out.println("Sent to " + borrow.getMember().getEmail() +
                                " related to their loan " + borrow.getBook().getWork().getTitle());

                        sendOk = true;
                    } catch (MessagingException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    System.out.println("PROBLEM!!!!");
                    sendOk = false;
                }

            }
        } else {
            System.out.println("PROBLEM!!!!");
        }
        sendOk = true;
        return sendOk;
    }


}