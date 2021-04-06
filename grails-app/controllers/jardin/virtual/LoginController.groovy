package jardin.virtual

import telegram.TelegramNotificationBot

class LoginController {
    FamiliarService familiarService
    MaestroService maestroService
    def index(Integer max) {
       respond model:[familiares: familiarService.list(), maestros:maestroService.list(), familiarCount: familiarService.count()]
    }

    def familiar(String id){
        session["user"] = familiarService.get(id)
        redirect (uri:"/webFamilia/")
    }

    def maestro(String id){
        session["user"] = maestroService.get(id)
        redirect (uri:"/webMaestro/maestro/")
    }

}
