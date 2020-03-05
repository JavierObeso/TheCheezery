package obeso.javier.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_product.view.*

class ProductsActivity : AppCompatActivity() {

    var coldDrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
    }


    fun cargaColdDrinks() {
        coldDrinks.add(Product("Caramel Frap", R.drawable.caramel_frap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5))
        coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolate_frap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blenderbash.", 6))
        coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created bysteeping medium-to-coarse ground coffee in room temperature water for 12hours or longer.", 3))
        coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste ofmatcha green tea powder with creamy milk and a little sugar for a flavorbalance that will leave you feeling ready and raring to go.", 4))
        coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake,"Chocolate ice cream, and oreo cookies. Topped with whipped cream withcocoa and chocolate syrup.", 7))
        coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake,"Vanilla ice cream, mixed with peanut butter and chocolate.", 7))
    }

    private class productAdapter: BaseAdapter {

        var context: Context? = null
        var products = ArrayList<Product>()

        constructor(context: Context, products: ArrayList<Product>){
            this.context = context
            this.products = products
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var product = products[position]
            var inflator = LayoutInflater.from(context)
            var vista = inflator.inflate(R.layout.item_product, null)
            vista.product_image.setImageResource(product.image)
            vista.product_name.setText(product.name)
            vista.product_description.setText(product.description)
            vista.product_price.setText('$'+""+product.price+"")
            return vista
        }

        override fun getItemId(position: Int): Long {
            return 1
        }

        override fun getCount(): Int {
            return products.size
        }

        override fun getItem(position: Int): Any {
            return products[position]
        }
    }

}
