package com.synchr.interceptorDemo

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
//        "500"(view:'/error')
//        "404"(view:'/notFound')
//        "400"(view:'/error')
    }
}
