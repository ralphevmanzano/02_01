package com.sqisland.tutorial.recipes.test;
import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.InMemoryFavorites;
import com.sqisland.tutorial.recipes.injection.RecipeApplicationTest;
import com.sqisland.tutorial.recipes.ui.recipe.RecipeActivity;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

public class RecipeRobot extends ScreenRobot<RecipeRobot> {

    private final InMemoryFavorites favorites;

    public RecipeRobot() {
        RecipeApplicationTest app = (RecipeApplicationTest) InstrumentationRegistry.getTargetContext().getApplicationContext();
        favorites = (InMemoryFavorites) app.getFavorites();
        favorites.clear();
    }

    public RecipeRobot launch(ActivityTestRule rule) {
        rule.launchActivity(null);
        return this;
    }

    public RecipeRobot launchRecipe(ActivityTestRule rule, String id) {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, id);
        rule.launchActivity(intent);
        return this;
    }

    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.title);
    }

    public RecipeRobot description(@StringRes int stringId) {
        return checkViewHasText(R.id.description, stringId);
    }

    public RecipeRobot setFavorite(String id) {
        favorites.put(id, true);
        return this;
    }

    public RecipeRobot isFavorite() {
        return checkIsSelected(R.id.title);
    }
}
