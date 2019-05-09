package com.sqisland.tutorial.recipes.data.local;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFavorites  implements Favorites {

    private final Map<String, Boolean> map = new HashMap<>();

    @Override
    public boolean get(String id) {
        Boolean value = map.get(id);
        return value == null ? false : value;
    }

    @Override
    public boolean toggle(String id) {
        boolean favorite = get(id);
        put(id, !favorite);
        return !favorite;
    }

    public void put(String id, boolean value) {
        map.put(id, value);
    }

    public void clear() {
        map.clear();
    }
}
