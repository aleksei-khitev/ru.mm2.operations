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

class ComResearchRecord {
    Integer id
    Date date_time
    String fio
    Date birthday
    Research research
    Date lastUpdated
    String updatedUser
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
