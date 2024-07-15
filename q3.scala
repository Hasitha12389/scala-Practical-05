import scala.io.StdIn.readInt
def fibonacci(n: Int): Int=n match{         // number which is sum of previous numbers is fibonacci sequence 
    case 0 => 0
    case x if x==1 => 1
    case _ => fibonacci(n-1) + fibonacci(n-2)
}

def fibonacciSequence(n: Int): Unit = {
    if(n>=0){
        fibonacciSequence(n-1)
        println(fibonacci(n))
    }
}

def main(args: Array[String]): Unit={
    println("Enter your Intger : ");
    var n = readInt()
    println(s"\nFibonacci Sequence of $n is: ")
    fibonacciSequence(n)
    println("\n")
}