package com.perfios

class Team {

    String name
    String city
    String stadium
    String manager
    static hasMany = [player : Players]

    static constraints = {
        name size :  4..25 , blank : false , unique : true
        city size: 5..30 , blank: false
        stadium size: 5..30 , blank: false
        manager size: 5..200 , blank: false

    }

    String toString(){
        name
    }
}
