fun main(){
    val cipher:String = readLine()!!
    var count = 0
    var index = 0
    for(letter:Char in cipher){
        when(index % 3){
            0 -> if(letter != 'P')
                count++
            1 -> if(letter != 'E')
                count++
            else -> if(letter != 'R')
                count++
        }
        index++
    }
    println(count)
}