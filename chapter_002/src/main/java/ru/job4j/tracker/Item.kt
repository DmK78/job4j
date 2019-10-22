package ru.job4j.tracker

class Item {
    private var id: String = ""
    private var name: String
    private var desc: String
    private var time: Long = 0

    constructor(name: String, desc: String) {
        this.name = name
        this.desc = desc
    }

    constructor(name: String, desc: String, time: Long) {
        this.name = name
        this.desc = desc
        this.time = time
    }

    fun getId(): String {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getDesc(): String {
        return desc
    }

    fun setDesc(desc: String) {
        this.desc = desc
    }

    fun getTime(): Long {
        return time
    }

    fun setTime(time: Long) {
        this.time = time
    }


}