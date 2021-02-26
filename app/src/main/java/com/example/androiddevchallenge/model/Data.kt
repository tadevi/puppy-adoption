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
package com.example.androiddevchallenge.model

import com.example.androiddevchallenge.R

val puppies by lazy {
    listOf(
        PuppyModel(1, "Pastel", 2f, "Male", "New York", R.drawable.puppy_1),
        PuppyModel(2, "Raka", 1f, "Male", "California", R.drawable.puppy_2),
        PuppyModel(3, "Jhony", 2.5f, "Female", "Washington", R.drawable.puppy_3),
        PuppyModel(4, "Bella", 1.2f, "Male", "Los Angeles", R.drawable.puppy_4),
        PuppyModel(5, "Max", 3f, "Female", "Chicago", R.drawable.puppy_5),
        PuppyModel(6, "Charlie", 1f, "Male", "Houston", R.drawable.puppy_6),
        PuppyModel(7, "Cooper", 1.5f, "Male", "New York", R.drawable.puppy_7),
        PuppyModel(8, "Buddy", 2f, "Female", "Texas", R.drawable.puppy_8),
        PuppyModel(9, "Jack", 2.3f, "Female", "New York", R.drawable.puppy_9),
        PuppyModel(10, "Rocky", 2.5f, "Female", "California", R.drawable.puppy_10),
        PuppyModel(11, "Duke", 3f, "Male", "Chicago", R.drawable.puppy_11),
        PuppyModel(12, "Bea", 1f, "Female", "Illinois", R.drawable.puppy_12),
    )
}
