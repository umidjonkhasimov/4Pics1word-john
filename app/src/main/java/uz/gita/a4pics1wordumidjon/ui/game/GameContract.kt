package uz.gita.a4pics1wordumidjon.ui.game

import uz.gita.a4pics1wordumidjon.model.QuestionData

interface GameContract {
    interface Model {
        fun nextQuestionData(): QuestionData
        fun currentQuestionData(): QuestionData
        fun checkAnswer(userAnswer: String): Boolean
        fun getCurrentCongrats(): String
        fun getCurrentCoin(): String
        fun getCurrentBtnText(): String
        fun isLastQuestion(): Boolean
        fun getLevel(): String
        fun reduceCoins(reduceBy: Int)
        fun saveGameState()
        fun nullify()
    }

    interface View {
        fun drawQuestionData(data: QuestionData, coins: String, level: String)
        fun checkAnswer()
        fun showDialog(message: String, coin: String, btnText: String, lastQuestion: Boolean)
        fun makeAnsButtonsRed()
    }

    interface Presenter {
        fun checkAnswer(userAnswer: String)
        fun getQuestionData()
        fun showDialog()
        fun getNextQuestion()
        fun reduceCoins(reduceBy: Int)
        fun saveGameState()
        fun nullify()
    }
}