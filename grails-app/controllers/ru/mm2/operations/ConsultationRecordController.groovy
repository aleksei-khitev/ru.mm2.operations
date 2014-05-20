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

import java.text.DateFormat
import java.text.SimpleDateFormat

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ConsultationRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ConsultationRecord.list(params), model: [consultationRecordInstanceCount: ConsultationRecord.count()]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def show(ConsultationRecord operationRecordInstance) {
        respond operationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def create() {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", new Locale("en","EN"))
        Date date = dateFormat.parse(params.date_time);
        List<ConsultationRecord> consultationRecord = ConsultationRecord.findAllByDate_timeBetween((date-1),date)
        respond consultationRecord, model: [consultationRecordInstanceCount: ConsultationRecord.count(), date:date]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def save(ConsultationRecord consultationRecordInstance) {
        if (consultationRecordInstance == null) {
            notFound()
            return
        }

        if (consultationRecordInstance.hasErrors()) {
            respond consultationRecordInstance.errors, view: 'create'
            return
        }

        consultationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'consultationRecordInstance.label', default: 'ConsultationRecord'), consultationRecordInstance.id])
                redirect consultationRecordInstance
            }
            '*' { respond consultationRecordInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def edit(ConsultationRecord consultationRecordInstance) {
        respond consultationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def update(ConsultationRecord consultationRecordInstance) {
        if (consultationRecordInstance == null) {
            notFound()
            return
        }

        if (consultationRecordInstance.hasErrors()) {
            respond consultationRecordInstance.errors, view: 'edit'
            return
        }

        consultationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ConsultationRecord.label', default: 'ConsultationRecord'), consultationRecordInstance.id])
                redirect consultationRecordInstance
            }
            '*' { respond consultationRecordInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def delete(ConsultationRecord consultationRecordInstance) {

        if (consultationRecordInstance == null) {
            notFound()
            return
        }

        consultationRecordInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ConsultationRecord.label', default: 'ConsultationRecord'), consultationRecordInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'consultationRecordInstance.label', default: 'ConsultationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
