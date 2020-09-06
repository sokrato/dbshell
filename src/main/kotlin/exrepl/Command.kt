package exrepl

data class Command(
    val name: String,
    val args: Any?
) {
    companion object {
        val Quit = Command(Keys.quit, Unit)
    }
}