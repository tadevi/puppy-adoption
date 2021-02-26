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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.model.PuppyModel
import com.example.androiddevchallenge.model.puppies
import com.example.androiddevchallenge.ui.components.PuppyCardView
import com.example.androiddevchallenge.ui.components.PuppyDetail
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            MyTheme {
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomePage(data = puppies, navController = navController)
                    }

                    composable(
                        "detail/{puppyId}",
                        arguments = listOf(
                            navArgument("puppyId") {
                                type = NavType.IntType
                            }
                        )
                    ) {
                        PuppyDetail(
                            data = puppies.first { puppy ->
                                puppy.id == it.arguments!!.getInt(
                                    "puppyId"
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun HomePage(data: List<PuppyModel>, navController: NavController) {
    Column {
        TopAppBar(title = { Text(text = "Puppy Adoption") })
        Surface(color = MaterialTheme.colors.background) {
            LazyColumn {
                items(data) {
                    PuppyCardView(data = it) { puppy ->
                        navController.navigate("detail/${puppy.id}")
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        HomePage(puppies, rememberNavController())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HomePage(puppies, rememberNavController())
    }
}
