package ru.mm2.operations

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(OperationsTagLib)
class OperationsTagLibSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        def domain = grailsApplication.getDomainClass("ru.mm2.operations.OperationRecord")
        assert domain
    }
}
