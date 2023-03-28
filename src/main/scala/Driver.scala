object Driver extends App {
  val urlParserObj  = URLParser
  val url = "https://knoldus.keka.com/#/home/dashboard"
  println(urlParserObj.urlMatching(url))
}