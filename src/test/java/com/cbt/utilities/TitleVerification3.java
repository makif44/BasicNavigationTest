package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class TitleVerification3 {
    
    public static void main(String[] args) {
        ArrayList<String> urls = new ArrayList<>(Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/",
                "https://walmart.com", "https://westelm.com/"));
        for (String each : urls) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(each);
            String title1 = driver.getTitle();
            System.out.println(title1);
            title1 = title1.replace(" ", "").toLowerCase();
            if (driver.getCurrentUrl().toLowerCase().contains(title1)) {
                System.out.println("passed");
            } else {
                System.out.println("Failed");
            }
            driver.close();

        }
    }
}
