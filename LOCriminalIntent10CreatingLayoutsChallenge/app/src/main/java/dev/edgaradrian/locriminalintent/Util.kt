package dev.edgaradrian.locriminalintent

import java.text.DateFormat
import java.util.*

fun Date.toFormatString(): String {
    return DateFormat.getDateInstance(DateFormat.LONG).format(this)
}//toStringWith