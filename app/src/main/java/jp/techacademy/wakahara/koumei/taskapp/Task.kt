package jp.techacademy.wakahara.koumei.taskapp

import java.io.Serializable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.Date

open class Task: RealmObject(), Serializable {
    var title: String = ""      // タイトル
    var contents: String = ""   // 内容
    var date: Date = Date()      // 日時
    var category: String = ""   // カテゴリー（課題追加分）

    // idをプライマリキーとして設定
    @PrimaryKey
    var id: Int = 0
}