/*
 * ru.mm2.operations is an application for consultations and operations managing.
 * Copyright (c) 2014 Aleksei Khitevi (Хитёв Алексей Юрьевич), Guilnara Gamidova (Гюльнара Гамидова Вилаятовна).
 *
 * This file is part of ru.mm2.operations
 *
 * ru.mm2.operations is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * ru.mm2.operations is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
*/

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
