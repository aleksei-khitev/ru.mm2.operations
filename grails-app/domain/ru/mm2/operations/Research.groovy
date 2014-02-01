package ru.mm2.operations

class Research {
    Integer id
    String name
    Double price
    static transients = ['nameAndString']
    String getNameAndString(){ "${name} - ${price}р." }
    //static hasMany = [comResearchRecord:ComResearchRecord]
    static constraints = {
        name nullable:false, blank: false
    }
    static searchable = true
    static mapping = {
        table 'research'
        version false
    }
}
