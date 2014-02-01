package ru.mm2.operations

class Doctor {
    Integer id
    String fio
    String rang
    String prim
    String email
    String localphone
    String workphone
    Date lastUpdated
    String updatedUser
    //static hasMany = [genOperationRecord:GenOperationRecord,comOperationRecord:ComOperationRecord]
    static searchable = true
    static constraints = {
        fio nullable: false, blank: false
        rang nullable: true
        email email: true, blank: false, nullable: false
        localphone nullable: true
        workphone nullable: true
        prim nullable: true
    }
    static mapping = {
        table 'doctor'
        version false
    }
}
