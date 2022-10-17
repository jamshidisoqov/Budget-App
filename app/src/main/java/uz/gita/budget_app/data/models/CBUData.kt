package uz.gita.budget_app.data.models

import com.google.gson.annotations.SerializedName
import uz.gita.budget_app.data.room.entity.CurrenciesEntity

// Created by Jamshid Isoqov an 10/17/2022

data class CBUData(
    @SerializedName("Ccy")
    val ccy: String,

    @SerializedName("CcyNm_EN")
    val ccyNm_EN: String,

    @SerializedName("CcyNm_RU")
    val ccyNm_RU: String,

    @SerializedName("CcyNm_UZ")
    val ccyNm_UZ: String,

    @SerializedName("CcyNm_UZC")
    val ccyNm_UZC: String,

    @SerializedName("Code")
    val code: String,

    @SerializedName("Date")
    val date: String,

    @SerializedName("Diff")
    val diff: String,

    @SerializedName("Nominal")
    val nominal: String,

    @SerializedName("Rate")
    val rate: String,
    val id: Int
)