package com.example.cowin

import android.content.Context
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.AbstractList



class session(
    val availabilitydate:String,
    val availabilitycapacity:String,
    val minagelimit:String){}

class metadata(
    val nameofcenter:String,
    val address:String,
     val district_name:String,
     val state_name:String,
     val fee_type:String,
     val sessionlist:List<session>

     ){}


class pincodeactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var pincode=findViewById<TextView>(R.id.textviewpincode)


        var sharedPreferences=getSharedPreferences("mypref", Context.MODE_PRIVATE)


        pincode.setText(sharedPreferences.getString("pincode","nahi aya"))
        apicall()

         var t =findViewById<TextView>(R.id.databox)
        t.movementMethod = ScrollingMovementMethod()

        var editor=sharedPreferences.edit()
        setContentView(R.layout.activity_pincodeactivity)
        editor.clear()
        editor.apply()
    }


    private  fun apicall(){
        var rawurl="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?pincode=250001&date=07-05-2021"
        var pincodestr="pincode="+ "250001"
        var datestr="&date="
        val date = Calendar.getInstance().time
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val formatedDate = sdf.format(date)
        datestr+=formatedDate
        var url="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin?"+pincodestr+datestr

        val queue = Volley.newRequestQueue(this)
        // Request a string response from the provided URL.
        val jsonObjectRequest= JsonObjectRequest(
                Request.Method.GET, url, null,
                { response ->

                    Log.d("workinghai", url)
                    Log.d("workinghai", response.toString())



                }, {
            // textView.text = "That didn't work!"

            Log.d("not workinghai", it.networkResponse.toString())


        })

            // Add the request to the RequestQueue.

             queue.add(jsonObjectRequest)



    }
}