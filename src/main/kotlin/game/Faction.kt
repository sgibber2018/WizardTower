package game

import display.AlertRed
import display.BrightBlue
import display.GoGreen
import display.White

enum class Faction {
    PLAYER,
    NEUTRAL,
    HOSTILE
    // more nuance to come later with specific factions instead of just relative-to-player.
}

val PlayerColor = GoGreen
val NeutralColor = BrightBlue
val HostileColor = AlertRed
val NoFactionColor = White

val factionColors = mapOf(
    Faction.PLAYER to PlayerColor,
    Faction.NEUTRAL to NeutralColor,
    Faction.HOSTILE to HostileColor,
    null to NoFactionColor,
)
