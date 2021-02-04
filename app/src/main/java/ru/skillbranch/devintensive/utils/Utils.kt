package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        var firstName:String?
        val parts: List<String>? = fullName?.trim()?.split(" ")

        if (parts?.get(0).equals("")) {
             firstName = null
        }else{
            firstName = parts?.getOrNull(0)
        }

        val lastName = parts?.getOrNull(1)

        return Pair(firstName, lastName)
//        return firstName to lastName
    }
}