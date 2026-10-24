package com.maincranachito.ruleta;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("ruleta")
public class RuletaMod {

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
                                    case "rojo", "red" -> ChatFormatting.RED;
                                    case "azul", "blue" -> ChatFormatting.BLUE;
                                    case "verde", "green" -> ChatFormatting.GREEN;
                                    case "amarillo", "yellow" -> ChatFormatting.YELLOW;
                                    case "naranja", "orange" -> ChatFormatting.GOLD;
                                    case "morado", "purple" -> ChatFormatting.DARK_PURPLE;
                                    case "rosa", "pink" -> ChatFormatting.LIGHT_PURPLE;
                                    case "blanco", "white" -> ChatFormatting.WHITE;
                                    case "negro", "black" -> ChatFormatting.BLACK;
                                    default -> ChatFormatting.GRAY;
                                };

                                MutableComponent mensaje = Component.literal(titulo)
                                    .withStyle(style -> style.withColor(color).withBold(true))
                                    .append(Component.literal(" " + texto)
                                        .withStyle(ChatFormatting.WHITE));

                                ctx.getSource().getServer()
                                    .getPlayerList()
                                    .broadcastSystemMessage(mensaje, false);

                                return 1;
                            })
                        )
                    )
                )
        );
    }
}

                                }
