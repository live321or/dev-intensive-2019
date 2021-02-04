package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView

fun User.toUserView():UserView{
    val nickName="dz"
    val initials="dz"
    val status=if(lastVisit==null) "Еще ни разу не был" else if (isOnline) "online" else "Последний раз был"
    return UserView(id,
    fullNmae = "$firstName $lastName",
    nikcName = nickName,
    initials = initials,
    avatar = avatar,
    status = status)
}