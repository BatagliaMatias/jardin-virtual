package jardin.virtual

import grails.gorm.transactions.Transactional
import telegram.NotificationResponse
import telegram.TelegramNotificationBot

@Transactional
class NotificacionService {
    TelegramNotificationBot telegramNotificationBot = new TelegramNotificationBot()
    def notificar(Familiar familiar, String mensaje) {
        NotificationResponse notificacion = telegramNotificationBot.sendMessage(familiar.getTelegramId(), familiar.toString() + ": " + mensaje)//1188837417
        if(notificacion.hasError()){
            notificacion.getException().printStackTrace()
        }

    }
}
