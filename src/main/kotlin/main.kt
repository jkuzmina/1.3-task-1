fun main() {
    val seconds = 2460
    println(agoToText(seconds))
}

fun agoToText(seconds: Int): String{
    val text = when{
        seconds in 1..60 -> "только что"
        seconds >= 61 && seconds <= 60 * 60 -> "${minutesToText(seconds/60)} назад"
        seconds >= 60 * 60 + 1 && seconds <= 24 * 60 * 60 -> "${hoursToText(seconds/60/60)} назад"
        seconds >= 24 * 60 * 60 + 1 && seconds <= 48 * 60 * 60 -> "сегодня"
        seconds >= 48 * 60 * 60 + 1 && seconds <= 72 * 60 * 60 -> "вчера"
        else -> "давно"
    }
    return "был(а) в сети $text"
}

fun minutesToText(minutes: Int): String{
    println(minutes % 100)
    val text = when{
        minutes == 1 || minutes % 10 == 1 && minutes % 100 != 11 ->"минуту"
        minutes in 2..4 || minutes % 10 in 2..4 && minutes % 100 !in 12..14 ->"минуты"
        else -> "минут"
    }
    return "$minutes $text"
}

fun  hoursToText(hours: Int): String{
    val text = when{
        hours == 1 || hours % 10 == 1 && hours % 100 != 11 ->"час"
        hours in 2..4 || hours % 10 in 2..4 && hours % 100 !in 12..14 ->"часа"
        else -> "часов"
    }
    return "$hours $text"
}