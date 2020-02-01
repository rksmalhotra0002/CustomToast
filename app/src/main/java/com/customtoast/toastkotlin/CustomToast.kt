package com.customtoast.toastkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.customtoast.R
import com.customtoast.toastjava.MainActivity
import kotlinx.android.synthetic.main.activity_toast.view.*

class CustomToast : AppCompatActivity() {
private lateinit var  btn_simpletoast:Button
private lateinit var   btn_customtoast_android:Button
private lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_toast)

        getids()

    }
    private fun getids()
    {
        btn_simpletoast=findViewById(R.id.btn_simpletoast)
        btn_customtoast_android=findViewById(R.id.btn_customtoast_android)
        setlistener()
    }

    private fun setlistener()
    {
        btn_simpletoast.setOnClickListener {

            Toast.makeText(this,R.string.simple_toast,Toast.LENGTH_LONG).show()

        }
        btn_customtoast_android.setOnClickListener {
            val inflater=layoutInflater
            view=inflater.inflate(R.layout.toast_layout,findViewById(R.id.toast_root))
             val  toast=Toast(this)
            val text:TextView=view.findViewById(R.id.tv_simpletext)
            val imageView:ImageView=view.findViewById(R.id.iv_image)
            text.text=String.format("this is a custom toast")
            imageView.setImageResource(R.drawable.ic_toastimage)
            toast.view=view
            toast.duration=Toast.LENGTH_LONG
            toast.setGravity(Gravity.CENTER,0,330)
            toast.show()
        }
    }
}


