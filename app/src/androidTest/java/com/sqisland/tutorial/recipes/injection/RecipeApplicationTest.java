package com.sqisland.tutorial.recipes.injection;

import com.sqisland.tutorial.recipes.data.local.InMemoryFavorites;
import com.sqisland.tutorial.recipes.data.local.Favorites;

public class RecipeApplicationTest extends RecipeApplication {

    private final Favorites favorites = new InMemoryFavorites();

    @Override
    public Favorites getFavorites() {
        return favorites;
    }
}
