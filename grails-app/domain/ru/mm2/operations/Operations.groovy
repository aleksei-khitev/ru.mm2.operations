package ru.mm2.operations

class Operations {
    Integer id
    String name

    static hasMany = [operationRecord:OperationRecord ]

    static constraints = {
        name nullable:false, blank: false
    }
    static searchable = true
    static mapping = {
        table 'operation'
        version false
    }
}
