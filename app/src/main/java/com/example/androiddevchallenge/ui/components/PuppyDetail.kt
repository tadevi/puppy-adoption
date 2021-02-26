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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.PuppyModel
import com.example.androiddevchallenge.model.puppies
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.purple700

@Composable
fun PuppyDetail(data: PuppyModel) {
    LazyColumn {
        item {
            ConstraintLayout(
                modifier = Modifier
                    .background(Color.White)
                    .padding(bottom = 8.dp)
                    .fillMaxSize()
            ) {
                val (avatar, card, description, button) = createRefs()
                Image(
                    modifier = Modifier
                        .constrainAs(avatar) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    contentScale = ContentScale.Crop,
                    bitmap = ImageBitmap.imageResource(data.imgResource),
                    contentDescription = null
                )

                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .constrainAs(card) {
                            top.linkTo(avatar.bottom)
                            bottom.linkTo(avatar.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth(0.8f)
                ) {
                    Column(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 12.dp),
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            text = data.name,
                            fontSize = 20.sp,
                            color = purple700,
                            textAlign = TextAlign.Center
                        )

                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "${data.years} years old",
                            color = Color.DarkGray,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = data.gender,
                            color = Color.DarkGray,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = data.address,
                            color = Color.DarkGray,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Text(
                    modifier = Modifier
                        .constrainAs(description) {
                            top.linkTo(card.bottom, margin = 8.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .padding(start = 12.dp, end = 12.dp)
                        .fillMaxWidth(),
                    text = stringResource(R.string.txt_lorem),
                    color = Color.DarkGray,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify
                )

                Button(
                    onClick = {},
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .background(purple200)
                        .constrainAs(button) {
                            top.linkTo(description.bottom, margin = 16.dp)
                            end.linkTo(parent.end)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                ) {
                    Text(text = "Adoption")
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview_() {
    PuppyDetail(data = puppies.first())
}
