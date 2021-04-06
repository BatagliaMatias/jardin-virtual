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

        def ninoCarlitos = new Nino(edad: 5, nombre: "Carlitos", apellido: "Perez", familia: familiaPerez).save()
        def ninoJavier = new Nino(edad: 3, nombre: "Javier", apellido: "Suarez", familia: familiaSuarez).save()

        def maestroJirafales = new Maestro(nombre: "Rubén",apellido: "Jirafales").save()
        def maestroRamon = new Maestro(nombre: "Ramon", apellido:"Valdés").save()

        def salitaDe3 = new Salita(nombre:"Salita de 3",edadMinima: 3,edadMaxima: 3,cupoMaximo: 5).save()
        def salitaDe3y4 = new Salita(nombre:"Salita de 3 y 4",edadMinima: 3,edadMaxima: 4,cupoMaximo: 5).save()
        def salitaDeLlena = new Salita(nombre:"Salita llena",edadMinima: 3,edadMaxima: 4,cupoMaximo: 0).save()
        def salitaDe5 = new Salita(nombre:"Salita de 5",edadMinima: 5,edadMaxima: 5,cupoMaximo: 1).save()

        def maestroJirafalesDe3 = new MaestroSalita(maestro: maestroJirafales,salita: salitaDe3).save()
        def maestroRamonDe3 = new MaestroSalita(maestro: maestroRamon,salita: salitaDe3).save()
        def maestroJirafalesDe3y4 = new MaestroSalita(maestro: maestroJirafales,salita:salitaDe3y4).save()
        def maestroRaminDe5 = new MaestroSalita(maestro: maestroRamon, salita: salitaDe5).save()

    }
    def destroy = {
    }
}
