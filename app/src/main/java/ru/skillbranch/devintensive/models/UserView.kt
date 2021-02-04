package ru.skillbranch.devintensive.models

class UserView(
    val id: String,
    var fullNmae: String?,
    var nikcName: String?,
    var avatar: String?,
    var status:String?,
    var initials:String?
){
    fun printMe(){
        println("""
            $id
            $fullNmae
            $nikcName
            $avatar
            $status
            $initials
        """.trimIndent())
    }
}