package mx.tec.pizzeria.Pizza.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import mx.tec.pizzeria.Pizza.model.Pizza
import mx.tec.pizzeria.R

class PizzaAdapter(private val context: Context,
                   private val layout:Int,
                   private val dataSource: List<Pizza>): BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Decir como poner los nombre
        val view = inflater.inflate(layout, parent,false)
        val pizza = dataSource[position]


        // Hacer referencia  a los controles
        val pizzaImg = view.findViewById<ImageView>(R.id.imagePizza)
        val txtPizzaName = view.findViewById<TextView>(R.id.txtPizzaName)
        val txtPizzaPrice = view.findViewById<TextView>(R.id.txtPizzaPrice)

        txtPizzaName.text=pizza.name
        txtPizzaPrice.text="$ "+pizza.price.toString()+" "+context.getString(R.string.money)
        pizzaImg.setImageResource(pizza.image)

        return  view
    }

    override fun getItem(position: Int):Any{
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

}