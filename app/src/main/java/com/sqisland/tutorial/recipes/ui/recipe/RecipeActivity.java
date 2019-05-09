package com.sqisland.tutorial.recipes.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;
import com.sqisland.tutorial.recipes.injection.RecipeApplication;

public class RecipeActivity extends AppCompatActivity implements RecipeContract.View {

    public static final String KEY_ID = "id";
    private TextView txtTitle;
    private TextView txtDescription;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        txtTitle = findViewById(R.id.title);
        txtDescription = findViewById(R.id.description);

        RecipeStore store = new RecipeStore(this, "recipes");
        RecipeApplication app = (RecipeApplication) getApplication();
        final Favorites favorites = app.getFavorites();

        final RecipePresenter presenter = new RecipePresenter(store, this, favorites);
        String id = getIntent().getStringExtra(KEY_ID);
        presenter.loadRecipe(id);

        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.toggleFavorite();
            }
        });
    }

    @Override
    public void showRecipeNotFoundError() {
        txtTitle.setVisibility(View.GONE);
        txtDescription.setText(R.string.recipe_not_found);
    }

    @Override
    public void setTitle(String title) {
        txtTitle.setText(title);
    }

    @Override
    public void setDescription(String description) {
        txtDescription.setText(description);
    }

    @Override
    public void setFavorite(boolean favorite) {
        txtTitle.setSelected(favorite);
    }
}
