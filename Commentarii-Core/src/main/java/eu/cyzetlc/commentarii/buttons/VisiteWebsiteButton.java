package eu.cyzetlc.commentarii.buttons;

import eu.cyzetlc.commentarii.service.button.Button;
import eu.cyzetlc.commentarii.service.button.annotation.ButtonSpecification;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;

@ButtonSpecification(
        id = "visitWebsite",
        label = "Besuche mal meine Webseite",
        style = ButtonStyle.PRIMARY
)
public class VisiteWebsiteButton extends Button {
    @Override
    // The method that is called when the button is clicked.
    public void handleClick(ButtonInteractionEvent event) {
    }

    @Override
    // The URL that is displayed when the button is clicked.
    public String getUrl() {
        return "https://github.com/CyZeTLC/Commentarii-Bot";
    }

    @Override
    // The emoji that is displayed next to the button.
    public String getEmoji() {
        return "\uD83D\uDD17";
    }
}
