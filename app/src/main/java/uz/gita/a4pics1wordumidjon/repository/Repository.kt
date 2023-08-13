package uz.gita.a4pics1wordumidjon.repository

import uz.gita.a4pics1wordumidjon.R
import uz.gita.a4pics1wordumidjon.model.QuestionData

class Repository private constructor() {
    companion object {
        private lateinit var instance: Repository
        fun getInstance(): Repository {
            if (!(::instance.isInitialized)) {
                instance = Repository()
            }
            return instance
        }
    }

    val list = ArrayList<QuestionData>()
    val congratsMessages = ArrayList<String>()

    init {
        loadData()
    }

    private fun loadData() {
        congratsMessages.add("OKAY")
        congratsMessages.add("GOOD")
        congratsMessages.add("AWESOME")
        congratsMessages.add("KEEP GOING")
        congratsMessages.add("GREAT")
        congratsMessages.add("BRILLIANT")
        congratsMessages.add("FANTASTIC")
        congratsMessages.add("VERY GOOD")
        congratsMessages.add("PRETTY SMART")
        congratsMessages.add("GOOD")
        congratsMessages.add("AWESOME")
        congratsMessages.add("KEEP GOING")
        congratsMessages.add("GREAT")
        congratsMessages.add("BRILLIANT")
        congratsMessages.add("FANTASTIC")
        congratsMessages.add("VERY GOOD")
        congratsMessages.add("PRETTY SMART")
        congratsMessages.add("AWESOME")
        congratsMessages.add("KEEP GOING")
        congratsMessages.add("GREAT")
        congratsMessages.add("BRILLIANT")
        congratsMessages.add("FANTASTIC")
        congratsMessages.add("VERY GOOD")
        congratsMessages.add("PRETTY SMART")
        congratsMessages.add("CONGRATS\nYOU WIN")

        list.add(
            QuestionData(
                R.drawable.pic_airplane,
                R.drawable.pic_luggage,
                R.drawable.pic_passport,
                R.drawable.pic_passport_control,
                "TGDRFJAGVHEJKKLL",
                "TRAVEL"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_book,
                R.drawable.pic_glasses,
                R.drawable.pic_paper,
                R.drawable.pic_pen,
                "EWRRTQIYTIILNHGS",
                "WRITING"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_banana,
                R.drawable.pic_orange,
                R.drawable.pic_grapes,
                R.drawable.pic_apple,
                "QAKFSFRIYUERIRWT",
                "FRUIT"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_wallet,
                R.drawable.pic_money,
                R.drawable.pic_card,
                R.drawable.pic_coins,
                "GFMHGOOINQWEMNYF",
                "MONEY"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_deal1,
                R.drawable.pic_deal2,
                R.drawable.pic_deal3,
                R.drawable.pic_deal4,
                "SDDFHELYTPAYTLER",
                "DEAL"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_bat1,
                R.drawable.pic_bat2,
                R.drawable.pic_bat4,
                R.drawable.pic_bat3,
                "ADBDJAIFUTAFQERF",
                "BAT"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_balloon1,
                R.drawable.pic_balloon2,
                R.drawable.pic_balloon3,
                R.drawable.pic_balloon4,
                "ASBSFAGJLKJLOUON",
                "BALLOON"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_flower1,
                R.drawable.pic_flower2,
                R.drawable.pic_flower3,
                R.drawable.pic_flower4,
                "ASFFSLGDOGJWKHER",
                "FLOWER"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_sleep1,
                R.drawable.pic_sleep2,
                R.drawable.pic_sleep3,
                R.drawable.pic_sleep4,
                "SASFDLFDEEFDPHFF",
                "SLEEP"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_idea1,
                R.drawable.pic_idea2,
                R.drawable.pic_idea3,
                R.drawable.pic_idea4,
                "SAIDSDGFEGJHALKD",
                "IDEA"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_bag1,
                R.drawable.pic_bag2,
                R.drawable.pic_bag3,
                R.drawable.pic_bag4,
                "SABDSDGAEGJHAGKD",
                "BAG"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_bee1,
                R.drawable.pic_bee2,
                R.drawable.pic_bee3,
                R.drawable.pic_bee4,
                "SBIDSDGBEGJHAEKE",
                "BEE"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_bed1,
                R.drawable.pic_bed2,
                R.drawable.pic_bed3,
                R.drawable.pic_bed4,
                "ASBADEDGDGGDJHKF",
                "BED"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_bus1,
                R.drawable.pic_bus2,
                R.drawable.pic_bus3,
                R.drawable.pic_bus4,
                "SBDSUKJHSRQSGDFA",
                "BUS"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_bake1,
                R.drawable.pic_bake2,
                R.drawable.pic_bake3,
                R.drawable.pic_bake4,
                "BDUENGLAUEMGKLVE",
                "BAKE"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_ball1,
                R.drawable.pic_ball2,
                R.drawable.pic_ball3,
                R.drawable.pic_ball4,
                "ASBSDAGDLJHGLLKK",
                "BALL"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_meat1,
                R.drawable.pic_meat2,
                R.drawable.pic_meat3,
                R.drawable.pic_meat4,
                "AMADEFDGAGHJTKDS",
                "MEAT"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_bike1,
                R.drawable.pic_bike2,
                R.drawable.pic_bike3,
                R.drawable.pic_bike4,
                "SABDSIFDKGHFEHJA",
                "BIKE"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_zoom1,
                R.drawable.pic_zoom2,
                R.drawable.pic_zoom3,
                R.drawable.pic_zoom4,
                "SAZDSODFGOGJMJKL",
                "ZOOM"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_tank1,
                R.drawable.pic_tank2,
                R.drawable.pic_tank3,
                R.drawable.pic_tank4,
                "ASTFSAHFNLJKUYAS",
                "TANK"
            )
        )
        //////
        list.add(
            QuestionData(
                R.drawable.pic_snow1,
                R.drawable.pic_snow2,
                R.drawable.pic_snow3,
                R.drawable.pic_snow4,
                "SFASFHNKDJFOSHDW",
                "SNOW"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_dog1,
                R.drawable.pic_dog2,
                R.drawable.pic_dog3,
                R.drawable.pic_dog4,
                "ASDDSODGGGHJDSFD",
                "DOG"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_brain1,
                R.drawable.pic_brain2,
                R.drawable.pic_brain3,
                R.drawable.pic_brain4,
                "TSBDSRSAAIDNDSGS",
                "BRAIN"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_clown1,
                R.drawable.pic_clown2,
                R.drawable.pic_clown3,
                R.drawable.pic_clown4,
                "CAZDLODFOOGWMJNL",
                "CLOWN"
            )
        )
        list.add(
            QuestionData(
                R.drawable.pic_error1,
                R.drawable.pic_error2,
                R.drawable.pic_error3,
                R.drawable.pic_error4,
                "SAEPOREQWRCXZOMR",
                "ERROR"
            )
        )
    }
}