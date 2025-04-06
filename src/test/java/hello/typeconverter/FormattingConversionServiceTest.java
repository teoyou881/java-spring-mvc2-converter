package hello.typeconverter;

import static org.assertj.core.api.Assertions.assertThat;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormattingConversionServiceTest {

  @Test
  void formattingConversionService() {
    DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

    //register converters
    conversionService.addConverter(new StringToIpPortConverter());
    conversionService.addConverter(new IpPortToStringConverter());
    //register formatter
    conversionService.addFormatter(new MyNumberFormatter());

    //use converter
    IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
    assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));
    //use formatter
    assertThat(conversionService.convert(1000, String.class)).isEqualTo("1,000");
    assertThat(conversionService.convert("1,000", Long.class)).isEqualTo(1000L);
  }
}
