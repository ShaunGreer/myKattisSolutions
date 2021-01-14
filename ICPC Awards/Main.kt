fun main(){
    val n:Int = readLine()!!.toInt()
    val awardedUnis = mutableListOf<String>()
    for(i in 1..n){
        if(awardedUnis.size == 12)
            break
        val line: List<String> = readLine()!!.split(' ')
        val currentUni = line[0]; val currentTeam = line[1]
        if(!awardedUnis.contains(currentUni)){
            awardedUnis.add(currentUni)
            println("$currentUni $currentTeam")
        }
    }
}