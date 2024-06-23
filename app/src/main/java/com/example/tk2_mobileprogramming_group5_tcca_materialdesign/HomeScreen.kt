package com.example.tk2_mobileprogramming_group5_tcca_materialdesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Box(modifier = Modifier.height(200.dp),
            contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.bunny1),
                contentDescription = "Bunny in Plant Pot",
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text("Bunny in Plant Pot", style = TextStyle(color = Color.Black
                    , fontSize = 16.sp))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier.height(200.dp),
            contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.bunny2),
                contentDescription = "Cute Baby Bunny",
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text("Cute Baby Bunny", style = TextStyle(color = Color.Black
                    , fontSize = 16.sp))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier.height(200.dp),
            contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.bunny3),
                contentDescription = "Bunny Eating Carrot",
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text("Bunny Eating Carrot", style = TextStyle(color = Color.Black
                    , fontSize = 16.sp))
            }
        }
    }
}






