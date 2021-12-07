package com.customer.backend.project;

public class Log {
    public static void error(String error){
        System.out.println("**Error--> "+error);
    }
    public static void exception(String exception){
        System.out.println("**Exception--> "+exception);
    }
    public static void info(String info){
        System.out.println("**Info--> "+info);
    }
}
