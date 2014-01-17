package ru.mm2.operations

class SecRole {

    String authority

    static mapping = {
        cache true
    }

    static constraints = {
        authority blank: false, unique: true
    }

    def toString = {id}
    }
