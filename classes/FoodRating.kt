package leetcode.classes

import java.util.*

/**
 * https://leetcode.com/problems/design-a-food-rating-system/
 */

private class FoodRatings(
    foods: Array<String>,
    cuisines: Array<String>,
    ratings: IntArray)
{
    private val foodToCuisineMap: Map<String, String> =
        foods.zip(cuisines).toMap()

    private val foodToRatingMap: MutableMap<String, Int> =
        foods.zip(ratings.toList()).toMap().toMutableMap()

    private val cuisineToRatingMap: Map<String, SortedSet<Pair<Int, String>>> = buildMap {
        val pairComparator = compareByDescending<Pair<Int, String>> { it.first }
            .thenComparing(compareBy { it.second })

        for (i in foods.indices) {
            val cuisine = cuisines[i]
            val rating = ratings[i]
            getOrPut(cuisine) { sortedSetOf(pairComparator) } += rating to foods[i]
        }
    }

    fun changeRating(food: String, newRating: Int) {
        foodToRatingMap[food]?.let { oldRating ->
            foodToRatingMap[food] = newRating

            foodToCuisineMap[food]?.let { cuisine ->
                cuisineToRatingMap[cuisine]?.let { cuisineRatings ->
                    cuisineRatings -= oldRating to food
                    cuisineRatings += newRating to food
                }
            }
        }
    }

    fun highestRated(cuisine: String): String {
        val highestRated = cuisineToRatingMap[cuisine]?.firstOrNull()?.second
        return highestRated ?: "No ratings yet"
    }
}
