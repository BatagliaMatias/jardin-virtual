package jardin.virtual

import telegram.NotificationResponse
import telegram.TelegramNotificationBot


class BootStrap {

    def init = { servletContext ->
        //1188837417
        //userinfobot
        /**NotificationResponse notificacion = new TelegramNotificationBot().sendMessage("1188837417","Iniciando jardin virtual")//1188837417 yo 999826615 javi
        if(notificacion.hasError()){
            notificacion.getException().printStackTrace()
        }*/
        def familiarJuan = new Familiar(apellido: "Perez",nombre: "Juan", dni: 30123123, mail: "matubat91@gmail.com", telegramId: "1188837417").save()
        def familiarMaria = new Familiar(apellido: "Perez",nombre: "Maria", dni: 30123153, mail: "matubat91@gmail.com", telegramId: "1188837417").save()

        def familiaPerez = new Familia(nombre: "Perez").save()
        def familiaSuarez = new Familia(nombre: "Suarez").save()

        def vinculoJuanPerez = new VinculoPermanente(descripcion: "Padre", familia: familiaPerez, familiar: familiarJuan).save()
        def vinculoMariaPerez = new VinculoPermanente(descripcion: "Madre", familia: familiaPerez, familiar: familiarMaria).save()
        def vinculoMariaSuarez = new VinculoPermanente("descripcion": "Madre", familia: familiaSuarez, familiar:familiarMaria ).save()

        def ninoCarlitos = new Nino(nombre: "Carlitos", apellido: "Perez", familia: familiaPerez).save()
        def ninoJavier = new Nino(nombre: "Javier", apellido: "Suarez", familia: familiaSuarez).save()
    }
    def destroy = {
    }
}
