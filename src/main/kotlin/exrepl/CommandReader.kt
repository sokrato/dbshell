package exrepl


interface CommandReader {
    fun read(repl: Repl): Command
}

class SimpleCommandReader : CommandReader {
    private val console = System.console()

    override fun read(repl: Repl): Command {
        console.printf("> ")
        val line = console.readLine()
        if (line == null || line.isEmpty() || line == Keys.quit)
            return Command.Quit
        return Command(Keys.echo, line.trim())
    }
}