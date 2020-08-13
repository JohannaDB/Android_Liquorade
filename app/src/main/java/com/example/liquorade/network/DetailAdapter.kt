package com.example.liquorade.network

import com.example.liquorade.domain.CocktailDetail
import com.example.liquorade.domain.CocktailDetails
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson
import java.lang.UnsupportedOperationException

class DetailAdapter {

    @Annotation
    @FromJson
            /**
             * Converts the received JSON to a CocktailDetail object where the ingredients are mapped
             *
             * @param jsonString The JSON received from the back-end
             * @return New CocktailDetail
             */
    fun fromJson(jsonString: CocktailDetails): CocktailDetail {
        val map = mutableMapOf<String?, String?>()
        val drinks = jsonString.drinks[0]
        map[drinks.strIngredient1] = drinks.strMeasure1
        map[drinks.strIngredient2] = drinks.strMeasure2
        map[drinks.strIngredient3] = drinks.strMeasure3
        map[drinks.strIngredient4] = drinks.strMeasure4
        map[drinks.strIngredient5] = drinks.strMeasure5
        map[drinks.strIngredient6] = drinks.strMeasure6
        map[drinks.strIngredient7] = drinks.strMeasure7
        map[drinks.strIngredient8] = drinks.strMeasure8
        map[drinks.strIngredient9] = drinks.strMeasure9
        map[drinks.strIngredient10] = drinks.strMeasure10
        map[drinks.strIngredient11] = drinks.strMeasure11
        map[drinks.strIngredient12] = drinks.strMeasure12
        map[drinks.strIngredient13] = drinks.strMeasure13
        map[drinks.strIngredient14] = drinks.strMeasure14
        map[drinks.strIngredient15] = drinks.strMeasure15
        val cocktailDetail = CocktailDetail(
            drinks.idDrink,
            drinks.strDrink,
            drinks.strDrinkThumb,
            drinks.strTags,
            drinks.strCategory,
            drinks.strAlcoholic,
            drinks.strGlass,
            drinks.strInstructions,
            map)
        return cocktailDetail
    }

    @ToJson
    fun toJson(@Annotation value: CocktailDetail): CocktailDetails {
        throw UnsupportedOperationException()
    }
}

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class Annotation
