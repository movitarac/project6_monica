
package com.racic.lib.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10
 * Generated source version: 2.2
 * 
 */
@WebService(name = "sessionWs", targetNamespace = "http://webservice.lib.racic.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SessionWs {


    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "init", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.Init")
    @ResponseWrapper(localName = "initResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.InitResponse")
    @Action(input = "http://webservice.lib.racic.com/sessionWs/initRequest", output = "http://webservice.lib.racic.com/sessionWs/initResponse")
    public void init();

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkSessionWithSession", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.CheckSessionWithSession")
    @ResponseWrapper(localName = "checkSessionWithSessionResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.CheckSessionWithSessionResponse")
    @Action(input = "http://webservice.lib.racic.com/sessionWs/checkSessionWithSessionRequest", output = "http://webservice.lib.racic.com/sessionWs/checkSessionWithSessionResponse")
    public boolean checkSessionWithSession(
            @WebParam(name = "arg0", targetNamespace = "")
                    Integer arg0);

    /**
     *
     * @return
     *     returns java.util.List<com.racic.lib.client.Session>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllSession", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.GetAllSession")
    @ResponseWrapper(localName = "getAllSessionResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.GetAllSessionResponse")
    @Action(input = "http://webservice.lib.racic.com/sessionWs/getAllSessionRequest", output = "http://webservice.lib.racic.com/sessionWs/getAllSessionResponse")
    public List<Session> getAllSession();

    /**
     *
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "checkSession", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.CheckSession")
    @ResponseWrapper(localName = "checkSessionResponse", targetNamespace = "http://webservice.lib.racic.com/", className = "com.racic.lib.client.CheckSessionResponse")
    @Action(input = "http://webservice.lib.racic.com/sessionWs/checkSessionRequest", output = "http://webservice.lib.racic.com/sessionWs/checkSessionResponse")
    public boolean checkSession(
            @WebParam(name = "arg0", targetNamespace = "")
                    Member arg0);

}
