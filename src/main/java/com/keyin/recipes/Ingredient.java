package com.keyin.recipes;

public class Ingredient {

    private String name;
    private Boolean isCommonAllergen;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCommonAllergen() {
        return isCommonAllergen;
    }

    public void setCommonAllergen(Boolean commonAllergen) {
        isCommonAllergen = commonAllergen;
    }
}
