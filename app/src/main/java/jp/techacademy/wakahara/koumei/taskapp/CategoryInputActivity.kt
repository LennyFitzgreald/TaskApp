package jp.techacademy.wakahara.koumei.taskapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_category_input.*

class CategoryInputActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_input)

        ok_button.setOnClickListener {
            if (category_edit_text.text.isBlank()) {
                // 必ずカテゴリを入力させる
                Snackbar.make(it, "カテゴリ名は必ず入力してください", Snackbar.LENGTH_LONG).show()
            } else {
                val categoryName = category_edit_text.text.toString()

                val realm = Realm.getDefaultInstance()

                realm.beginTransaction()

                // カテゴリ生成
                val category = Category()
                val categoryRealmResults = realm.where(Category::class.java).findAll()

                // idをユニークにするために、必ず最大値になるよう設定
                val identifier: Int =
                    if (categoryRealmResults.max("id") != null) {
                        categoryRealmResults.max("id")!!.toInt() + 1
                    } else {
                        0
                    }
                // プロパティの設定
                category.id = identifier
                category.name = categoryName

                // Realmに保存
                realm.copyToRealmOrUpdate(category)

                realm.commitTransaction()
                realm.close()

                finish()
            }
        }
    }
}
