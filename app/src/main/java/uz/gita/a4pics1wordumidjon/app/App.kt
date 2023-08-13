package uz.gita.a4pics1wordumidjon.app

import android.app.Application
import uz.gita.a4pics1wordumidjon.myprefs.MySharedPreferences

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
        MySharedPreferences.init(this)
    }

    companion object {
        private lateinit var context: App

        fun getContext(): App {
            return context
        }
    }
}