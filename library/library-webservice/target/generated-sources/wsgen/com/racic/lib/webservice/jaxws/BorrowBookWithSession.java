
package com.racic.lib.webservice.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "borrowBookWithSession", namespace = "http://webservice.lib.racic.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "borrowBookWithSession", namespace = "http://webservice.lib.racic.com/", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class BorrowBookWithSession {

    @XmlElement(name = "arg0", namespace = "")
    private Integer arg0;
    @XmlElement(name = "arg1", namespace = "")
    private com.racic.lib.model.Member arg1;
    @XmlElement(name = "arg2", namespace = "")
    private Integer arg2;

    /**
     * 
     * @return
     *     returns Integer
     */
    public Integer getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(Integer arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns Member
     */
    public com.racic.lib.model.Member getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(com.racic.lib.model.Member arg1) {
        this.arg1 = arg1;
    }

    /**
     * 
     * @return
     *     returns Integer
     */
    public Integer getArg2() {
        return this.arg2;
    }

    /**
     * 
     * @param arg2
     *     the value for the arg2 property
     */
    public void setArg2(Integer arg2) {
        this.arg2 = arg2;
    }

}
