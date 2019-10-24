package ru.job4j.tracker

data class Item(var name: String,
                var desc: String
                ) {
    var id: String = ""
    var time: Long = 0

    constructor(name: String, desc: String, time: Long) : this(name, desc) {
        this.time = time
    }
}


fun main(args: Array<String>) {
    val item = Item("eee", "eee")
    val item1 = Item("eee", "EEE", 43)

}

