package ru.job4j.tracker

data class Item(private var name: String,
                private var desc: String
                ) {
    private var id: String = ""
    private var time: Long = 0

    constructor(name: String, desc: String, time: Long) : this(name, desc) {
        this.time = time
    }

    public fun getName() = name
    public fun getId() = id
    public fun getTime()=time
    public fun getDesc() = desc

    public fun setId(_id: String){id = _id}
    public fun setName(_name: String){name = _name}
    public fun setTime(_time: Long){time = _time}
    public fun setDesc(_desc: String){desc = _desc}
}


fun main(args: Array<String>) {
    val item = Item("eee", "eee")
    val item1 = Item("eee", "EEE", 43)

}

