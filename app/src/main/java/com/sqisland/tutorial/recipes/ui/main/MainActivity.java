package com.sqisland.tutorial.recipes.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.ui.recipe.RecipeAdapter;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    RecyclerView rv = findViewById(R.id.rv);
    RecipeStore store = new RecipeStore(this, "recipes");
    RecipeAdapter adapter = new RecipeAdapter(store);

    rv.setAdapter(adapter);
    rv.setHasFixedSize(true);
    rv.setLayoutManager(new LinearLayoutManager(this));
  }
}