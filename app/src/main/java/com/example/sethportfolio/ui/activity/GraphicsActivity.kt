package com.example.sethportfolio.ui.activity

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sethportfolio.R
import com.example.sethportfolio.data.model.Graphics
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_graphics.*

class GraphicsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graphics)

        var item = intent.getSerializableExtra("data") as Graphics

        Picasso.get()
            .load(item.image)
            .placeholder(R.drawable.img_loading)
            .into(image_view_graphics_detail)

        text_view_title.text = item.title
        text_view_description.text = item.description

        when(item.tool) {
            "PS" -> {image_view_tool.setImageResource(R.drawable.ic_img_ps)}
            "AI" -> {image_view_tool.setImageResource(R.drawable.ic_img_ai)}
        }

        button_back.setOnClickListener {
            finish()
        }
    }
}