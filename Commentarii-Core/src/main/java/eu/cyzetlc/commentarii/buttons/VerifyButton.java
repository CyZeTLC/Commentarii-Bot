package eu.cyzetlc.commentarii.buttons;

import eu.cyzetlc.commentarii.service.button.Button;
import eu.cyzetlc.commentarii.service.button.annotation.ButtonSpecification;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;

@ButtonSpecification(
        id = "verify",
        label = "Hier verifizieren",
        style = ButtonStyle.LINK
)
public class VerifyButton extends Button {
    @Override
    // The method that is called when the button is clicked.
    public void handleClick(ButtonInteractionEvent event) {
        System.out.println("Name: " + event.getMember().getNickname());
    }

    @Override
    // The URL that is displayed when the button is clicked.
    public String getUrl() {
        return "https://commentarii.cyzetlc.eu/verify/";
    }

    @Override
    // The emoji that is displayed next to the button.
    public String getEmoji() {
        return "\uD83D\uDD17";
    }
}
