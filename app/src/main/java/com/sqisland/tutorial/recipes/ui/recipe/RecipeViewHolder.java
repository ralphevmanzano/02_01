package com.sqisland.tutorial.recipes.ui.recipe;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class RecipeViewHolder extends RecyclerView.ViewHolder {

    public TextView tv;

    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = (TextView) itemView;
    }
}
