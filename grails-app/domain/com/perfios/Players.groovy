package com.perfios

class Players {

    static belongsTo = [team : Team]
    String name
    String age
    String position

    static constraints = {

        name size: 4..25 , blank: false , unique: true
        age size: 1..5 , blank: false
        position size: 5..30 , blank: false

    }

    String toString() {
        name
    }
}
