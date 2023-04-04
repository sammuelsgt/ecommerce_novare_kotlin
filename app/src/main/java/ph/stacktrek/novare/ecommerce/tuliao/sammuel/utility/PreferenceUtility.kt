package ph.stacktrek.novare.ecommerce.tuliao.sammuel.utility

import android.content.Context
import android.content.SharedPreferences

class PreferenceUtility {

    private var appPreference: SharedPreferences? = null
    private val PREFS = "appPreferences"

    constructor(context: Context){
        appPreference = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
    }

    fun saveStringPreferences(key: String?, value: String?){
        val prefsEditor = appPreference!!.edit()
        prefsEditor.putString(key,value)

        prefsEditor.apply()
    }

    fun getStringPreferences(key: String?): String? {
        return appPreference!!.getString(key,"")
    }

}