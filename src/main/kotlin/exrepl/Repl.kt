package exrepl


class Repl(
        var commandReader: CommandReader,
        var commandEvaluator: CommandEvaluator,
        var resultPrinter: ResultPrinter,
        var attrs: MutableMap<String, Any> = mutableMapOf()
) {
    fun <T> attr(key: String) = attrs[key] as T?

    fun <T> attr(key: String, defaultVal: T) = if (attrs.containsKey(key)) attrs[key] else defaultVal

    fun putAttr(key: String, value: Any) {
        attrs[key] = value
    }

    fun start() {
        while (true) {
            val cmd = commandReader.read(this)
            if (Command.Quit == cmd)
                break

            val res = commandEvaluator.evaluate(this, cmd)
            if (Command.Quit == cmd)
                break

            resultPrinter.print(this, res)
        }
    }
}

fun main() {
    val repl = Repl(
            commandReader = SimpleCommandReader(),
            commandEvaluator = SimpleCommandEvaluator(),
            resultPrinter = SimpleResultPrinter(),
    )
    repl.start()
}