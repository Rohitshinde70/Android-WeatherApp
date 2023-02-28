package com.example.weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.weatherapp.R.id.cardView5
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var cardView1: CardView
    private lateinit var cardView2: CardView
    private lateinit var cardView3: CardView
    private lateinit var cardView4: CardView
    private lateinit var cardView5: CardView

    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textView7: TextView
    private lateinit var textView8: TextView
    private lateinit var textView9: TextView
    private lateinit var textView10: TextView
    private lateinit var textView11: TextView
    private lateinit var textView12: TextView
    private lateinit var textView13: TextView
    private lateinit var textView14: TextView
    private lateinit var textView15: TextView
    private lateinit var textView16: TextView

    //   private lateinit var searchView: SearchView
    //   private var lastQuery : String? = null

//var array1 = arrayOf<UserProfileResponse>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeGetApiRequest("Pune", textViewIds)
        makeGetApiRequest("New Delhi", textViewIds1)
        makeGetApiRequest(" Mumbai" , textViewIds2)
        makeGetApiRequest("Manali" ,textViewIds3)
        makeGetApiRequest("Kolkata" , textViewIds4)

        cardView1 = findViewById(R.id.cardView1)
        cardView2 = findViewById(R.id.cardView2)
        cardView3 = findViewById(R.id.cardView3)
        cardView4 = findViewById(R.id.cardView4)
        cardView5 = findViewById(R.id.cardView5)

        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        textView4 = findViewById(R.id.textView4)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView6)
        textView7 = findViewById(R.id.textView7)
        textView8 = findViewById(R.id.textView8)
        textView9 = findViewById(R.id.textView9)
        textView10 = findViewById(R.id.textView10)
        textView11 = findViewById(R.id.textView11)
        textView12 = findViewById(R.id.textView12)
        textView13 = findViewById(R.id.textView13)
        textView14 = findViewById(R.id.textView14)
        textView15 = findViewById(R.id.textView15)
        textView16 = findViewById(R.id.textView16)



        //    searchView = findViewById(R.id.searchView)

        /*   searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                lastQuery = query
               // makeGetApiRequest(query)
                searchView.setQuery(query, false)
                searchView.clearFocus()
                return true

            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return false
            }
        })

      */
        cardView1.setOnClickListener {
            val intent = Intent(this, City_weather_data::class.java)
            startActivity(intent)
        }
        cardView2.setOnClickListener{
            val intent1 = Intent(this , city2_weather_data::class.java)
            startActivity(intent1)
        }
        cardView3.setOnClickListener {
            val intent3 = Intent( this, city3_weather_data::class.java)
            startActivity(intent3)
        }
        cardView4.setOnClickListener {
            val intent4 = Intent(this , city4_weather_data::class.java)
            startActivity(intent4)
        }
        cardView5.setOnClickListener {
            val intent5 = Intent(this , city5_weather_data::class.java)
            startActivity(intent5)
        }

    }


    private val textViewIds = mapOf(
        "name" to (R.id.textView1),
        "temp" to (R.id.textView2),
        "condition" to (R.id.textView3),
        "forecast" to (R.id.textView4)
    )
    private val textViewIds1 = mapOf(
        "name" to (R.id.textView5),
        "temp" to (R.id.textView6),
        "condition" to (R.id.textView7),
        "forecast" to (R.id.textView8)
    )
    private val textViewIds2 = mapOf(
        "name" to (R.id.textView9),
        "temp" to (R.id.textView10),
        "condition" to (R.id.textView11),
        "forecast" to (R.id.textView12)
    )
    private val textViewIds3 = mapOf(
        "name" to (R.id.textView13),
        "temp" to (R.id.textView14),
        "condition" to (R.id.textView15),
        "forecast" to (R.id.textView16)
    )
    private val textViewIds4 = mapOf(
        "name" to (R.id.textView17),
        "temp" to (R.id.textView18),
        "condition" to (R.id.textView19),
        "forecast" to (R.id.textView20)
    )


    private fun makeGetApiRequest(city: String, textViewIds: Map<String, Int>) {
        //   val query = lastQuery?: "New Delhi"
        CoroutineScope(Dispatchers.IO).launch {
            var httpsURLConnection: HttpURLConnection? = null

            try {
                val url =
                    URL("https://api.weatherapi.com/v1/forecast.json?key=5121c3e648f046d09df45242231002&q=$city&days=1&aqi=no&alerts=no")

                httpsURLConnection = url.openConnection() as HttpURLConnection

                val code = httpsURLConnection?.responseCode

                if (code != 200) {
                    throw IOException("error from the server is $code")
                }

                val bufferedReader = BufferedReader(
                    InputStreamReader(httpsURLConnection.inputStream)
                )
                val jsonStringHolder: StringBuilder = StringBuilder()

                while (true) {

                    val readLine = bufferedReader.readLine() ?: break
                    jsonStringHolder.append(readLine)

                }
                val userProfileResponse =
                    Gson().fromJson(jsonStringHolder.toString(), UserProfileResponse::class.java)


                withContext(Dispatchers.Main) {

                   Log.d("MainActivity", "userProfileResponse = $userProfileResponse")

                    val textView1 = findViewById<TextView>(textViewIds["name"] ?: 0)
                    textView1.text = userProfileResponse.location.name

                    val textView2 = findViewById<TextView>(textViewIds["temp"] ?: 0)
                    textView2.text = "${userProfileResponse.current.temp_c}ºC"

                    val textView3 = findViewById<TextView>(textViewIds["condition"] ?: 0)
                    textView3.text = userProfileResponse.current.condition.text

                    val textView4 = findViewById<TextView>(textViewIds["forecast"] ?: 0)
                    val forecastText = "H : ${userProfileResponse.forecast.forecastday[0].day.maxtemp_c}ºC   L : ${userProfileResponse.forecast.forecastday[0].day.mintemp_c}ºC"
                    textView4.text = forecastText
                }
            } catch (e: IOException) {
                Log.e(this.javaClass.name, e.message.toString())
            } finally {
                httpsURLConnection?.disconnect()
            }
        }
    }

}


