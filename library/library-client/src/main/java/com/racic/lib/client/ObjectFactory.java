
package com.racic.lib.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.racic.lib.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllSession_QNAME = new QName("http://webservice.lib.racic.com/", "getAllSession");
    private final static QName _Init_QNAME = new QName("http://webservice.lib.racic.com/", "init");
    private final static QName _CheckSessionWithSessionResponse_QNAME = new QName("http://webservice.lib.racic.com/", "checkSessionWithSessionResponse");
    private final static QName _InitResponse_QNAME = new QName("http://webservice.lib.racic.com/", "initResponse");
    private final static QName _CheckSessionWithSession_QNAME = new QName("http://webservice.lib.racic.com/", "checkSessionWithSession");
    private final static QName _CheckSession_QNAME = new QName("http://webservice.lib.racic.com/", "checkSession");
    private final static QName _GetAllSessionResponse_QNAME = new QName("http://webservice.lib.racic.com/", "getAllSessionResponse");
    private final static QName _CheckSessionResponse_QNAME = new QName("http://webservice.lib.racic.com/", "checkSessionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.racic.lib.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllSession }
     * 
     */
    public GetAllSession createGetAllSession() {
        return new GetAllSession();
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link CheckSessionWithSessionResponse }
     * 
     */
    public CheckSessionWithSessionResponse createCheckSessionWithSessionResponse() {
        return new CheckSessionWithSessionResponse();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link CheckSessionWithSession }
     * 
     */
    public CheckSessionWithSession createCheckSessionWithSession() {
        return new CheckSessionWithSession();
    }

    /**
     * Create an instance of {@link CheckSession }
     * 
     */
    public CheckSession createCheckSession() {
        return new CheckSession();
    }

    /**
     * Create an instance of {@link GetAllSessionResponse }
     * 
     */
    public GetAllSessionResponse createGetAllSessionResponse() {
        return new GetAllSessionResponse();
    }

    /**
     * Create an instance of {@link CheckSessionResponse }
     * 
     */
    public CheckSessionResponse createCheckSessionResponse() {
        return new CheckSessionResponse();
    }

    /**
     * Create an instance of {@link Session }
     * 
     */
    public Session createSession() {
        return new Session();
    }

    /**
     * Create an instance of {@link Member }
     * 
     */
    public Member createMember() {
        return new Member();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Timestamp }
     * 
     */
    public Timestamp createTimestamp() {
        return new Timestamp();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "getAllSession")
    public JAXBElement<GetAllSession> createGetAllSession(GetAllSession value) {
        return new JAXBElement<GetAllSession>(_GetAllSession_QNAME, GetAllSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Init }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "init")
    public JAXBElement<Init> createInit(Init value) {
        return new JAXBElement<Init>(_Init_QNAME, Init.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionWithSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "checkSessionWithSessionResponse")
    public JAXBElement<CheckSessionWithSessionResponse> createCheckSessionWithSessionResponse(CheckSessionWithSessionResponse value) {
        return new JAXBElement<CheckSessionWithSessionResponse>(_CheckSessionWithSessionResponse_QNAME, CheckSessionWithSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "initResponse")
    public JAXBElement<InitResponse> createInitResponse(InitResponse value) {
        return new JAXBElement<InitResponse>(_InitResponse_QNAME, InitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionWithSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "checkSessionWithSession")
    public JAXBElement<CheckSessionWithSession> createCheckSessionWithSession(CheckSessionWithSession value) {
        return new JAXBElement<CheckSessionWithSession>(_CheckSessionWithSession_QNAME, CheckSessionWithSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSession }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "checkSession")
    public JAXBElement<CheckSession> createCheckSession(CheckSession value) {
        return new JAXBElement<CheckSession>(_CheckSession_QNAME, CheckSession.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "getAllSessionResponse")
    public JAXBElement<GetAllSessionResponse> createGetAllSessionResponse(GetAllSessionResponse value) {
        return new JAXBElement<GetAllSessionResponse>(_GetAllSessionResponse_QNAME, GetAllSessionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckSessionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.lib.racic.com/", name = "checkSessionResponse")
    public JAXBElement<CheckSessionResponse> createCheckSessionResponse(CheckSessionResponse value) {
        return new JAXBElement<CheckSessionResponse>(_CheckSessionResponse_QNAME, CheckSessionResponse.class, null, value);
    }

}
