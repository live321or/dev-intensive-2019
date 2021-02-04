package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.time.Period
import java.util.*
import java.util.concurrent.TimeUnit

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.humanizeDiff(date:Date=Date()):String{

    var second:Long=(date.time/1000L)-(this.time/1000L)
    var humanize:String=""
    var N:Long=0

    if (second>31536000L){
        humanize="более года назад"
    }else if (second>93600L){
        N=second/60L/60L/24L
        humanize="$N дней назад"
    }else if (second>79200L){
        humanize="день назад"
    }else if (second>4500L){
        N=second/60L/60L
        humanize="$N часов назад"
    }else if (second>2700L){
        humanize="час назад"
    }else if (second>75L){
        N=second/60L
        humanize="$N минут назад"
    }else if (second>45L){
        humanize="минуту назад"
    }else if (second>1L){
        humanize="несколько секунд назад"
    }else {
        humanize="только что"
    }

    return "${(date.time/1000L)-(this.time/1000L)} \n$humanize"
}



fun Date.add(value: Int, units: TimeUnits=TimeUnits.SECOND): Date {
    var time = this.time

    time+= when(units){
        TimeUnits.SECOND->value* SECOND
        TimeUnits.MINUTES->value* MINUTE
        TimeUnits.HOUR->value* HOUR
        TimeUnits.DAY->value* DAY
    }
    this.time=time
    return this
}

enum class TimeUnits{
    SECOND,
    MINUTES,
    HOUR,
    DAY
}