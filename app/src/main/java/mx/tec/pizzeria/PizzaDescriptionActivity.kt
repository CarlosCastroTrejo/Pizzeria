package mx.tec.pizzeria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pizza_description.*
import mx.tec.pizzeria.Pizza.model.Pizza

class PizzaDescriptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_description)

        var pizza = intent.getSerializableExtra("pizza") as Pizza

        val pizzaImg = findViewById<ImageView>(R.id.imagePizzaDescription)
        val txtPizzaName = findViewById<TextView>(R.id.txtPizzaNameDescription)
        val txtPizzaPrice = findViewById<TextView>(R.id.txtPizzaPriceDescription)

        txtPizzaName.text=pizza.name
        txtPizzaPrice.text="$ "+pizza.price.toString()+" "+getString(R.string.money)
        pizzaImg.setImageResource(pizza.image)

        val adapter = ArrayAdapter(this@PizzaDescriptionActivity,android.R.layout.simple_list_item_1,pizza.ingredients)
        // Assign
        listIngredients.adapter= adapter

    }
}