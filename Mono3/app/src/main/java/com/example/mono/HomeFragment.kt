package com.example.mono

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var categoryRecyclerView: RecyclerView
    private lateinit var offerRecyclerView: RecyclerView
    private lateinit var nearbyRestaurantsRecyclerView: RecyclerView
    private lateinit var discountRecyclerView: RecyclerView

    private lateinit var categoryAdapter: FoodAdapter
    private lateinit var offerAdapter: OfferAdapter
    private lateinit var nearbyRestaurantsAdapter: RestaurantAdapter
    private lateinit var discountAdapter: DiscountAdapter

    private lateinit var categoryList: List<FoodItem>
    private lateinit var offerList: List<OfferItem>
    private lateinit var restaurantList: List<RestaurantItem>
    private lateinit var discountList: List<DiscountItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize RecyclerViews
        categoryRecyclerView = view.findViewById(R.id.category_recyclerView)
        offerRecyclerView = view.findViewById(R.id.offer_recyclerView)
        nearbyRestaurantsRecyclerView = view.findViewById(R.id.nearby_restaurants_recyclerView)
        discountRecyclerView = view.findViewById(R.id.discount_recyclerView)

        // Create sample data
        categoryList = listOf(
            FoodItem("Pizza", R.drawable.pizza),
            FoodItem("Burger", R.drawable.burger),
            FoodItem("Pasta", R.drawable.pasta),
            FoodItem("Sushi", R.drawable.sushi),
            FoodItem("Salad", R.drawable.salad)
        )
        offerList = listOf(
            OfferItem("50% Off", R.drawable.of1),
            OfferItem("Buy 1 Get 1 Free", R.drawable.of2),
            OfferItem("Free Delivery", R.drawable.of3),
            OfferItem("Buy 1 Get 1 Free", R.drawable.of4),
            OfferItem("50% Off", R.drawable.of1),
            OfferItem("Buy 1 Get 1 Free", R.drawable.of2),
            OfferItem("Free Delivery", R.drawable.of3),
            OfferItem("Buy 1 Get 1 Free", R.drawable.of4)
        )
        restaurantList = listOf(
            RestaurantItem("Pizza Hut", R.drawable.pizzahut),
            RestaurantItem("McDonald's", R.drawable.mc),
            RestaurantItem("Sushi World", R.drawable.sushi78),
            RestaurantItem("Goaldan Dragon", R.drawable.gd),
            RestaurantItem("Fat Mama's", R.drawable.ft),
            RestaurantItem("SH Family Restaurant", R.drawable.chi1),
            RestaurantItem("Air World", R.drawable.air)
        )
        discountList = listOf(
            DiscountItem("10% Off on Orders", R.drawable.of3),
            DiscountItem("20% Off on Burgers", R.drawable.of2),
            DiscountItem("Free Delivery on Orders", R.drawable.of1),
            DiscountItem("20% Off on Burgers", R.drawable.of3),
            DiscountItem("Free Delivery on Orders", R.drawable.of1),
            DiscountItem("20% Off on Burgers", R.drawable.of4),
            DiscountItem("Free Delivery on Orders", R.drawable.of1)
        )

        // Set up RecyclerViews
        categoryRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        categoryAdapter = FoodAdapter(categoryList)
        categoryRecyclerView.adapter = categoryAdapter

        offerRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        offerAdapter = OfferAdapter(offerList)
        offerRecyclerView.adapter = offerAdapter

        nearbyRestaurantsRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        nearbyRestaurantsAdapter = RestaurantAdapter(restaurantList)
        nearbyRestaurantsRecyclerView.adapter = nearbyRestaurantsAdapter

        discountRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        discountAdapter = DiscountAdapter(discountList)
        discountRecyclerView.adapter = discountAdapter

        return view
    }


}
