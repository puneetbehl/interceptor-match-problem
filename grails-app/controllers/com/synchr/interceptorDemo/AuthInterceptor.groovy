package com.synchr.interceptorDemo

import groovy.transform.CompileStatic

@CompileStatic
class AuthInterceptor {

    AuthInterceptor() {
        def mn = match(controller: /.*/)
                .excludes(controller: /asset|password|user|welcome|error/)
                .excludes(namespace:  /api-1_0/)
                .excludes(namespace:  /ns-api-1_0/)

        mn
    }

    boolean before() {
        println "Executing before ..."
    }

    boolean after() {
    }

    void afterView() {
        // no-op
    }
}
