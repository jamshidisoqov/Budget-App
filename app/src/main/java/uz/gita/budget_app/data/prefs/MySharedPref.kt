package uz.gita.budget_app.data.prefs

import android.content.Context
import android.content.SharedPreferences
import uz.gita.budget_app.utils.SharedPreference
import javax.inject.Inject

// Created by Jamshid Isoqov an 10/14/2022
class MySharedPref @Inject constructor(
    private val ctx: Context,
    private val sharedPreferences: SharedPreferences
) : SharedPreference(ctx, sharedPreferences) {

    var isRegister: Boolean by Booleans(init = false)

    var appIsDarkMode: Boolean by Booleans(init = false)

    var password: String by Strings()

    var reminder: String by Strings("09:00")

    var currencyId: Int by Ints(defValue = 1)

}