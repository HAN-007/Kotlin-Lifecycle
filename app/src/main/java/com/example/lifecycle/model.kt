package com.example.lifecycle

class model {
    private var counter = 0
    fun up(){
        counter +=1
    }
    fun getCounter(): Int {
        return counter
    }

}
