package uz.gita.a4pics1wordumidjon.ui.dialogs

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import uz.gita.a4pics1wordumidjon.R

class CorrectAnsDialog : DialogFragment() {
    private var message = ""
    private var buttonTxt = "Close"
    private var coin = ""
    private lateinit var listener: (() -> Unit)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d("GGG", "onCreateView")
        val view = inflater.inflate(R.layout.dialog_correct_ans, container, false)
        view.findViewById<TextView>(R.id.tv_congrats).text = message
        view.findViewById<TextView>(R.id.tv_dialog_coin).text = coin
        val btnNext = view.findViewById<AppCompatButton>(R.id.btn_next)
        btnNext.text = buttonTxt
        btnNext.setOnClickListener {
            listener.invoke()
        }
        return view
    }

    fun setCongrats(message: String): CorrectAnsDialog {
        this.message = message
        return this
    }

    fun setButtonText(message: String): CorrectAnsDialog {
        this.buttonTxt = message
        return this
    }

    fun setCoinText(message: String): CorrectAnsDialog {
        this.coin = message
        return this
    }

    fun setNextButtonListener(action: () -> Unit) {
        listener = action
    }
}
