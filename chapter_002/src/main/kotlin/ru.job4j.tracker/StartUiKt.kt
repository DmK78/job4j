package ru.job4j.tracker

import java.util.ArrayList

object StartUiKt {
    fun addItem(item: Item){
        println("Добавление заявки")
    }
    fun showAll(){
        println("Печать всех заявок")
    }

    fun init(){
        println("0 - Добавить заявку")
        println("1 - Показать все заявки")
        println("6 - Выйти")
        do {var i = readLine()!!.toInt()
            when(i){
                0 -> addItem(Item(name="1",desc = "1"))
                1 -> showAll()


            }

        }while (i!=6)
    }
}

fun main(args: Array<String>){
    StartUiKt.init()
}