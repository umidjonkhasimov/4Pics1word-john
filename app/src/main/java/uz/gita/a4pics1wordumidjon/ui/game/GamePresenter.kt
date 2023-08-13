package uz.gita.a4pics1wordumidjon.ui.game

class GamePresenter(private val view: GameContract.View) : GameContract.Presenter {
    private val model: GameContract.Model = GameModel()

    override fun checkAnswer(userAnswer: String) {
        if (model.checkAnswer(userAnswer)) {
            showDialog()
        } else {
            view.makeAnsButtonsRed()
        }
    }

    override fun nullify() {
        model.nullify()
    }

    override fun getNextQuestion() {
        view.drawQuestionData(model.nextQuestionData(), model.getCurrentCoin(), model.getLevel())
    }

    override fun getQuestionData() {
        view.drawQuestionData(model.currentQuestionData(), model.getCurrentCoin(), model.getLevel())
    }

    override fun reduceCoins(reduceBy: Int) {
        model.reduceCoins(reduceBy)
    }

    override fun showDialog() {
        val message = model.getCurrentCongrats()
        val coins = model.getCurrentCoin()
        val btnTxt = model.getCurrentBtnText()
        val lastQuestion = model.isLastQuestion()

        view.showDialog(message, coins, btnTxt, lastQuestion)
    }

    override fun saveGameState() {
        model.saveGameState()
    }
}