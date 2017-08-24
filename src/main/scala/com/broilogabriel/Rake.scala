package com.broilogabriel

object Rake {

  val stopsRegex: String = SmartStops.wordList.map(w => s"\\b$w(?![\\w-])").mkString("|")

  val delimiters = "[.!?,;:\t\\\\\"\\(\\)\\\'\u2019\u2013]|\\s\\-\\s"

  def run(text: String) = {
    text.split(delimiters).flatMap(s => s.split(stopsRegex)).filterNot(w => w.isEmpty || w == " ")
    // TODO calculate_word_scores
  }

}
