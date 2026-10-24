# Ruleta — Forge 1.21.1

Mod inicial para Minecraft Java 1.21.1 + Forge, Java 21.

## Comando
`/ruleta <color> <titulo> <texto>`

Colores: `rojo`, `azul`, `verde`, `amarillo`, `morado`, `naranja`, `blanco`, `negro`, `rosa`.

El título debe ser una sola palabra; usa guiones bajos para espacios. El texto puede contener espacios.
Ejemplo: `/ruleta rojo Victoria El equipo rojo ha ganado`

El servidor envía la animación a todos los jugadores conectados. El resultado se publica en el chat de cada cliente al terminar la animación.

## Compilar
1. Instala JDK 21.
2. Abre una terminal en esta carpeta.
3. Ejecuta `gradle build` (o usa un Gradle Wrapper generado localmente).
4. El JAR se genera en `build/libs/ruleta-1.0.0.jar`.

## Nota
Este proyecto es una base inicial y debe compilarse/probarse en un entorno Forge 1.21.1. Para jugar en multijugador, instala el JAR tanto en el servidor como en todos los clientes.
