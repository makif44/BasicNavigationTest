package com.cbt.titleVerification;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class TitleVerification {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        ArrayList<String> urls = new ArrayList<String>( Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login"));
        driver.get(urls.get(0));
        String title1= driver.getTitle();
        String url1=driver.getCurrentUrl();
        BrowserUtils.wait(2);
        driver.get(urls.get(1));
        String title2=driver.getTitle();
        String url2=driver.getCurrentUrl();
        BrowserUtils.wait(2);
        driver.get(urls.get(2));
        String title3=driver.getTitle();
        String url3=driver.getCurrentUrl();
        BrowserUtils.wait(2);

        if(title1.equals(title2)&&title1.equals(title3)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        if(url1.startsWith("http://practice.cybertekschool.com")&&url2.startsWith("http://practice.cybertekschool.com")
                &&url3.startsWith("http://practice.cybertekschool.com")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        driver.close();
    }
}
