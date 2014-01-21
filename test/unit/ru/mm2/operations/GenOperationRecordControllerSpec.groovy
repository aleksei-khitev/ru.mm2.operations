package ru.mm2.operations



import grails.test.mixin.*
import spock.lang.*

@TestFor(GenOperationRecordController)
@Mock(GenOperationRecord)
class GenOperationRecordControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when: "The index action is executed"
        controller.index()

        then: "The model is correct"
        !model.genOperationRecordInstanceList
        model.genOperationRecordInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when: "The create action is executed"
        controller.create()

        then: "The model is correctly created"
        model.genOperationRecordInstance != null
    }

    void "Test the save action correctly persists an instance"() {

        when: "The save action is executed with an invalid instance"
        def genOperationRecord = new GenOperationRecord()
        genOperationRecord.validate()
        controller.save(genOperationRecord)

        then: "The create view is rendered again with the correct model"
        model.genOperationRecordInstance != null
        view == 'create'

        when: "The save action is executed with a valid instance"
        response.reset()
        populateValidParams(params)
        genOperationRecord = new GenOperationRecord(params)

        controller.save(genOperationRecord)

        then: "A redirect is issued to the show action"
        response.redirectedUrl == '/genOperationRecord/show/1'
        controller.flash.message != null
        GenOperationRecord.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when: "The show action is executed with a null domain"
        controller.show(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the show action"
        populateValidParams(params)
        def genOperationRecord = new GenOperationRecord(params)
        controller.show(genOperationRecord)

        then: "A model is populated containing the domain instance"
        model.genOperationRecordInstance == genOperationRecord
    }

    void "Test that the edit action returns the correct model"() {
        when: "The edit action is executed with a null domain"
        controller.edit(null)

        then: "A 404 error is returned"
        response.status == 404

        when: "A domain instance is passed to the edit action"
        populateValidParams(params)
        def genOperationRecord = new GenOperationRecord(params)
        controller.edit(genOperationRecord)

        then: "A model is populated containing the domain instance"
        model.genOperationRecordInstance == genOperationRecord
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when: "Update is called for a domain instance that doesn't exist"
        controller.update(null)

        then: "A 404 error is returned"
        response.redirectedUrl == '/genOperationRecord/index'
        flash.message != null


        when: "An invalid domain instance is passed to the update action"
        response.reset()
        def genOperationRecord = new GenOperationRecord()
        genOperationRecord.validate()
        controller.update(genOperationRecord)

        then: "The edit view is rendered again with the invalid instance"
        view == 'edit'
        model.genOperationRecordInstance == genOperationRecord

        when: "A valid domain instance is passed to the update action"
        response.reset()
        populateValidParams(params)
        genOperationRecord = new GenOperationRecord(params).save(flush: true)
        controller.update(genOperationRecord)

        then: "A redirect is issues to the show action"
        response.redirectedUrl == "/genOperationRecord/show/$genOperationRecord.id"
        flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when: "The delete action is called for a null instance"
        controller.delete(null)

        then: "A 404 is returned"
        response.redirectedUrl == '/genOperationRecord/index'
        flash.message != null

        when: "A domain instance is created"
        response.reset()
        populateValidParams(params)
        def genOperationRecord = new GenOperationRecord(params).save(flush: true)

        then: "It exists"
        GenOperationRecord.count() == 1

        when: "The domain instance is passed to the delete action"
        controller.delete(genOperationRecord)

        then: "The instance is deleted"
        GenOperationRecord.count() == 0
        response.redirectedUrl == '/genOperationRecord/index'
        flash.message != null
    }
}
