package com.helene.app;

import com.helene.app.requirements.Application;
import com.helene.app.steps.DataDrivenEndUserSteps;
import com.helene.app.steps.EndUserSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import static net.thucydides.core.steps.StepData.withTestDataFrom;
import static org.junit.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: rahul
 * Date: 7/21/12
 * Time: 8:25 PM
 * To change this template use File | Settings | File Templates.
 */

@Story(Application.Search.SearchByKeyword.class)
@RunWith(ThucydidesRunner.class)
public class ParameterizedStepsTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://en.wiktionary.org/wiki/Wiktionary:Main_Page")
    public Pages pages;

    @Steps
    public DataDrivenEndUserSteps endUser;

    @Issue("#WIKI-1")
    @Test
    @Ignore
    public void looking_up_definitions_of_fruits_should_display_the_corresponding_article() throws Exception {
        endUser.is_the_home_page();
        withTestDataFrom("data.csv").separatedBy(';').run(endUser).searchAndValidate();

    }

    @Test
    public void randomlyFailingTest() {
        endUser.is_the_home_page();
         fail("I am going to fail");
    }


}
