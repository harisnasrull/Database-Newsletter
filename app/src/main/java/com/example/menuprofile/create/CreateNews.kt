package com.example.menuprofile.create

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.menuprofile.*
import com.example.menuprofile.helper.DBHelperNews
import com.example.menuprofile.table.News
import kotlinx.android.synthetic.main.activity_create_news.*

class CreateNews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_news)
        if (intent.getStringExtra("title-extra") == null){
            btn_insert.setOnClickListener {
                insertNews()
                Toast.makeText(this,"Success", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,Home::class.java)
                startActivity(intent)
            }
        }
        else {
            title_create.setText(R.string.update_title)
            input_title.setText(intent.getStringExtra("title-extra"))
            input_body.setText(intent.getStringExtra("body-extra"))
            input_date.setText(intent.getStringExtra("date-extra"))
            btn_insert.setText("Update")
            btn_insert.setOnClickListener {
                update()
                Toast.makeText(this, "Success Update Data", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
        }
    }
    fun insertNews(){
        val db = DBHelperNews(this)
        val news = News(
            input_title.text.toString(),
            input_body.text.toString(),
            input_date.text.toString()
        )
        db.insertNews(news)
    }
    fun update(){
        val db = DBHelperNews(this)
        val news = News(
            input_title.text.toString(),
            input_body.text.toString(),
            input_date.text.toString()
        )
        db.updateNews(news,intent.getIntExtra("id-extra",0))
    }
}
