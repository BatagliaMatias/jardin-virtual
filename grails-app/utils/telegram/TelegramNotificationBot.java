package telegram;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.annotation.PreDestroy;
import java.util.HashMap;

/**
 * Clase principal para enviar mensajes via un bot
 * https://telegram.me/userinfobot Se pide el id de usuario
 * https://telegram.me/JardinVirtualBot Hablarle para poder empezar a recibir notificaciones
 */
public class TelegramNotificationBot extends TelegramLongPollingBot {
    private static Logger logger = LoggerFactory.getLogger(TelegramNotificationBot.class);
    private final String userName = "JardinVirtualBot"; //crear clase groovy que pueda leer el properties
    private final String token = "1713697951:AAGQ-VQuxHPxMajIXjIth7ptkX8cRgbrkSA";
    private TelegramBotsApi botsApi;

    public TelegramNotificationBot() {
        //Si la Api de Telegram es nula entonces levanto una instancia
        if (botsApi == null) {
            try {
                botsApi = new TelegramBotsApi(DefaultBotSession.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //Registro el bot
        try {
            this.botsApi.registerBot(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onUpdateReceived(Update update) {
        //System.out.println("Llego update " + update.getMessage().getText());
        //Ver si aca se puede hacer el pedido de usuario
    }

    @Override
    public String getBotUsername() {
        return this.userName;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }

    public NotificationResponse sendMessage(String chatID, String text) {
        SendMessage message = SendMessage.builder().chatId(chatID).text(text).build();
        try {
            execute(message);
            return new NotificationResponse();
        } catch (TelegramApiException e) {
            return new NotificationResponse(e);
        }
    }

    @PreDestroy
    public void preDestroy(){
        try {
            this.clearWebhook();
            System.out.println("Bot destruido");
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }


}