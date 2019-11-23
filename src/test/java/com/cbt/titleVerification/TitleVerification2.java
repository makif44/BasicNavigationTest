package com.cbt.titleVerification;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class TitleVerification2 {
    public static void main(String[] args) {
        ArrayList<String> urls = new ArrayList< >(Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/",
                "https://walmart.com", "https://westelm.com/"));
        WebDriver driver= BrowserFactory.getDriver("chrome");
        driver.get(urls.get(0));
        String title1=driver.getTitle();
        System.out.println(title1);
        title1=title1.replace(" ","").toLowerCase();
        if(driver.getCurrentUrl().toLowerCase().contains(title1)){
            System.out.println("passed");
        }else{
            System.out.println("Failed");
        }

        driver.get(urls.get(1));
        String title2=driver.getTitle();
        System.out.println(title2);
        title2=title2.replace(" ","").toLowerCase();
        if(driver.getCurrentUrl().toLowerCase().contains(title2)){
            System.out.println("passed");
        }else{
            System.out.println("Failed");
        }

        driver.get(urls.get(2));
        String title3=driver.getTitle();
        System.out.println(title3);
        title3=title3.replace(" ","").toLowerCase();
        if(driver.getCurrentUrl().toLowerCase().contains(title3)){
            System.out.println("passed");
        }else{
            System.out.println("Failed");
        }
        driver.close();

    }
}
