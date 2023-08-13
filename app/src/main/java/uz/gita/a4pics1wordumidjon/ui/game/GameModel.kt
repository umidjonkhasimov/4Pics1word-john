package uz.gita.a4pics1wordumidjon.ui.game

import uz.gita.a4pics1wordumidjon.model.QuestionData
import uz.gita.a4pics1wordumidjon.myprefs.MySharedPreferences
import uz.gita.a4pics1wordumidjon.repository.Repository

class GameModel : GameContract.Model {
    private val repository: Repository = Repository.getInstance()
    private val myPrefs = MySharedPreferences.getInstance()
    private val questions = ArrayList<QuestionData>()
    private val congratsMessages = ArrayList<String>()
    private var currentQuestion = 0
    private var coins = 32
    private var level = 1

    init {
        currentQuestion = myPrefs.getCurrentQuestion()
        coins = myPrefs.getCoins()
        level = myPrefs.getLevel()
        questions.addAll(repository.list)
        congratsMessages.addAll(repository.congratsMessages)
    }

    override fun currentQuestionData(): QuestionData {
        return questions[currentQuestion]
    }

    override fun nextQuestionData(): QuestionData {
        return questions[++currentQuestion]
    }

    override fun reduceCoins(reduceBy: Int) {
        coins -= reduceBy
    }

    override fun checkAnswer(userAnswer: String): Boolean {
        if (userAnswer == questions[currentQuestion].answer) {
            coins += 4
            level++
            return true
        }
        return false
    }

    override fun getLevel(): String {
        return level.toString()
    }

    override fun isLastQuestion(): Boolean {
        return currentQuestion == questions.size - 1
    }

    override fun getCurrentCongrats(): String {
        return congratsMessages[currentQuestion]
    }

    override fun getCurrentCoin(): String {
        return coins.toString()
    }

    override fun getCurrentBtnText(): String {
        if (currentQuestion == 9)
            return "Close"
        return "Next"
    }

    override fun nullify() {
        myPrefs.clear()
        level = 1
        coins = 32
        currentQuestion = 0
    }

    override fun saveGameState() {
        myPrefs.putCurrentQuestion(currentQuestion)
        myPrefs.putCoins(coins)
        myPrefs.putLevel(level)
    }

}