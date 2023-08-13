package uz.gita.a4pics1wordumidjon.ui.game

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.view.indices
import uz.gita.a4pics1wordumidjon.R
import uz.gita.a4pics1wordumidjon.model.QuestionData
import uz.gita.a4pics1wordumidjon.ui.dialogs.CorrectAnsDialog


class GameActivity : AppCompatActivity(), GameContract.View {
    private var presenter: GameContract.Presenter = GamePresenter(this)
    private val images = ArrayList<AppCompatImageView>(4)
    private val answerButtons = ArrayList<AppCompatTextView>(8)
    private val optionButtons = ArrayList<AppCompatTextView>(16)
    private val map = HashMap<Int, Int>()
    private lateinit var level: TextView
    private lateinit var coins: TextView
    private lateinit var btnBack: AppCompatImageView
    private lateinit var btnRevealLetter: LinearLayoutCompat
    private lateinit var currentAnswer: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        loadViews()
        clickEvents()

        presenter.getQuestionData()
    }

    override fun makeAnsButtonsRed() {
        for (i in answerButtons.indices) {
            answerButtons[i].setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }

    private fun makeAnsButtonsWhite() {
        for (i in answerButtons.indices) {
            answerButtons[i].setTextColor(ContextCompat.getColor(this, R.color.white))
        }
    }

    override fun showDialog(message: String, coin: String, btnText: String, lastQuestion: Boolean) {
        val dialog = CorrectAnsDialog()
        dialog
            .setCongrats(message)
            .setCoinText(coin)
            .setButtonText(btnText)
        if (lastQuestion) {
            dialog.setNextButtonListener {
                presenter.nullify()
                finish()
            }
        } else {
            dialog.setNextButtonListener {
                presenter.getNextQuestion()
                dialog.dismiss()
            }
        }
        dialog.show(supportFragmentManager, "")
    }

    private fun loadViews() {
        images.add(findViewById(R.id.imageOne))
        images.add(findViewById(R.id.imageTwo))
        images.add(findViewById(R.id.imageThree))
        images.add(findViewById(R.id.imageFour))

        level = findViewById(R.id.tvLevel)
        coins = findViewById(R.id.tvCoin)
        btnBack = findViewById(R.id.buttonBack)
        btnRevealLetter = findViewById(R.id.revealLetter)

        val answerLine = findViewById<LinearLayoutCompat>(R.id.answerLine)
        for (i in answerLine.indices) {
            answerButtons.add(answerLine.getChildAt(i) as AppCompatTextView)
        }

        val optionLine1 = findViewById<LinearLayoutCompat>(R.id.optionLine1)
        for (i in optionLine1.indices) {
            optionButtons.add(optionLine1.getChildAt(i) as AppCompatTextView)
        }

        val optionLine2 = findViewById<LinearLayoutCompat>(R.id.optionLine2)
        for (i in optionLine2.indices) {
            optionButtons.add(optionLine2.getChildAt(i) as AppCompatTextView)
        }
    }

    override fun drawQuestionData(data: QuestionData, coins: String, level: String) {
        images[0].setImageResource(data.image1Res)
        images[1].setImageResource(data.image2Res)
        images[2].setImageResource(data.image3Res)
        images[3].setImageResource(data.image4Res)

        this.level.text = level
        this.coins.text = coins

        drawAnswerButtons(data.answer)
        drawOptionButtons(data.options)
    }

    private fun drawOptionButtons(options: String) {
        for (i in optionButtons.indices) {
            if (optionButtons[i].visibility == View.INVISIBLE)
                optionButtons[i].visibility = View.VISIBLE
            optionButtons[i].text = options[i].toString()
            optionButtons[i].isClickable = true
        }
    }

    private fun drawAnswerButtons(answer: String) {
        currentAnswer = answer
        for (i in answer.indices) {
            answerButtons[i].visibility = View.VISIBLE
            answerButtons[i].text = ""
        }

        for (i in answer.length until answerButtons.size) {
            answerButtons[i].visibility = View.GONE
        }
    }

    override fun checkAnswer() {
        var answer = ""
        for (i in answerButtons.indices) {
            if (answerButtons[i].visibility == View.VISIBLE && answerButtons[i].text.isNotEmpty()) {
                answer = answer.plus(answerButtons[i].text.toString())
            }
        }
        if (answer.length == currentAnswer.length) {
            presenter.checkAnswer(answer)
        } else {
            makeAnsButtonsWhite()
        }
    }

    private fun clickEvents() {
        btnBack.setOnClickListener {
            finish()
        }

        btnRevealLetter.setOnClickListener {
            val currCoin = coins.text.toString().toInt()
            if (currCoin >= 8)
                label@ for (i in answerButtons.indices) {
                    if (answerButtons[i].visibility == View.VISIBLE && answerButtons[i].text == "") {
                        val currLetter = currentAnswer[i].toString()
                        answerButtons[i].text = currLetter
                        for (j in optionButtons.indices) {
                            if (currLetter == optionButtons[j].text.toString()) {
                                optionButtons[j].visibility = View.INVISIBLE
                                presenter.reduceCoins(8)
                                coins.text = (currCoin - 8).toString()
                                map[i] = j
                                break@label
                            }
                        }
                    }
                }
            checkAnswer()
        }

        for (i in optionButtons.indices) {
            optionButtons[i].setOnClickListener {
                it as AppCompatTextView
                for (j in answerButtons.indices) {
                    if (answerButtons[j].visibility == View.VISIBLE && answerButtons[j].text.isEmpty()) {
                        answerButtons[j].text = it.text
                        it.visibility = View.INVISIBLE
                        map[j] = i
                        break
                    }
                }
                checkAnswer()
            }
        }

        for (i in answerButtons.indices) {
            answerButtons[i].setOnClickListener {
                it as AppCompatTextView
                if (it.text.isNotEmpty()) {
                    optionButtons[map[i]!!].visibility = View.VISIBLE
                    optionButtons[map[i]!!].text = it.text
                }
                it.text = ""
                makeAnsButtonsWhite()
            }
        }
    }

    override fun onPause() {
        presenter.saveGameState()
        super.onPause()
    }
}