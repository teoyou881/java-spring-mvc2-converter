package hello.typeconverter;


import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  //The WebConversionService, which extends DefaultFormattingConversionService, is used internally.
  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(new StringToIpPortConverter());
    registry.addConverter(new IpPortToStringConverter());

    /*
     * In Spring, type conversion is handled through the ConversionService,
     * and if a suitable Converter exists, it will be used first;
     * only when no such Converter is available will Spring fall back to using a Formatter.
     * */
//    registry.addConverter(new StringToIntegerConverter());
//    registry.addConverter(new IntegerToStringConverter());
    registry.addFormatter(new MyNumberFormatter());
  }
}
