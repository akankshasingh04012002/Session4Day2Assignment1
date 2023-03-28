import org.scalatest.matchers.must.Matchers
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class URLParserTest extends AnyFlatSpec with Matchers {

  it should "correctly parse a valid URL with subdomain" in {
    val url = "https://www.facebook.com/login/"
    URLParser.unapply(new URLParser(url)) should be(Some("https", "www.facebook.com", "/login/"))
  }

  it should "parse a valid HTTP URL correctly" in {
    val url = "http://www.example.com/path/to/resource"
    URLParser.unapply(new URLParser(url)) should be(Some("http", "www.example.com", "/path/to/resource"))
  }

  it should "parse a valid HTTPS URL correctly" in {
    val url = "https://www.instagram.com/login"
    URLParser.unapply(new URLParser(url)) should be(Some("https", "www.instagram.com", "/login"))
  }

  it should "parse a valid FTP URL correctly" in {
    val url = "ftp://ftp.example.com/path/to/resource"
    URLParser.unapply(new URLParser(url)) should be(Some("ftp", "ftp.example.com", "/path/to/resource"))
  }

  it should "return None for an invalid URL" in {
    val url = "invalid-url"
    URLParser.unapply(new URLParser(url)) should be(None)
  }

  it should "not parse a URL with invalid domain and return None" in {
    val url = "https:/invalid-domain.com"
    URLParser.unapply(new URLParser(url)) should be(None)
  }

}
