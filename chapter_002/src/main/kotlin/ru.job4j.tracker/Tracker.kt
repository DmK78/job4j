package ru.job4j.tracker

import java.util.ArrayList

class Tracker{
    private val items = ArrayList<Item>()
    private var position = 0

    fun getPosition(): Int {
        return position
    }

    fun add(item: Item): Item {
        item.setId(this.generateId())
        item.setTime(System.currentTimeMillis())
        this.items.add(this.position++, item)
        return item
    }

    fun delete(item: Item): Boolean {
        var result = false
        val posToDel = findItemPos(item.getId())
        if (posToDel != -1) {
            result = true
            items.removeAt(posToDel)
            this.position--
        }
        return result
    }

    fun replace(id: String, item: Item): Boolean {
        var result = false
        val posToReplace = findItemPos(id)
        if (posToReplace >= 0) {
            result = true
            items[posToReplace] = item
        }
        return result
    }

    fun findAll(): List<Item> {
        return items
    }

    fun findByName(key: String): List<Item> {
        val result = ArrayList<Item>()
        for (item in items) {
            if (item.getName() == key) {
                result.add(item)
            }
        }
        return result
    }

    fun findItemPos(id: String): Int {
        var result = -1
        for (index in items.indices) {
            if (items[index].getId() == id) {
                result = index
                break
            }
        }
        return result
    }

    fun findById(id: String): Item? {
        var result: Item? = null
        for (item in items) {
            if (id == item.getId()) {
                result = item
                break
            }
        }
        return result
    }







    private fun generateId(): String {
        return (Math.random() * 1000).toInt().toString()
    }




}