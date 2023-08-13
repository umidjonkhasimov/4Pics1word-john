package uz.gita.a4pics1wordumidjon.ui.menu

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import uz.gita.a4pics1wordumidjon.R
import uz.gita.a4pics1wordumidjon.myprefs.MySharedPreferences
import uz.gita.a4pics1wordumidjon.ui.about.AboutActivity
import uz.gita.a4pics1wordumidjon.ui.game.GameActivity

class MainActivity : AppCompatActivity() {
    private lateinit var myPrefs: MySharedPreferences
    private lateinit var btnNewGame: Button
    private lateinit var btnContinue: Button

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myPrefs = MySharedPreferences.getInstance()
        btnNewGame = findViewById(R.id.btnNewGame)
        btnContinue = findViewById(R.id.btnContinue)

        setListeners()
    }

    private fun setListeners() {
        findViewById<Button>(R.id.btnAbout).setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        findViewById<Button>(R.id.btnQuit).setOnClickListener {
            finish()
        }
        btnContinue.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }
        btnNewGame.setOnClickListener {
            myPrefs.clear()
            startActivity(Intent(this, GameActivity::class.java))
        }
    }

    private fun setButtonRes() {
        if (myPrefs.getCurrentQuestion() == 0) {
            btnContinue.isEnabled = false
            btnContinue.setBackgroundResource(R.drawable.btn_next_disabled)
            btnContinue.setTextColor(ContextCompat.getColor(this, R.color.light_grey))
        } else {
            btnContinue.isEnabled = true
            btnContinue.setBackgroundResource(R.drawable.btn_next)
            btnContinue.setTextColor(ContextCompat.getColor(this, R.color.white))
        }
    }

    override fun onResume() {
        setButtonRes()
        super.onResume()
    }
}