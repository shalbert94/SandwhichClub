package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwichInstance = new Sandwich();

        try {
            JSONObject sandwichDetails = new JSONObject(json);

            JSONObject name = sandwichDetails.getJSONObject("name");
            String mainName = name.getString("mainName");
            sandwichInstance.setMainName(mainName);

            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            if (alsoKnownAs.length() > 0 || alsoKnownAs != null) {
                List<String> alsoKnownAsList = new ArrayList<>();
                for(int i = 0; i < alsoKnownAs.length(); i++) alsoKnownAsList.add(alsoKnownAs.getString(i));
                sandwichInstance.setAlsoKnownAs(alsoKnownAsList);
            }

            String placeOfOrigin = sandwichDetails.getString("placeOfOrigin");
            sandwichInstance.setPlaceOfOrigin(placeOfOrigin);

            String description = sandwichDetails.getString("description");
            sandwichInstance.setDescription(description);

            String image = sandwichDetails.getString("image");
            sandwichInstance.setImage(image);

            JSONArray ingredients = sandwichDetails.getJSONArray("ingredients");
            if (ingredients.length() > 0 || ingredients != null) {
                List<String> ingredientsList = new ArrayList<>();
                for (int i = 0; i < ingredients.length(); i++) ingredientsList.add(ingredients.getString(i));
                sandwichInstance.setIngredients(ingredientsList);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sandwichInstance;
    }

}
