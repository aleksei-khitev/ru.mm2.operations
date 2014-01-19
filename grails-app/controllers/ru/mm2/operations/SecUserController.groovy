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
