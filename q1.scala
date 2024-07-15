import scala.io.StdIn.readLine

def getProductList(): List[String]={
  var listOfProduct :List[String] = Nil       // List data type variable and cannot declare empty list got an error.
  var input = ""                           // input is String data type mutable variable with assing empty string to it for future use.
  var count = 1

  println("\n--------  Enter your product names(If you want to finish enter \"done\") ----------  ");
    while(input != "done"){
    input = readLine(s"Enter product $count : ")     // s - string interpolation 
    if(input != "done"){
    listOfProduct = listOfProduct :+ input        // :+ means append one item to the list
    count += 1
    }
}
  // return the given list
  listOfProduct
}

def printProductList(list:List[String]): Unit={
  var i = 1;
  if(list.isEmpty){          
    println("\nThere is no products in this list.")     // \n for new line
  }
  else{
    println("\n------ Product list -----------")
    list.foreach{
    a => println(s"$i. $a")                     // This is lambda function and it will get each element of the list and do given task
    i += 1
    }
  }
}

def getTotalProducts(list:List[String]): Int={
    if(list.isEmpty){
        0
    } 
    else{
        list.length
    }
}

def main(args: Array[String]): Unit={
  val list = getProductList() 
  printProductList(list)  
  val listLength = getTotalProducts(list)
  println(s"\nYour entered $listLength products.\n")                                 
}