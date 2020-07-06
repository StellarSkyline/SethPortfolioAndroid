package com.example.sethportfolio.data.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sethportfolio.R
import com.example.sethportfolio.data.model.Graphics
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_row_graphics.view.*

class AdapterGraphics(var mContext: Context):RecyclerView.Adapter<AdapterGraphics.ViewHolder>() {

    var mList:ArrayList<Graphics> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.adapter_row_graphics, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = mList[position]
        holder.bindView(item)
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        fun bindView(item:Graphics) {
            itemView.text_view_title.text = item.title

            Picasso.get()
                .load(item.image)
                .placeholder(R.drawable.img_loading)
                .into(itemView.image_view_graphics)

        }

    }
    fun setData(list:ArrayList<Graphics>) {
        mList = list
        notifyDataSetChanged()
    }
}