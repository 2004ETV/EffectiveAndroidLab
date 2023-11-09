package com.effective.android.lab.screens.game_details.presentation.models

import androidx.annotation.StringRes
import java.util.Date

class ReviewMessageItemUI(
    val user: UserItemUI,
    val date: Date,
    @StringRes val review: Int,
)