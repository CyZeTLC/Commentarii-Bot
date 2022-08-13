package eu.cyzetlc.commentariis.commands;

import eu.cyzetlc.commentariis.Commentarii;
import eu.cyzetlc.commentariis.service.command.Command;
import eu.cyzetlc.commentariis.service.command.annotation.CommandSpecification;
import eu.cyzetlc.commentariis.service.entities.Embed;
import eu.cyzetlc.commentariis.service.entities.User;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

import java.awt.*;

@CommandSpecification(
        command = "broadcast",
        description = "Broadcast a message on every guild"
)
public class BroadcastCommand extends Command {
    @Override
    public void initialize(CommandSpecification spec) {
        super.initialize(spec);
        this.getCommandData().addOptions(new OptionData(OptionType.STRING, "text", "The broadcast content").setRequired(true));
    }

    @Override
    // This is the method that is called when the command is executed.
    public void onCommand(User user, SlashCommandEvent event, TextChannel channel, String[] args) {
        if (user.getJdaUser().getId().equals("516929484469829632")) {
            if (event.getOption("text") != null) {
                String text = event.getOption("text").getAsString();

                for (Guild guild : Commentarii.getInstance().getJda().getGuilds()) {
                    Commentarii.getInstance().getLogHandler().getLogChannelOfGuild(guild.getIdLong()).sendMessageEmbeds(
                            Embed.getEmbed(
                                    "**GLOBAL-NOTIFY**",
                                    text,
                                    Color.ORANGE
                            ).appendDescriptions("\n\n**Von:** " + user.getJdaUser().getAsMention())
                                    .addThumbnail("https://img.cyzetlc.eu/289673858e06dfa2e0e3a7ee610c3a30").build()
                    ).queue();
                }
                this.sendEmbed(Embed.getEmbed(
                        "**Hura**",
                        Commentarii.getInstance().getMessageHandler().getStaticMessage("commentarii.broadcast.success"),
                        Color.GREEN
                ));
            }
        } else {
            this.sendEmbed(Embed.getEmbed("**Ups**", "You're not allowed to execute this command!", Color.RED));
        }
    }
}