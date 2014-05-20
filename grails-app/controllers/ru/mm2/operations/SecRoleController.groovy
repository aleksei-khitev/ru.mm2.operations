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
class SecRoleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ROOT'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SecRole.list(params), model: [secRoleInstanceCount: SecRole.count()]
    }

    @Secured(['ROLE_ROOT'])
    def show(SecRole secRoleInstance) {
        respond secRoleInstance
    }

    @Secured(['ROLE_ROOT'])
    def create() {
        respond new SecRole(params)
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def save(SecRole secRoleInstance) {
        if (secRoleInstance == null) {
            notFound()
            return
        }

        if (secRoleInstance.hasErrors()) {
            respond secRoleInstance.errors, view: 'create'
            return
        }

        secRoleInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'secRoleInstance.label', default: 'SecRole'), secRoleInstance.id])
                redirect secRoleInstance
            }
            '*' { respond secRoleInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ROOT'])
    def edit(SecRole secRoleInstance) {
        respond secRoleInstance
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def update(SecRole secRoleInstance) {
        if (secRoleInstance == null) {
            notFound()
            return
        }

        if (secRoleInstance.hasErrors()) {
            respond secRoleInstance.errors, view: 'edit'
            return
        }

        secRoleInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SecRole.label', default: 'SecRole'), secRoleInstance.id])
                redirect secRoleInstance
            }
            '*' { respond secRoleInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_ROOT'])
    @Transactional
    def delete(SecRole secRoleInstance) {

        if (secRoleInstance == null) {
            notFound()
            return
        }

        secRoleInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SecRole.label', default: 'SecRole'), secRoleInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['ROLE_ROOT'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'secRoleInstance.label', default: 'SecRole'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }


}
