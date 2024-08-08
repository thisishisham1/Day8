package klivvr.test.day8.presentation.productListScreen

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import klivvr.test.day8.R
import klivvr.test.day8.presentation.models.ProductUiModel

class ProductAdapter(private var productList: List<ProductUiModel>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        val thumbnails: ImageView = itemView.findViewById(R.id.productImage)
        val productItem: View = itemView.findViewById(R.id.product_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.productName.text = product.title
        holder.productPrice.text = product.price.toString()
        Glide.with(holder.thumbnails.context)
            .load(product.thumbnail)
            .into(holder.thumbnails)
        holder.productItem.setOnClickListener {
            val action = ListProductFragmentDirections
                .actionListProductFragmentToHorizontalImageFragment(product.images!!.toTypedArray())
            it.findNavController().navigate(action)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<ProductUiModel>) {
        productList = list
        notifyDataSetChanged()
    }
}
