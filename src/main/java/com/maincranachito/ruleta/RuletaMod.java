package com.maincranachito.ruleta;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("ruleta")
public class RuletaMod {
public RuletaMod() {
}

@Mod.EventBusSubscriber
public static class Commands {
    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(
            net.minecraft.commands.Commands.literal("ruleta")
                .then(net.minecraft.commands.Commands.argument("color", StringArgumentType.word())
                    .then(net.minecraft.commands.Commands.argument("titulo", StringArgumentType.string())
                        .then(net.minecraft.commands.Commands.argument("texto", StringArgumentType.greedyString())
                            .executes(ctx -> {
                                String colorName = StringArgumentType.getString(ctx, "color");
                                String titulo = StringArgumentType.getString(ctx, "titulo");
                                String texto = StringArgumentType.getString(ctx, "texto");

                                ChatFormatting color = switch (colorName.toLowerCase()) {
                                    case "rojo" -> ChatFormatting.RED;
                                    case "azul" -> ChatFormatting.BLUE;
                                    case "verde" -> ChatFormatting.GREEN;
                                    case "amarillo" -> ChatFormatting.YELLOW;
                                    case "naranja" -> ChatFormatting.GOLD;
                                    case "morado" -> ChatFormatting.DARK_PURPLE;
                                    case "rosa" -> ChatFormatting.LIGHT_PURPLE;
                                    case "blanco" -> ChatFormatting.WHITE;
                                    case "negro" -> ChatFormatting.BLACK;
                                    default -> ChatFormatting.GRAY;
                                };

                                MutableComponent mensaje = Component.literal(titulo)
                                    .withStyle(style -> style.withColor(color).withBold(true))
                                    .append(Component.literal(" " + texto)
                                        .withStyle(ChatFormatting.WHITE));

                                ctx.getSource().getServer().getPlayerList().broadcastSystemMessage(mensaje, false);
                                return 1;
                            })
                        )
                    )
                )
        );
    }
}

                                                    }
