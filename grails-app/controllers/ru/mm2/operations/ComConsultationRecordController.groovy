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
class ComConsultationRecordController {

    def springSecurityService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ComConsultationRecord.list(params), model: [comConsultationRecordInstanceCount: ComConsultationRecord.count()]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def show(ComConsultationRecord operationRecordInstance) {
        respond operationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def create() {
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", new Locale("en","EN"))
        Date date = dateFormat.parse(params.date_time);
        List<ComConsultationRecord> comConsultationRecord = ComConsultationRecord.findAllByDate_timeBetween((date-1),date)
        respond comConsultationRecord, model: [comConsultationRecordInstanceCount: ComConsultationRecord.count(), date:date]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def save(ComConsultationRecord comConsultationRecordInstance) {
        if (comConsultationRecordInstance == null) {
            notFound()
            return
        }

        if (comConsultationRecordInstance.hasErrors()) {
            respond comConsultationRecordInstance.errors, view: 'create'
            return
        }


        comConsultationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'comConsultationRecordInstance.label', default: 'ComConsultationRecord'), comConsultationRecordInstance.id])
                redirect comConsultationRecordInstance
            }
            '*' { respond comConsultationRecordInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def edit(ComConsultationRecord comConsultationRecordInstance) {
        respond comConsultationRecordInstance
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def update(ComConsultationRecord comConsultationRecordInstance) {
        if (comConsultationRecordInstance == null) {
            notFound()
            return
        }

        if (comConsultationRecordInstance.hasErrors()) {
            respond comConsultationRecordInstance.errors, view: 'edit'
            return
        }

        comConsultationRecordInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ComConsultationRecord.label', default: 'ComConsultationRecord'), comConsultationRecordInstance.id])
                redirect comConsultationRecordInstance
            }
            '*' { respond comConsultationRecordInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    @Transactional
    def delete(ComConsultationRecord comConsultationRecordInstance) {

        if (comConsultationRecordInstance == null) {
            notFound()
            return
        }

        comConsultationRecordInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ComConsultationRecord.label', default: 'ComConsultationRecord'), comConsultationRecordInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'comConsultationRecordInstance.label', default: 'ComConsultationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
