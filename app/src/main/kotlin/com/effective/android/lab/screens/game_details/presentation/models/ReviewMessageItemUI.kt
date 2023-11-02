package com.effective.android.lab.screens.game_details.presentation.models

import androidx.annotation.StringRes

class ReviewMessageItemUI(
    val user: UserItemUI,
    val date: Long,
    @StringRes val review: Int,
)