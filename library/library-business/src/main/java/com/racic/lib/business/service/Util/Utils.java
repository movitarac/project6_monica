package com.racic.lib.business.service.Util;

public class Utils {


    public enum BorrowStatusEnum{
        ONGOING("ongoing"),
        EXTENDED("extended"),
        RETURNED("returned");
        String value;
        //constructor of enum
        BorrowStatusEnum(String value){
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }

    }
    public enum SessionStatusEnum{
        VALID("valid"),
        INVALID("invalid");
        String value;
        //constructor of enum
        SessionStatusEnum(String value){
            this.value = value;
        }
        public String getValue() {
            return this.value;
        }

    }

}
