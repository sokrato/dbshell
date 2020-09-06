package exrepl


interface ResultPrinter {
    fun print(repl: Repl, res: Any?)
}

class SimpleResultPrinter(
        private var counter: Int = 0
) : ResultPrinter {
    override fun print(repl: Repl, res: Any?) {
        if (res != null) {
            ++counter
            println("[$counter] $res")
        }
    }
}