package mx.tec.pizzeria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import mx.tec.pizzeria.Pizza.Adapter.PizzaAdapter
import mx.tec.pizzeria.Pizza.model.Pizza

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Data
        val pizzas = arrayListOf<Pizza>(
            Pizza("Crazy Crunch",150.00,
                arrayListOf<String>("Queso", "Pepperoni", "Orilla de Chicharron de Queso", "Parmesano"),R.drawable.crazycrunch),
            Pizza("Pepperoni Clásica", 119.50,
                arrayListOf<String>("Queso Mozzarella","Queso Muenster", "Pepperoni"),R.drawable.pepperoni),
            Pizza("3 Meat Treat",170.00,
                arrayListOf<String>("Queso Mozzarella","Queso Muenster", "Pepperoni","Salchicha Italiana","Tocino"),
                R.drawable.meattreat),
            Pizza("Ultimate Supreme",220.00,
                arrayListOf<String>("Queso Mozzarella","Queso Muenster", "Pepperoni","Cebolla","Champiñones","Salchicha Italiana","Pimientos Verdes"),
                R.drawable.ultimatesupreme),
            Pizza("Hula Hawaiian",160.00,arrayListOf<String>("Queso Mozzarella","Queso Muenster","Piña","Jamón"), R.drawable.hulahawaiian),
            Pizza("Queso",110.00,arrayListOf<String>("Queso Mozzarella","Queso Muenster"), R.drawable.queso)
        )
        // Adapter
        val adapter = PizzaAdapter(this@MainActivity,R.layout.pizza_layout,pizzas)
        // Assign
        listPizza.adapter= adapter

        listPizza.setOnItemClickListener { parent, view, position, id ->
            val intentInstance = Intent(this@MainActivity,  PizzaDescriptionActivity::class.java)
            intentInstance.putExtra("pizza", pizzas[position])
            startActivity(intentInstance)
        }
    }
}