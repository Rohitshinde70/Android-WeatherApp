package com.example.weatherapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
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

class city2_weather_data : AppCompatActivity() {

    private lateinit var delhicity: TextView
    private lateinit var delhitemp: TextView
    private lateinit var delhitext: TextView
    private lateinit var delhitempHL: TextView
    private lateinit var T1 : TextView
    private lateinit var T2: TextView
    private lateinit var T3: TextView
    private lateinit var T4: TextView
    private lateinit var T5: TextView
    private lateinit var T6: TextView
    private lateinit var T7: TextView
    private lateinit var T8: TextView
    private lateinit var T9: TextView
    private lateinit var T10: TextView
    private lateinit var T11: TextView
    private lateinit var T12: TextView
    private lateinit var T13: TextView
    private lateinit var T14: TextView
    private lateinit var T15: TextView
    private lateinit var T16: TextView
    private lateinit var T17: TextView
    private lateinit var T18: TextView
    private lateinit var T19: TextView
    private lateinit var T20: TextView

    private lateinit var delhi_uv :TextView
    private lateinit var delhi_sunset :TextView
    private lateinit var delhi_sunrise :TextView
    private lateinit var delhi_wind :TextView
    private lateinit var delhi_preci :TextView
    private lateinit var delhi_feels :TextView
    private lateinit var delhi_humidity :TextView
    private lateinit var delhi_visibility :TextView
    private lateinit var delhi_pressure :TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city2_weather_data)


        delhicity = findViewById(R.id.delhicity)
        delhitemp = findViewById(R.id.delhitemp)
        delhitext = findViewById(R.id.delhitext)
        delhitempHL = findViewById(R.id.delhitempHL)



        makeGetApiRequest()

    }

    private fun makeGetApiRequest(){

        CoroutineScope(Dispatchers.IO).launch {
            var httpsURLConnection: HttpURLConnection? = null

            try {
                val url =
                    URL("https://api.weatherapi.com/v1/forecast.json?key=5121c3e648f046d09df45242231002&q=new delhi&days=1&aqi=no&alerts=no")

                httpsURLConnection = url.openConnection() as HttpURLConnection

                val code = httpsURLConnection?.responseCode

                if (code != 200) {
                    throw IOException("error from the server is $code")
                }

                val bufferedReader = BufferedReader(
                    InputStreamReader(httpsURLConnection.inputStream)
                )
                var jsonStringHolder: StringBuilder = StringBuilder()

                while (true) {

                    val readLine = bufferedReader.readLine() ?: break
                    jsonStringHolder.append(readLine)

                }
                val userProfileResponse =
                    Gson().fromJson(jsonStringHolder.toString(), UserProfileResponse::class.java)


                withContext(Dispatchers.Main) {


                   findViewById<TextView>(R.id.delhicity).apply {
                        text = userProfileResponse.location.name.let{
                            "${it}"
                        }
                    }
                    findViewById<TextView>(R.id.delhitemp).apply {
                        text = userProfileResponse.current.temp_c.let{
                            "${it}ºC"
                        }
                    }
                    findViewById<TextView>(R.id.delhitext).apply {
                        text = userProfileResponse.current.condition.text.let{
                            "${it}"
                        }
                    }

                    findViewById<TextView>(R.id.delhitempHL).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            " H : ${it[0].day.maxtemp_c}ºC   L : ${it[0].day.mintemp_c}ºC "
                        }
                    }
                    findViewById<TextView>(R.id.T1).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                        "${it[0].hour[0].time}"
                        }
                    }
                    findViewById<TextView>(R.id.T2).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[0].temp_c} ºC"
                        }
                    }
                    findViewById<TextView>(R.id.T3).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[1].time}"
                        }
                    }

                    findViewById<TextView>(R.id.T4).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[1].temp_c} ºC"
                        }
                    }
                    findViewById<TextView>(R.id.T5).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[2].time}"
                        }
                    }

                    findViewById<TextView>(R.id.T6).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[2].temp_c} ºC"
                        }
                    }
                    findViewById<TextView>(R.id.T7).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[3].time}"
                        }
                    }

                    findViewById<TextView>(R.id.T8).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[3].temp_c} ºC"
                        }
                    }
                    findViewById<TextView>(R.id.T9).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[4].time}"
                        }
                    }

                    findViewById<TextView>(R.id.T10).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[4].temp_c} ºC"
                        }
                    }
                    findViewById<TextView>(R.id.T11).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[5].time}"
                        }
                    }

                    findViewById<TextView>(R.id.T12).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[5].temp_c} ºC"
                        }
                    }
                    findViewById<TextView>(R.id.T13).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[6].time}"
                        }
                    }

                    findViewById<TextView>(R.id.T14).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[6].temp_c} ºC"
                        }
                    }
                    findViewById<TextView>(R.id.T15).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[7].time}"
                        }
                    }

                    findViewById<TextView>(R.id.T16).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[7].temp_c} ºC"
                        }
                    }
                    findViewById<TextView>(R.id.T17).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[8].time}"
                        }
                    }

                    findViewById<TextView>(R.id.T18).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[8].temp_c} ºC"
                        }
                    }
                    findViewById<TextView>(R.id.T19).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[9].time}"
                        }
                    }

                    findViewById<TextView>(R.id.T20).apply {
                        text = userProfileResponse.forecast.forecastday.let{
                            "${it[0].hour[9].temp_c} ºC"
                        }
                    }
                    findViewById<TextView>(R.id.delhi_uv).apply {
                        text = userProfileResponse.current.uv.let{
                            "${it}"
                        }
                    }
                    findViewById<TextView>(R.id.delhi_sunrise).apply {
                        text = userProfileResponse.forecast.forecastday[0].astro.sunrise.let{
                            "SUNRISE ${it}"
                        }
                    }
                    findViewById<TextView>(R.id.delhi_sunset).apply {
                        text = userProfileResponse.forecast.forecastday[0].astro.sunset.let{
                            "${it}"
                        }
                    }
                    findViewById<TextView>(R.id.delhi_wind).apply {
                        text = userProfileResponse.current.wind_kph.let{
                            "${it} kph"
                        }
                    }
                    findViewById<TextView>(R.id.delhi_preci).apply {
                        text = userProfileResponse.current.precip_mm.let{
                            "${it} mmm"
                        }
                    }
                    findViewById<TextView>(R.id.delhi_feels).apply {
                        text = userProfileResponse.current.feelslike_c.let{
                            "${it}"
                        }
                    }
                    findViewById<TextView>(R.id.delhi_humidity).apply {
                        text = userProfileResponse.current.humidity.let{
                            "${it}%"
                        }
                    }
                    findViewById<TextView>(R.id.delhi_visibility).apply {
                        text = userProfileResponse.current.vis_km.let{
                            "${it} Km"
                        }
                    }
                    findViewById<TextView>(R.id.delhi_pressure).apply {
                        text = userProfileResponse.current.pressure_mb.let{
                            "${it} hpa"
                        }
                    }




                    /* val textViewIds = findViewById<TextView>(textViewIds["time"] ?: 0)
                    textViewIds.text = userProfileResponse.forecast.forecastday[0].hour[0].time

                    val textViewIds = findViewById<TextView>(textViewIds["temp_c"] ?: 0)
                    textViewIds.text = userProfileResponse.forecast.forecastday[0].hour[0].temp_c.toString()
                    */

                }
            } catch (e :IOException){
                Log.e(this.javaClass.name, e.message.toString())
            }finally {
                httpsURLConnection?.disconnect()
            }
        }
    }


}
