package uz.gita.a4pics1wordumidjon.model

data class QuestionData(
    val image1Res: Int,
    val image2Res: Int,
    val image3Res: Int,
    val image4Res: Int,
    val options: String,    // 16
    val answer: String      // 8
)

