package de.syntax_institut.cmp.demo.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Meal(
    @PrimaryKey(autoGenerate = false)
    val idMeal: String = "",
    val strMeal: String = "",
    val strMealAlternate: String? = null,
    val strCategory: String = "",
    val strArea: String = "",
    val strInstructions: String = "",
    val strMealThumb: String = "",
    val strTags: String? = null,
    val strYoutube: String = "",
    val strIngredient1: String = "",
    val strIngredient2: String = "",
    val strIngredient3: String = "",
    val strIngredient4: String = "",
    val strIngredient5: String = "",
    val strIngredient6: String = "",
    val strIngredient7: String = "",
    val strIngredient8: String = "",
    val strIngredient9: String? = "",
    val strIngredient10: String? = "",
    val strIngredient11: String? = "",
    val strIngredient12: String? = "",
    val strIngredient13: String? = "",
    val strIngredient14: String? = "",
    val strIngredient15: String? = "",
    val strIngredient16: String? = "",
    val strIngredient17: String? = "",
    val strIngredient18: String? = "",
    val strIngredient19: String? = "",
    val strIngredient20: String? = "",
    val strMeasure1: String = "",
    val strMeasure2: String = "",
    val strMeasure3: String = "",
    val strMeasure4: String = "",
    val strMeasure5: String = "",
    val strMeasure6: String = "",
    val strMeasure7: String = "",
    val strMeasure8: String = "",
    val strMeasure9: String = "",
    val strMeasure10: String? = "",
    val strMeasure11: String? = "",
    val strMeasure12: String? = "",
    val strMeasure13: String? = "",
    val strMeasure14: String? = "",
    val strMeasure15: String? = "",
    val strMeasure16: String? = "",
    val strMeasure17: String? = "",
    val strMeasure18: String? = "",
    val strMeasure19: String? = "",
    val strMeasure20: String? = "",
    val strSource: String = "",
    val strImageSource: String? = null,
    val strCreativeCommonsConfirmed: String? = null
) {
    companion object {
        val previewMeal = Meal(
            strMeal = "Moussaka",
            strCategory = "Beef",
            strArea = "Greek",
            strInstructions = "Heat the grill to high. Brown the beef in a deep ovenproof frying pan over a high heat for 5 mins. Meanwhile, prick the aubergine with a fork, then microwave on High for 3-5 mins until soft. Mix the yogurt, egg and parmesan together, then add a little seasoning.\r\n\r\nStir the tomatoes, purée and potatoes in with the beef with some seasoning and heat through. Smooth the surface of the beef mixture with the back of a spoon, then slice the cooked aubergine and arrange on top. Pour the yogurt mixture over the aubergines, smooth out evenly, then grill until the topping has set and turned golden.",
            strMealThumb = "https://www.themealdb.com/images/media/meals/ctg8jd1585563097.jpg",
            strYoutube = "https://www.youtube.com/watch?v=8U_29i9Qp5U",
            strIngredient1 = "Beef",
            strIngredient2 = "Aubergine",
            strIngredient3 = "Greek Yogurt",
            strIngredient4 = "Egg",
            strIngredient5 = "Parmesan",
            strIngredient6 = "Tomato",
            strIngredient7 = "Tomato Puree",
            strIngredient8 = "Potatoes",
            strMeasure1 = "500g",
            strMeasure2 = "1 large",
            strMeasure3 = "150g",
            strMeasure4 = "1 beaten",
            strMeasure5 = "3 tbs",
            strMeasure6 = "400g",
            strMeasure7 = "4 tbs",
            strMeasure8 = "350g",
            strSource = "https://www.bbcgoodfood.com/recipes/must-make-moussaka"
        )
    }
}