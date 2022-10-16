package uz.gita.budget_app.data.models

import android.os.Parcelable
import java.io.Serializable

// Created by Jamshid Isoqov an 10/14/2022
data class CalendarData(
    val date: Long,
    val isExpanses: Boolean = false,
    val isIncome: Boolean = false
): Serializable
