package com.example.cowin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        var btn=findViewById<Button>(R.id.btnpincode)



        btn.setOnClickListener {
            val intent = Intent(this,pincodeactivity::class.java).apply {}
            val boxpincode=findViewById<TextView>(R.id.inputpincode)
            val txtpincode=boxpincode.text
            Log.d("workinghai",txtpincode.toString())

            var sharedPreferences: SharedPreferences.Editor =getSharedPreferences("mypref",Context.MODE_PRIVATE).edit()

            sharedPreferences.putString("pincode",txtpincode.toString())
            sharedPreferences.apply()

            startActivity(intent)


        }




    }

    private fun testapi(){
        val textView = findViewById<TextView>(R.id.title)
        val urlforstates = "https://cdn-api.co-vin.in/api/v2/admin/location/states"

        val url="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByDistrict?district_id=676&date=07-05-2021"
       // val string={"11001","31-03-2021"}
            val jsonObject=JSONObject()
            jsonObject.put("district_id",676)
            jsonObject.put("date","07-05-2021")

        // Instantiate the RequestQueue.
        Log.d("json",jsonObject.toString())
        val queue = Volley.newRequestQueue(this)

// Request a string response from the provided URL.
        val jsonObjectRequest=JsonObjectRequest(Request.Method.GET,url,null,
            { response ->

                Log.d("working", response.toString())

            },{
               // textView.text = "That didn't work!"

                Log.d("not working",it.networkResponse.toString())



                 })

// Add the request to the RequestQueue.

       queue.add(jsonObjectRequest)

    }





}