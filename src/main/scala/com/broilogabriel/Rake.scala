package com.broilogabriel

object Rake {

  val stopsRegex: String = SmartStops.wordList.map(w => s"\\b$w(?![\\w-])").mkString("|")

  val delimiters = "[.!?,;:\t\\\\\"\\(\\)\\\'\u2019\u2013]|\\s\\-\\s"

  def run(text: String): Map[String, Double] = {
    val phraseList = text
      .split(delimiters)
      .flatMap(s => s.toLowerCase.split(stopsRegex).map(_.trim))
      .filterNot(w => w.isEmpty || w == " ")
    val scores = phraseList
      .map(separateWords)
      .flatMap(words => words.map((_, words.length - 1)))
      .groupBy(_._1)
      .map {
        case (word, l) =>
          val score = (l.length + l.map(_._2).sum) / (l.length * 1D)
          word -> score
      }
    phraseList
      .map(phrase => phrase -> separateWords(phrase).map(scores(_)).sum)
      .toMap
  }

  private def separateWords(phrase: String): Array[String] = {
    phrase.split("[^a-zA-Z0-9_\\+\\-/]")
      .filter(w => w.nonEmpty && !w.matches("^\\d+$"))
//      .map(_.toLowerCase.trim)
  }

}



