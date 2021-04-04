package jardin.virtual

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/admin"(view:"/admin")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
