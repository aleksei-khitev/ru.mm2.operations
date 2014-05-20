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
class SecUserController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['permitAll'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SecUser.list(params), model: [secUserInstanceCount: SecUser.count()]
    }

    @Secured(['permitAll'])
    def show(SecUser secUserInstance) {
        respond secUserInstance
    }

    @Secured(['permitAll'])
    def create() {
        respond new SecUser(params)
    }

    @Secured(['permitAll'])
    @Transactional
    def save(SecUser secUserInstance) {
        if (secUserInstance == null) {
            notFound()
            return
        }
        /*List<SecUserSecRole> policies = SecUserSecRole.findAllBySecUser(secUserInstance)
        for(SecUserSecRole policy : policies){
            policy.delete flush: true
        }*/
        if(params.authorities!=null){
            List<SecUserSecRole> policies = SecUserSecRole.findAllBySecUser(secUserInstance)
            for(SecUserSecRole policy : policies){
                policy.delete flush: true
            }
            List<String> auths = new ArrayList<String>()
            if(params.authorities instanceof String){
                auths.add(params.authorities)
            }else{
                auths = params.authorities
            }
            for(String roleName : auths){
                Integer roleId = roleName.substring(roleName.indexOf(':')+1).toInteger()
                SecRole role = SecRole.findById(roleId)
                SecUserSecRole policy = new SecUserSecRole(secUser:secUserInstance, secRole:role)
                policy.save flush: true
            }
        }
        if (secUserInstance.hasErrors()) {
            respond secUserInstance.errors, view: 'create'
            return
        }
        println params.authorities
        secUserInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'secUserInstance.label', default: 'SecUser'), secUserInstance.id])
                redirect secUserInstance
            }
            '*' { respond secUserInstance, [status: CREATED] }
        }
    }

    @Secured(['permitAll'])
    def edit(SecUser secUserInstance) {
        respond secUserInstance
    }

    @Secured(['permitAll'])
    @Transactional
    def update(SecUser secUserInstance) {
        List<SecUserSecRole> policies = SecUserSecRole.findAllBySecUser(secUserInstance)
        for(SecUserSecRole policy : policies){
            policy.delete flush: true
        }
        if(params.authorities!=null){
            List<String> auths = new ArrayList<String>()
            if(params.authorities instanceof String){
                auths.add(params.authorities)
            }else{
                auths = params.authorities
            }
            for(String roleName : auths){
                Integer roleId = roleName.substring(roleName.indexOf(':')+1).toInteger()
                SecRole role = SecRole.findById(roleId)
                SecUserSecRole policy = new SecUserSecRole(secUser:secUserInstance, secRole:role)
                policy.save flush: true
            }
        }
        if (secUserInstance == null) {
            notFound()
            return
        }

        if (secUserInstance.hasErrors()) {
            respond secUserInstance.errors, view: 'edit'
            return
        }

        secUserInstance.save flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SecUser.label', default: 'SecUser'), secUserInstance.id])
                redirect secUserInstance
            }
            '*' { respond secUserInstance, [status: OK] }
        }
    }

    @Secured(['permitAll'])
    @Transactional
    def delete(SecUser secUserInstance) {

        if (secUserInstance == null) {
            notFound()
            return
        }

        secUserInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SecUser.label', default: 'SecUser'), secUserInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    @Secured(['permitAll'])
    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'secUserInstance.label', default: 'SecUser'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
