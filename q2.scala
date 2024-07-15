// Book definition
// imutable set
case class Book(title:String, author:String, isbn:String)

// Library Management
var bookRak: Set[Book] = Set(
Book("Madol duwa", "Martin wickramasinghe", "000001"),
Book("Sudo sudu", "Keyas", "000002"),
Book("Amma", "Sannasgala", "000003"),
Book("Hath pana", "Kumarathunga Munidasa", "000004")
)

//Add a new book to the library.
def addBook(book:Book): Unit={
    bookRak += book
    println{"\nNew book added to the library."}
    println{s"It is ${book.title} by ${book.author}."}
}

// Remove books using their isbn number
def removeBook(newisbn: String): Unit={

    bookRak.find(_.isbn == newisbn) match {          // This find method return first match of the book only
        
        case Some(gotbook) =>
            println(s"\n${gotbook.title} by ${gotbook.author} is removed from library.")
            bookRak -= gotbook
        
        case None => println(s"\nThere is no book with $newisbn isbn in library.")
        }
    }

//Check if a book is already in the library by its ISBN.
def checkBook(newisbn: String):Boolean={     // for adminstrator
 bookRak.find(_.isbn == newisbn) match {         
        case Some(_) => true
        case None => false
    }
}

//Functionalities to Implement:
//Display the current library collection with details of each book (title, author, ISBN).
def viewBooks():Unit={
    var i = 1
    if(bookRak.isEmpty){
        println("\nNo books in library.")
    }
    else{
      println("\n-------- Welcome to library.These are the available books for you. ----------")
      println("   Title             Author          Isbn")

      bookRak.foreach{
      book => println(s"$i. ${book.title}  ${book.author} ${book.isbn}")
        i += 1
      }
    }
}

//Allow the user to search for a book by its title and display its details if found
def searchBook(newtitle: String):Unit={
 bookRak.find(_.title == newtitle) match { 

        case Some(gotbook) =>
            println(s"\n${gotbook.title} by ${gotbook.author} with ISBN : ${gotbook.isbn}.")

        case None => println(s"\nThere is no book with $newtitle in library.")
        }
}

//Display all books by a specific author.
def searchByAuthor(newauthor: String): Unit = {
  var i = 1
  var flag = 0
  if (bookRak.isEmpty) {
    println("\nNo books in the library.")
  } else {
    bookRak.foreach { book =>
      if (book.author == newauthor) {
        if (flag != 1) {
          println(s"\nThese are the available books by author $newauthor in the library:")
          flag = 1
        }
        println(s"$i. ${book.title}  ${book.author} ${book.isbn}")
        i += 1
      }
    }
  }
}

def main(args:Array[String]): Unit={
  viewBooks()
  addBook(Book("Baskawil Shapaya", "Chandana Mendis", "000005"))
  addBook(Book("Magul Kama", "Kumarathunga Munidasa", "000006"))
  viewBooks()
  removeBook("000003")
  var temp = checkBook("000002")
  println(temp)
  viewBooks()
  searchBook("Madol duwa")
  searchByAuthor("Kumarathunga Munidasa")
}