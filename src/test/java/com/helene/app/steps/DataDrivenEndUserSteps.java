package com.helene.app.steps;

import com.helene.app.pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class DataDrivenEndUserSteps extends ScenarioSteps {

	public DataDrivenEndUserSteps(Pages pages) {
		super(pages);
	}

    public String fruitName;
    public String description;



	@Step
	public void enters(String keyword) {
        onDictionaryPage().enter_keywords(keyword);
	}

    @Step
    public void starts_search() {
        onDictionaryPage().lookup_terms();
    }

    private DictionaryPage onDictionaryPage() {
        return getPages().currentPageAt(DictionaryPage.class);
    }

    private DictionaryPage DictionaryPage() {
        return getPages().currentPageAt(DictionaryPage.class);
    }

    @Step
	public void should_see_definition_containing_words(String terms) {
        assertThat(DictionaryPage().getDefinitions(), hasItem(containsString(terms)));
	}

    @Step
         public void is_the_home_page() {
        onDictionaryPage().open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @StepGroup
    public void searchAndValidate() {
        is_the_home_page();
        looks_for(fruitName);
        should_see_definition_containing_words(description);
    }
}
