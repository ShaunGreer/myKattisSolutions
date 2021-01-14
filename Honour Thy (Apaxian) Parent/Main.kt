fun main(){
    val (y, p) = readLine()!!.split(' ')
    when(y[y.lastIndex]){
        'a', 'i', 'o', 'u' -> println ("${y.substring(0,y.lastIndex)}ex$p")
        'e' -> println("${y}x$p")
        else -> if(y[y.lastIndex] == 'x' && y[y.lastIndex - 1] == 'e')
                    println("$y$p")
                else
                    println("${y}ex$p")
    }
}