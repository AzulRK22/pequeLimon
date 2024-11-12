package com.example.pequelemon

import androidx.annotation.DrawableRes

object DishRepository {
    val dishes = listOf(
        Dish(
            id = 1,
            name = "Greek Salad",
            description = "The famous greek salad of crispy lettuce, peppers, olives, our Chicago.",
            price = 12.99,
            imageResource = R.drawable.greeksalad,
            category = DishCategory.Entradas
        ),
        Dish(
            id = 2,
            name = "Lemon Dessert",
            description = "Traditional homemade Italian Lemon Ricotta Cake.",
            price = 8.99,
            imageResource = R.drawable.lemondessert,
            category = DishCategory.Postres
        ),
        Dish(
            id = 3,
            name = "Bruschetta",
            description = "Our Bruschetta is made from grilled bread that has been smeared with garlic and seasoned with salt and olive oil.",
            price = 4.99,
            imageResource = R.drawable.bruschetta,
            category = DishCategory.Entradas
        ),
        Dish(
            id = 4,
            name = "Grilled Fish",
            description = "Fish marinated in fresh orange and lemon juice. Grilled with orange and lemon wedges.",
            price = 19.99,
            imageResource = R.drawable.grilledfish,
            category = DishCategory.Platos
        ),
        Dish(
            id = 5,
            name = "Pasta",
            description = "Penne with fried aubergines, cherry tomatoes, tomato sauce, fresh chilli, garlic, basil & salted ricotta cheese.",
            price = 8.99,
            imageResource = R.drawable.pasta,
            category = DishCategory.Platos
        ),
        Dish(
            id = 6,
            name = "Lasagne",
            description = "Oven-baked layers of pasta stuffed with Bolognese sauce, béchamel sauce, ham, Parmesan & mozzarella cheese.",
            price = 7.99,
            imageResource = R.drawable.lasagne,
            category = DishCategory.Platos
        ),
        Dish(
            id = 7,
            name = "Red Wine",
            description = "A glass of premium red wine from Italian vineyards.",
            price = 6.99,
            imageResource = R.drawable.redwine,
            category = DishCategory.Bebidas
        ),
        Dish(
            id = 8,
            name = "Orange Juice",
            description = "Freshly squeezed orange juice.",
            price = 3.99,
            imageResource = R.drawable.orangejuice,
            category = DishCategory.Bebidas
        )
    )

    fun getDish(id: Int) = dishes.firstOrNull { it.id == id }
}

data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    @DrawableRes val imageResource: Int,
    val category: DishCategory
)
enum class DishCategory(val displayName: String) {
    All("All"),
    Entradas("Entradas"),
    Platos("Platos"),
    Postres("Postres"),
    Bebidas("Bebidas")
}