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


@Transactional(readOnly = true)
class DoctorController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Doctor.list(params), model: [doctorInstanceCount: Doctor.count()]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def show(Doctor doctorInstance) {
        respond doctorInstance
    }

    @Secured(['ROLE_ROOT'])
    def create() {
        respond new Doctor(params)
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def save(Doctor doctorInstance) {
        if (doctorInstance == null) {
            notFound()
            return
        }

        if (doctorInstance.hasErrors()) {
            respond doctorInstance.errors, view: 'create'
            return
        }

        doctorInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'doctorInstance.label', default: 'Doctor'), doctorInstance.id])
                redirect doctorInstance
            }
            '*' { respond doctorInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ROOT'])
    def edit(Doctor doctorInstance) {
        respond doctorInstance
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def update(Doctor doctorInstance) {
        if (doctorInstance == null) {
            notFound()
            return
        }

        if (doctorInstance.hasErrors()) {
            respond doctorInstance.errors, view: 'edit'
            return
        }

        doctorInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Doctor.label', default: 'Doctor'), doctorInstance.id])
                redirect doctorInstance
            }
            '*' { respond doctorInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def delete(Doctor doctorInstance) {

        if (doctorInstance == null) {
            notFound()
            return
        }

        doctorInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Doctor.label', default: 'Doctor'), doctorInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctorInstance.label', default: 'Doctor'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
