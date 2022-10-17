package uz.gita.budget_app.data.api

import retrofit2.Response
import retrofit2.http.GET
import uz.gita.budget_app.data.models.CBUData

// Created by Jamshid Isoqov an 10/17/2022
interface CBUApi {
        @GET("arkhiv-kursov-valyut/json/")
    suspend fun getCurrency(): Response<List<CBUData>>
}