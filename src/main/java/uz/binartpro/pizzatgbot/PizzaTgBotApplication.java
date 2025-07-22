package uz.binartpro.pizzatgbot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.binartpro.pizzatgbot.bot.Responder;

@SpringBootApplication
@Slf4j
public class PizzaTgBotApplication {

    public static void main(String[] args) throws TelegramApiException {
        var context = SpringApplication.run(PizzaTgBotApplication.class, args);
        log.info("Starting TelegramBotExampleApplication");
        var telegramBotApi = new TelegramBotsApi(DefaultBotSession.class);
        log.info("Registering Bot");
        telegramBotApi.registerBot(context.getBean(Responder.class));
        log.info("Bot started");
    }

}
