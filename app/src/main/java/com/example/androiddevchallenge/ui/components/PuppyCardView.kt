/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.PuppyModel
import com.example.androiddevchallenge.ui.theme.purple500
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun PuppyCardView(data: PuppyModel, onPress: (PuppyModel) -> Unit) {
    Card(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .clickable { onPress(data) },
        shape = shapes.medium,
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier.size(80.dp),
                shape = CircleShape
            ) {
                Image(
                    bitmap = ImageBitmap.imageResource(data.imgResource),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = null
                )
            }

            Column(
                modifier = Modifier
                    .padding(start = 32.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = data.name,
                    color = purple500,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                Text(
                    text = "${data.years} years old",
                    color = Color.DarkGray,
                    fontSize = 12.sp
                )
                Text(text = data.gender, color = Color.DarkGray, fontSize = 12.sp)
                Text(text = data.address, color = Color.DarkGray, fontSize = 12.sp)
            }
        }
    }
}

@Preview
@Composable
fun PreviewPuppyModel() {
    PuppyCardView(data = PuppyModel(1, "Pastel", 2f, "Male", "New York", R.drawable.puppy_1)) {
    }
}
