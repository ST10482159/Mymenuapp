package com.example.mymenuapp

import android.net.http.UrlRequest.Status
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mymenuapp.ui.theme.MyMenuAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var timeOfDay by remember {
                mutableStateOf("")
            }


            var mealSelected by remember {
                mutableStateOf("")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "My menu app",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Black


                )

                Divider()

                // time of day
                OutlinedTextField(
                    value = timeOfDay,
                    onValueChange = { text -> timeOfDay = text

                    },
                    placeholder = {
                        Text(text = "Enter time of the day")
                    }
                )
                Spacer(modifier = Modifier.size(30.dp))

                Row {
                    // suggest button
                    Button(onClick = {
                        mealSelected= when(timeOfDay){
                            "Morning" -> "Cereal"
                            "Mid-morning" -> "Fruit"
                             "Afternoon" -> "Sushi"
                              "Afternoon snack" -> "Yoghurt"
                              "Dinner" -> "Fried chicken"
                               "After dinner" -> "ice cream"


                            else -> {"invalid "}
                        }

                    }) {
                        Text(text = "SUGGEST")
                    }

                    // reset button
                    Button(onClick = { /*TODO*/

                     timeOfDay=""
                     mealSelected=""

                    }) {
                        Text(text = "RESET")

                    }

                }
                
                Text(text = mealSelected)

            }
        }

    }

}




