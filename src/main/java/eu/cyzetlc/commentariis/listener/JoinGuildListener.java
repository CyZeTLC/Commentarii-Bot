package eu.cyzetlc.commentariis.listener;

import eu.cyzetlc.commentariis.Commentarii;
import eu.cyzetlc.commentariis.buttons.InviteMeButton;
import eu.cyzetlc.commentariis.service.entities.Embed;
import eu.cyzetlc.commentariis.service.log.LogHandler;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;

public class JoinGuildListener extends ListenerAdapter {
    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        Commentarii.getInstance().getLogHandler().log(
                null,
                "Joined new guild: " + event.getGuild().getName(),
                LogHandler.LogLevel.INFO,
                -1,
                Commentarii.log
        );
        Commentarii.getInstance().getButtonHandler().sendEmbedWithButtons(
                Embed.getEmbed(
                        "**Moin!**",
                        "Ich freue mich, dass ihr euch für mich entschieden habt \uD83D\uDC4C.\nBenutzt einfach `/logchannel` um den Bot einzustellen.\nMit `/language` könnt ihr auch die Sprache einstellen.",
                        Color.GREEN
                ).addThumbnail("https://images-ext-2.discordapp.net/external/oNXuCm11RxiK0DwK24H8JZn3P7MhfPIoxbnYNAfxtu8/https/images-ext-2.discordapp.net/external/PO8n6i-T0Pb0hEGlitshd0iYGsEHfVmIlSyQ5eY5lok/https/emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/google/223/party-popper_1f389.png"),
                List.of(new InviteMeButton()),
                event.getGuild().getDefaultChannel().asTextChannel(),
                false
        );
        Commentarii.getInstance().getLogHandler().apply(event.getGuild(), event.getGuild().getDefaultChannel().asTextChannel());
    }
}
