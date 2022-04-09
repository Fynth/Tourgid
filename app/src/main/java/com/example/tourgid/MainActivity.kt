package com.example.tourgid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tourgid.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var placearraylist: ArrayList<Place>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageid = intArrayOf(R.drawable.kremlin,R.drawable.eyfel,R.drawable.bigben,R.drawable.tadjmahal,R.drawable.pizan)

        val title = arrayOf(
            "Кремль",
            "Эйфелева Башня",
            "Биг-Бен",
            "Тадж-Махал",
            "Пизанская Башня")

        val description = arrayOf(
            "Крепость в центре Москвы",
            "металлическая башня в центре Парижа",
            "название часовой башни Вестминстерского дворца",
            "мавзолей-мечеть, находящийся в Агре",
            "колокольная башня в городе Пиза")

        val country = arrayOf(
            "Россия",
            "Франция",
            "Великобритания",
            "Индия",
            "Италия")

        val full_description = arrayOf(
            "крепость в центре Москвы и древнейшая её часть, главный общественно-политический и историко-художественный комплекс города, официальная резиденция Президента Российской Федерации, вплоть до распада СССР в декабре 1991 года была официальной резиденцией Генерального секретаря ЦК КПСС. ",
            "металлическая башня в центре Парижа, самая узнаваемая его архитектурная достопримечательность. Названа в честь главного конструктора Гюстава Эйфеля; сам Эйфель называл её просто «300-метровой башней»",
            "популярное туристическое название часовой башни Вестминстерского дворца. Официальное название башни с 2012 года — Башня Елизаветы, или Елизаветинская башня, один из самых узнаваемых символов Великобритании, часто используемый в сувенирах, рекламе, кинофильмах.",
            "Мавзолей-мечеть, находящийся в Агре, Индия, на берегу реки Джамна. Построен по приказу потомка Тамерлана, падишаха империи Великих Моголов Шах-Джахана, в память о жене Мумтаз-Махал, умершей при родах четырнадцатого ребёнка.",
            "Пиза́нская башня — колокольная башня, часть ансамбля городского собора Санта-Мария-Ассунта в городе Пиза, получившая всемирную известность благодаря непреднамеренному наклону. Расположенная позади собора, она является третьей старейшей постройкой на Площади чудес Пизы после самого собора и баптистерия.")
        placearraylist = ArrayList()

        for (i in title.indices){

            val place = Place(title[i], description[i], country[i], full_description[i], imageid[i])
            placearraylist.add(place)

        }
        binding.lisview.isClickable = true
        binding.lisview.adapter = Adapter(this, placearraylist)
        binding.lisview.setOnItemClickListener { parent, view, position, id ->

            val title = title[position]
            val country = country[position]
            val full_description = description[position]
            val imageid = imageid[position]

            val i = Intent(this, PlaceActivity::class.java)
            i.putExtra("title", title)
            i.putExtra("country", country)
            i.putExtra("full_description", full_description)
            i.putExtra("imageid", imageid)
            startActivity(i)

        }
    }
}