package uz.gita.a4pics1wordumidjon.myprefs

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class MySharedPreferences private constructor() {
    private lateinit var myPrefs: SharedPreferences
    private lateinit var editor: Editor

    private constructor(context: Context) : this() {
        myPrefs = context.getSharedPreferences(MY_PREFS, Context.MODE_PRIVATE)
        editor = myPrefs.edit()
    }

    companion object {
        private const val COINS = "coins"
        private const val LEVEL = "level"
        private const val CURRENT_QUESTION = "currQuestion"
        private const val MY_PREFS = "myPrefs"
        private lateinit var instance: MySharedPreferences

        fun init(context: Context) {
            if (!(::instance.isInitialized)) {
                instance = MySharedPreferences(context)
            }
        }

        fun getInstance(): MySharedPreferences {
            return instance
        }
    }

    fun putCurrentQuestion(currentQuestion: Int) {
        myPrefs.edit().putInt(CURRENT_QUESTION, currentQuestion).apply()
    }

    fun putCoins(coins: Int) {
        myPrefs.edit().putInt(COINS, coins).apply()
    }

    fun putLevel(level: Int) {
        myPrefs.edit().putInt(LEVEL, level).apply()
    }

    fun getCurrentQuestion(): Int {
        return myPrefs.getInt(CURRENT_QUESTION, 0)
    }

    fun getCoins(): Int {
        return myPrefs.getInt(COINS, 32)
    }

    fun getLevel(): Int {
        return myPrefs.getInt(LEVEL, 1)
    }

    fun clear() {
        myPrefs.edit().clear().apply()
    }

}