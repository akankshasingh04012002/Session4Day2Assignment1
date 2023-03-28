import scala.util.Try

class URLParser(val urlOfString: String) {

}

object URLParser {

  def unapply(url: URLParser): Option[(String, String, String)] = {
    Try {
      val protocolSeparator = url.urlOfString.indexOf("://")
      if (protocolSeparator > 0) {
        val protocol = url.urlOfString.substring(0, protocolSeparator)
        if (protocol == "http" || protocol == "https" || protocol == "ftp") {
          val domainSeparator = url.urlOfString.indexOf("/", protocolSeparator + 3)
          val domain = if (domainSeparator > 0) url.urlOfString.substring(protocolSeparator + 3, domainSeparator)
          else url.urlOfString.substring(protocolSeparator + 3)
          val path = if (domainSeparator > 0) url.urlOfString.substring(domainSeparator)
          else "/"
          Some(protocol, domain, path)
        } else {
          None
        }
      } else {
        None
      }
    }.getOrElse(None)
  }

  def urlMatching(url: String): String = {
    val urlParser = new URLParser(url)
    urlParser match {
      case URLParser(protocol, domain, path) =>
        s"Protocol: $protocol\n Domain: $domain\n Path: $path"
      case _ => "Invalid URL"
    }
  }

}

