package com.helene.app;

import com.helene.app.requirements.Application;
import com.helene.app.steps.EndUserSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: rahul
 * Date: 7/21/12
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value="data.csv", separator = ';')
public class ParameterizedCSVTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    private String fruitName;
    private String description;


    @Qualifier
    public String getQualifier() {
        return fruitName;
    }

    /*public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    } */

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Issue("#WIKI-1")
    @Test
    @Ignore
    public void looking_up_definitions_of_fruits_should_display_the_corresponding_article() {
        endUser.is_the_home_page();
        endUser.looks_for(fruitName);
        endUser.should_see_definition_containing_words(description);

    }

}
