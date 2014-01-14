package ru.mm2.operations

class ComOperationRecord {
    Integer id
    Date date_time
    String client_contact
    String prim
    String fio
    String parentfio
    Boolean isDisp
    String lastill
    String diagnoz
    String oms
    String disp
    String patology
    Boolean isPatology
    Boolean isConfirm
    Date birthday
    Doctor doctor
    Operations operation
    static belongsTo = [operation:Operations, doctor:Doctor]
    static searchable = true
    static constraints = {
        birthday nullable: false, blank: false
        oms nullable: false, blank: false
        diagnoz nullable: false, blank: false
        lastill nullable: false, blank: false
        parentfio nullable: false, blank: false
        fio nullable: false, blank: false
        prim nullable: true
        client_contact nullable: false, size: 7..10, blank: false
        date_time nullable: false, blank: false
        patology nullable: true
        disp nullable: true
    }
    static mapping = {
        table 'com_operation_records'
    }
}
