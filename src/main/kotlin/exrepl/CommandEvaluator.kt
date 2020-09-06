package exrepl

interface CommandEvaluator {
    fun evaluate(repl: Repl, cmd: Command): Any?
}

class SimpleCommandEvaluator(
        private val handlers: MutableMap<String, CommandEvaluator> = mutableMapOf()
) : CommandEvaluator {

    init {
        val getArgs = object : CommandEvaluator {
            override fun evaluate(repl: Repl, cmd: Command): Any? {
                return cmd.args
            }
        }
        register(Keys.echo, getArgs)
        register(Keys.run, getArgs)
    }

    fun register(name: String, handler: CommandEvaluator) {
        handlers[name] = handler
    }

    override fun evaluate(repl: Repl, cmd: Command): Any? {

        val handler = handlers[cmd.name]
        return handler?.evaluate(repl, cmd) ?: cmd.args
    }
}