package jardin.virtual

import grails.gorm.transactions.Transactional
import telegram.NotificationResponse
import telegram.TelegramNotificationBot

@Transactional
class NotificacionService {

    def notificar(Familiar familiar, String mensaje) {
        NotificationResponse notificacion = new TelegramNotificationBot().sendMessage(familiar.getTelegramId(),mensaje)//1188837417
        if(notificacion.hasError()){
            notificacion.getException().printStackTrace()
        }

    }
}
