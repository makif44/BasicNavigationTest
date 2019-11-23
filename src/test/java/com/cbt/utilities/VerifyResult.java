package com.cbt.utilities;

public class VerifyResult {

    public static void verifyEquals(String expected, String actual ){
        if(expected.equalsIgnoreCase(actual)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expected result is: "+expected);
            System.out.println("actual result is: "+actual);
        }

    }
    public static void verifyEquals(int expected, int actual ){
        if(expected==actual){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expected result is: "+expected);
            System.out.println("actual result is: "+actual);
        }

    }

}
