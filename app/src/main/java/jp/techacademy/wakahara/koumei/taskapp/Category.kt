package jp.techacademy.wakahara.koumei.taskapp

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

open class Category: RealmObject(), Serializable { //Serializable要る？
    var name: String = ""

    @PrimaryKey
    var id: Int = 0
}