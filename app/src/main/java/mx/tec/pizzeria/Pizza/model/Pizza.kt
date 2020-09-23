package mx.tec.pizzeria.Pizza.model

import java.io.Serializable

data class Pizza(val name:String, val price:Double,val ingredients:ArrayList<String>,val image:Int): Serializable {
}

