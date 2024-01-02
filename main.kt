
 /* 
Para criar uma lista deixando o código padronizado podemos utilizar o enum
*/
enum class Difficulty{
    EASY, MEDIUM, HARD
  }


/*Tipos genericos é quando você tem varias classes com algumas variaveis iguais e uma ou mais varivel que o tipo vai diferenciar entre elas, para não criar varias classes parecidas, pode usar o genericos para reutilizar uma classe.
Normalmente se utiliza uma letra maiscula para ser o generico.

*/

/*
Como a classe Question não realiza ação, apenas dados, ele pode ser definido como classes de dados, fazendo como que haja uma implementação de alguns métodos de modo automático.

* equals();
* hasCode();
* toString();
* compenentN()
* copy()

Observação: Há classe dados não pode ser abstract, open, sealed ou inner
 */
data class Question<T>(
  val questionText: String,
  val answer: T, 
  val difficulty: Difficulty
)

  
  
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}
 
 
 /*
Singleton é um objeto no qual é criando apenas uma instância, esse objeto tem como objtivo não permitir a criação de duas instâncias ao mesmo tempos, podendo assim gerar um bug na hora.

O Singleton não tem um construtor, as propriedades são definidas dentro das chaves, recebem valor inicial
 */




class Quiz : ProgressPrintable{
    //Ao  utilizar a classe passa o tipo da variavel generico.
      val question1 = Question<String>("Já houve quantas copas do mundo no Brasil?", "2", Difficulty.MEDIUM)
      val question2 = Question<Boolean>("O céu é verde. Verdadeiro ou Falso", false, Difficulty.EASY)
      val question3 = Question<Int>("Quantos dias tem entre as fase da lua?", 28, Difficulty.HARD)
    
      override val progressText: String
            get() = "${answered} of ${total} answered"
    
      companion object StudentProgress{
          var total: Int = 10
          var answered: Int = 3
    }
      
      override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }
      
      fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
    
    
    }

    
fun main() {
    
      val quiz = Quiz()

      quiz.printQuiz()
  
  }