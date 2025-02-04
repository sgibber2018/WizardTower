package game

/**
 * A pseudo-Actor which exists in the geography of the game world and may be optionally attached to an Actor.
 * This helps to enable a scrolling camera interface.
 */
class Camera(
    var coordinates: Coordinates,
    var coupledToOrNull: Character? = null,
) {
    /**
     * Couples the Camera to the given actor until decoupled.
     */
    fun coupleTo(character: Character) {
        coupledToOrNull = character
    }

    /**
     * Decouples the camera from an actor.
     */
    fun decouple() {
        coupledToOrNull = null
    }

    /**
     * Moves the camera.
     */
    fun move(
        direction: Direction,
        tilemap: Tilemap,
    ): Boolean {
        val target = Coordinates(
            x = coordinates.x + direction.dx,
            y = coordinates.y + direction.dy
        )
        var moved = false
        tilemap
            .getTileOrNull(target)
            ?.let {
                coordinates = target
                moved = true
            }
        return moved
    }

    /**
     * Snaps to the coupled Actor (does nothing if no coupled actor).
     */
    fun snap() {
        coordinates = coupledToOrNull?.coordinates ?: coordinates
    }

    /**
     * "Snaps" the camera to the given newCoordiantes.
     */
    fun snapTo(newCoordinates: Coordinates) {
        coordinates = newCoordinates
    }
}