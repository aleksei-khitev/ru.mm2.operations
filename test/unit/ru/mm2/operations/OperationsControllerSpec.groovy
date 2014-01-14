package ru.mm2.operations



import grails.test.mixin.*
import spock.lang.*

@TestFor(OperationsController)
@Mock(Operations)
class OperationsControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.operationsInstanceList
            model.operationsInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.operationsInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def operations = new Operations()
            operations.validate()
            controller.save(operations)

        then:"The create view is rendered again with the correct model"
            model.operationsInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            operations = new Operations(params)

            controller.save(operations)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/operations/show/1'
            controller.flash.message != null
            Operations.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def operations = new Operations(params)
            controller.show(operations)

        then:"A model is populated containing the domain instance"
            model.operationsInstance == operations
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def operations = new Operations(params)
            controller.edit(operations)

        then:"A model is populated containing the domain instance"
            model.operationsInstance == operations
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/operations/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def operations = new Operations()
            operations.validate()
            controller.update(operations)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.operationsInstance == operations

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            operations = new Operations(params).save(flush: true)
            controller.update(operations)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/operations/show/$operations.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/operations/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def operations = new Operations(params).save(flush: true)

        then:"It exists"
            Operations.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(operations)

        then:"The instance is deleted"
            Operations.count() == 0
            response.redirectedUrl == '/operations/index'
            flash.message != null
    }
}
