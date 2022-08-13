package eu.cyzetlc.commentariis.listener;

import eu.cyzetlc.commentariis.Commentarii;
import eu.cyzetlc.commentariis.service.command.Command;
import eu.cyzetlc.commentariis.service.entities.Embed;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class CommandListener extends ListenerAdapter {
    @Override
    // This is a method that is called when a slash command is used.
    public void onSlashCommand(@NotNull SlashCommandEvent e) {
        String cmd = e.getName();
        String msg = e.getCommandString();

        if (e.isFromGuild()) {
            Command command = Commentarii.getInstance().getCommandHandler().getCommand(cmd);
            OptionMapping option = e.getOption("args");

            if (command != null) {
                command.execute(new eu.cyzetlc.commentariis.service.entities.User(e.getUser()), e, e.getTextChannel(), option != null ?
                        option.getAsString().split(" ") : msg.split(" "));
            } else {
                e.getTextChannel().sendMessageEmbeds(Embed.getEmbed("**Ups!**", "Dieser Command wurde nicht gefunden!", Color.RED).build())
                        .queue(message -> message.delete().queueAfter(5, TimeUnit.SECONDS));
            }
        } else {
            e.reply("Bitte verwende diesen Command über einen Discord-Server").queue();
        }
    }
}