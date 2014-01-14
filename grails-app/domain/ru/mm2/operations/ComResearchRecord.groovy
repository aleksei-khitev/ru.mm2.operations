package ru.mm2.operations

class ComResearchRecord {
    Integer id
    Date date_time
    String fio
    Date birthday
    Research research
    static belongsTo = [research:Research]
    static searchable = true
    static constraints = {
        birthday nullable: false, blank: false
        fio nullable: false, blank: false
        date_time nullable: false, blank: false
        birthday nullable: false, blank: false
    }
    static mapping = {
        table 'com_research_records'
    }
}
