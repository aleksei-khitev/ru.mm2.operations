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
    Date lastUpdated
    String updatedUser
    static transients = ['formattedPhone']
    String getFormattedPhone(){
        if(client_contact.size()==7){
            "(812) ${client_contact.substring(0,3)} - ${client_contact.substring(3,5)} - ${client_contact.substring(5,7)}"
        }else if(client_contact.size()<10){
            "Неправильно набран номер. длинна может быть либо 7, либо 10 цифр"
        }else{
            "+7 (${client_contact.substring(0,3)}) ${client_contact.substring(3,6)} - ${client_contact.substring(6,8)} - ${client_contact.substring(8,10)}"
        }
    }
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
