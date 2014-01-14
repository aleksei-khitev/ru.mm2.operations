package ru.mm2.operations

class ComConsultationRecord {
    Integer id
    Date date_time
    String client_contact
    String prim
    String fio
    String diagnoz
    String oms
    Date birthday
    Doctor doctor
    String parentfio
    Boolean isNaprav
    Boolean isPechat
    Boolean isConfirm
    static belongsTo = [doctor:Doctor]
    static searchable = true
    static constraints = {
        birthday nullable: false, blank: false
        oms nullable: false, blank: false
        diagnoz nullable: false, blank: false
        fio nullable: false, blank: false
        prim nullable: true
        client_contact nullable: false, blank: false
        date_time nullable: false, blank: false
    }
    static mapping = {
        table 'com_consultation_records'
    }
}
