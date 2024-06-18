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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ingredient that = (Ingredient) obj;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
