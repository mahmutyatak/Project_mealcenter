package tests.US_004;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.userMealscenter.UserHomePage;
import utilities.*;

public class TC00402 extends TestBaseRapor{
    UserHomePage userHomePage;

    @Test(groups = "demo")
    public void facebookTest() {

        userHomePage = new UserHomePage();
        extentTest = extentReports.createTest("Footer bölümü 'facebook' sosyal medya butonu beklendiği şekilde çalışmalı");

        boolean facebookIconUrlTest = userHomePage.mealCenterFooterUrlTest(userHomePage.facebookButonu, "https://www.facebook.com/");
        extentTest.info("Footer bölümünden 'Facebook' butonuna tıklandı");
        Assert.assertTrue(facebookIconUrlTest);
        extentTest.pass("'Facebook' butonunun doğru çalıştığı test edildi");

    }

    @Test(groups = "demo")
    public void instagramTest() {
        userHomePage = new UserHomePage();
        extentTest = extentReports.createTest("Footer bölümü 'Instagram' sosyal medya butonu beklendiği şekilde çalışmalı");

        boolean instagramIconUrlTest = userHomePage.mealCenterFooterUrlTest(userHomePage.instagramButonu, "https://www.instagram.com/");
        extentTest.info("Footer bölününden 'Instagram' butonuna tıklandı");
        Assert.assertTrue(instagramIconUrlTest,"Instagram url testi Faıled");
        extentTest.pass("'Instagram' butonunun doğru çalıştığı test edildi");

    }

    @Test(groups = "demo")
    public void linkedinTest(){
        userHomePage = new UserHomePage();
        extentTest = extentReports.createTest("Footer bölümü 'Linkedin' sosyal medya butonu beklendiği şekilde çalışmalı");

        boolean linkedinUrlTest = userHomePage.mealCenterFooterUrlTest(userHomePage.linkedinButonu,"https://www.linkedin.com/");
        extentTest.info("Footer bölününden 'Linkedin' butonuna tıklandı");
        Assert.assertTrue(linkedinUrlTest);
        extentTest.pass("'Linkedin' butonunun doğru çalıştığı test edildi");

    }

    @Test(groups = "demo")
    public void twitterTest() {
        userHomePage = new UserHomePage();
        extentTest = extentReports.createTest("Footer bölümü 'Twitter' sosyal medya butonu beklendiği şekilde çalışmalı");

        boolean twitterUrlTest = userHomePage.mealCenterFooterUrlTest(userHomePage.twitterButonu,"https://twitter.com/");
        extentTest.info("Footer bölününden 'Twitter' butonuna tıklandı");
        Assert.assertTrue(twitterUrlTest);
        extentTest.pass("'Twitter' butonunun doğru çalıştığı test edildi");

    }

    @Test(groups = "demo")
    public void youtubeTest(){
        userHomePage = new UserHomePage();
        extentTest = extentReports.createTest("Footer bölümü 'Youtube' sosyal medya butonu beklendiği şekilde çalışmalı");

        boolean youtubeUrlTest = userHomePage.mealCenterFooterUrlTest(userHomePage.youtubeButonu,"https://www.youtube.com/");
        extentTest.info("Footer bölününden 'Youtube' butonuna tıklandı");
        Assert.assertTrue(youtubeUrlTest);
        extentTest.pass("'Youtube' butonunun doğru çalıştığı test edildi");

    }

    @Test(groups = "demo")
    public void appStoreTest(){
        userHomePage = new UserHomePage();
        extentTest = extentReports.createTest("Footer bölümü 'App Store' butonu beklendiği şekilde çalışmalı");

        boolean appStoreTest = userHomePage.mealCenterFooterUrlTest(userHomePage.appStoreButonu,"https://www.apple.com/tr/app-store/");
        extentTest.info("Footer bölününden 'App Store' butonuna tıklandı");
        Assert.assertTrue(appStoreTest);
        extentTest.pass("'App Store' butonunun doğru çalıştığı test edildi");

    }

    @Test(groups = "demo")
    public void googlePlayTest(){
        userHomePage = new UserHomePage();
        extentTest = extentReports.createTest("Footer bölümü 'Google Play' butonu beklendiği şekilde çalışmalı");

        boolean googlePlayTest = userHomePage.mealCenterFooterUrlTest(userHomePage.googlePlayButonu,"https://play.google.com/store/games?hl=tr&gl=US");
        extentTest.info("Footer bölününden 'Google Play' butonuna tıklandı");
        Assert.assertTrue(googlePlayTest);
        extentTest.pass("'Google Play' butonunun doğru çalıştığı test edildi");

    }
}
