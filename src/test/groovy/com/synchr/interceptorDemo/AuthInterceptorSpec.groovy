package com.synchr.interceptorDemo

import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.web.InterceptorUnitTestMixin
import spock.lang.Specification

@TestFor(AuthInterceptor)
@TestMixin(InterceptorUnitTestMixin)
class AuthInterceptorSpec extends Specification {

    def interceptor

    void setup() {
        request.contextPath = '/synchr'
        interceptor = mockInterceptor(AuthInterceptor)
    }

    void "Test auth interceptor matching"() {
        when: "A request matches the interceptor"
        withRequest(controller: "auth")

        then: "The interceptor does match"
        interceptor.doesMatch()
    }

    void "Test auth interceptor excludes"() {
        when: "A exclude request does not matches the interceptor"
        withRequest(controller: controllerName)

        then: "The interceptor does not match"
        !interceptor.doesMatch()

        where:
        controllerName << ['asset', 'password', 'user', 'welcome', 'error']
    }

    void "Test request uri does match"() {
        when: "A request matches the interceptor"
        withRequest(controller: 'admin', action: 'trace', parameters: ['t':'Trace123453623145.html'])

        then: "The interceptor does match"
        interceptor.doesMatch()
    }
}
