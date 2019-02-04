package jp.techacademy.wakahara.koumei.taskapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.content.Context

// Spinerにカテゴリ名を渡すためのアダプタ
class CategoryAdapter(context: Context): BaseAdapter() {
    private val mLayoutInflater: LayoutInflater
    var categoryList = mutableListOf<Category>()

    init {
        this.mLayoutInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return categoryList.size
    }

    override fun getItem(position: Int): Any {
        return categoryList[position]
    }

    override fun getItemId(position: Int): Long {
        return categoryList[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView?: mLayoutInflater.inflate(android.R.layout.simple_spinner_item, null)

        val textView1 = view.findViewById<TextView>(android.R.id.text1)

        textView1.text = categoryList[position].name

        return view
    }
}