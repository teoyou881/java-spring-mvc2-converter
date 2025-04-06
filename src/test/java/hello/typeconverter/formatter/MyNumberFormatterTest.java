package hello.typeconverter.formatter;

import java.text.ParseException;
import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyNumberFormatterTest {

  MyNumberFormatter formatter = new MyNumberFormatter();

  @Test
  void parse() throws ParseException {
    Number result = formatter.parse("2,000", Locale.KOREA);
    Assertions.assertThat(result)
              .isEqualTo(2000L);
  }

  @Test
  void print() {
    String result = formatter.print(2000, Locale.CANADA);
    Assertions.assertThat(result)
              .isEqualTo("2,000");
  }
}