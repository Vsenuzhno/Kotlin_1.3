fun agoToText(seconds: Long) {
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24

    when {
        seconds in 0..60 -> println("был(а) только что")
        seconds in 61 until 60 * 60 -> {
            val minuteText = getMinuteText(minutes)
            println("был(а) $minuteText назад")
        }
        seconds in (60 * 60 + 1) until (24 * 60 * 60) -> {
            val hourText = getHourText(hours)
            println("был(а) $hourText назад")
        }
        seconds in (24 * 60 * 60) until (48 * 60 * 60) -> println("был(а) вчера")
        seconds in (48 * 60 * 60) until (72 * 60 * 60) -> println("был(а) позавчера")
        else -> println("был(а) давно")
    }
}

fun getMinuteText(minutes: Long): String {
    return when {
        minutes % 10 == 1L && minutes % 100 != 11L -> "$minutes минуту"
        minutes % 10 in 2..4 && minutes % 100 !in 12..14 -> "$minutes минуты"
        else -> "$minutes минут"
    }
}

fun getHourText(hours: Long): String {
    return when {
        hours % 10 == 1L && hours % 100 != 11L -> "$hours час"
        hours % 10 in 2..4 && hours % 100 !in 12..14 -> "$hours часа"
        else -> "$hours часов"
    }
}

fun main() {
    // Пример использования
    agoToText(10) // был(а) только что
    agoToText(180) // был(а) 3 минуты назад
    agoToText(7200) // был(а) 2 часа назад
    agoToText(86400) // был(а) вчера
    agoToText(172800) // был(а) позавчера
    agoToText(259200) // был(а) давно
}
