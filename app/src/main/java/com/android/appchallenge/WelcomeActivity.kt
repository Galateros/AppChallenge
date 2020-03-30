package com.android.appchallenge

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.NetworkImageView
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : AppCompatActivity() {
    private val imageUrl = "https://www.empowering-project.eu/wp-content/uploads/2019/02/imagen-02_04-02_ok-1024x536.png"
    private val requestQueue by lazy{
        Volley.newRequestQueue(this)

    }


    private val TIME : Long = 8000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadImageUsingVolley()
        setContentView(R.layout.activity_welcome)
        Handler().postDelayed({startActivity(Intent(this, MainActivity::class.java))}, TIME)


    }
    private fun loadImageUsingVolley(){
val imageRequest = ImageRequest(
    imageUrl,
    Response.Listener {
        imageView.setImageBitmap(it)
    },
    imageView.layoutParams.width, imageView.layoutParams.height,
    ImageView.ScaleType.CENTER_CROP,
    Bitmap.Config.ARGB_8888,
    Response.ErrorListener {
        Toast.makeText(this,"Fail to Load",Toast.LENGTH_SHORT).show()
    }
)
        requestQueue.add(imageRequest)
    }
}
/*
* import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.Volley
*
* */
