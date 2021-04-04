package jardin.virtual

import telegram.TelegramNotificationBot

class LoginController {
    FamiliarService familiarService
    MaestroService maestroService
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond familiarService.list(params), model:[familiarCount: familiarService.count()]
    }

    def familiar(String id){
        session["user"] = familiarService.get(id)
        redirect (uri:"/webFamilia/")
    }

}
