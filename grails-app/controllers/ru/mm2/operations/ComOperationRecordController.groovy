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

import org.springframework.security.access.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import java.text.DateFormat
import java.text.SimpleDateFormat


@Transactional(readOnly = true)
class ComOperationRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ComOperationRecord.list(params), model: [comOperationRecordInstanceCount: ComOperationRecord.count()]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def show(ComOperationRecord comOperationRecordInstance) {
        respond comOperationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def detailed() {
        respond ComOperationRecord.list(params)
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def create() {
        DateFormat dateFormat
        def map = [:]
        if(params.from_consult){
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("en","EN"))
            map.fio=params.fio
            map.diagnoz=params.diagnoz
            map.oms=params.oms
            map.birthday=dateFormat.parse(params.birthday)
            map.client_contact=params.client_contact
            map.doctor_id=params.doctor_id
            map.parentfio=params.parentfio
        }else{
            dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", new Locale("en","EN"))
        }
        Date date = dateFormat.parse(params.date_time);
        map.date=date
        List<ComOperationRecord> comOperationRecord = ComOperationRecord.findAllByDate_timeBetween((date-1),date)
        map.comOperationRecordInstanceCount=ComOperationRecord.count()
        respond comOperationRecord, model: map
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def save(ComOperationRecord comOperationRecordInstance) {
        if (comOperationRecordInstance == null) {
            notFound()
            return
        }

        if (comOperationRecordInstance.hasErrors()) {
            respond comOperationRecordInstance.errors, view: 'create'
            return
        }

        comOperationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'comOperationRecordInstance.label', default: 'ComOperationRecord'), comOperationRecordInstance.id])
                redirect comOperationRecordInstance
            }
            '*' { respond comOperationRecordInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def edit(ComOperationRecord comOperationRecordInstance) {
        respond comOperationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def update(ComOperationRecord comOperationRecordInstance) {
        if (comOperationRecordInstance == null) {
            notFound()
            return
        }

        if (comOperationRecordInstance.hasErrors()) {
            respond comOperationRecordInstance.errors, view: 'edit'
            return
        }

        comOperationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ComOperationRecord.label', default: 'ComOperationRecord'), comOperationRecordInstance.id])
                redirect comOperationRecordInstance
            }
            '*' { respond comOperationRecordInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def delete(ComOperationRecord comOperationRecordInstance) {

        if (comOperationRecordInstance == null) {
            notFound()
            return
        }

        comOperationRecordInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ComOperationRecord.label', default: 'ComOperationRecord'), comOperationRecordInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'comOperationRecordInstance.label', default: 'ComOperationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}

