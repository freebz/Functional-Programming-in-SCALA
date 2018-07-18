def string(w: String): Parser[String] = {
  val msg = "'" + w + "'"
  s => {
    val i = firstNonmatchingIndex(s.loc.input, w, s.loc.offset)
    if (i == -1)
      Success(w, w.length)
    else
      Failure(s.loc.advanceBy(i).toError(msg), i != 0)
  }
}
