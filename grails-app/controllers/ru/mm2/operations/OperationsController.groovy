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
class OperationsController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Operations.list(params), model: [operationsInstanceCount: Operations.count()]
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def show(Operations operationsInstance) {
        respond operationsInstance
    }

    @Secured(['ROLE_ROOT'])
    def create() {
        respond new Operations(params)
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def save(Operations operationsInstance) {
        if (operationsInstance == null) {
            notFound()
            return
        }

        if (operationsInstance.hasErrors()) {
            respond operationsInstance.errors, view: 'create'
            return
        }

        operationsInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'operationsInstance.label', default: 'Operations'), operationsInstance.id])
                redirect operationsInstance
            }
            '*' { respond operationsInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ROOT'])
    def edit(Operations operationsInstance) {
        respond operationsInstance
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def update(Operations operationsInstance) {
        if (operationsInstance == null) {
            notFound()
            return
        }

        if (operationsInstance.hasErrors()) {
            respond operationsInstance.errors, view: 'edit'
            return
        }

        operationsInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Operations.label', default: 'Operations'), operationsInstance.id])
                redirect operationsInstance
            }
            '*' { respond operationsInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def delete(Operations operationsInstance) {

        if (operationsInstance == null) {
            notFound()
            return
        }

        operationsInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Operations.label', default: 'Operations'), operationsInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'operationsInstance.label', default: 'Operations'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
