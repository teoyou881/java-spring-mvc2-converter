package hello.typeconverter.controller;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class FormatterController {

  @GetMapping("/formatter/edit")
  public String formatterForm(Model model) {
    Form form = new Form();
    form.setNumber(1000000);
    form.setDate(LocalDateTime.now());
    model.addAttribute("form", form);
    return "formatter-form";
  }

  @PostMapping("/formatter/edit")
  public String formatteredit(@ModelAttribute Form form) {
    return "formatter-view";
  }

  @Data
  static class Form {

    @NumberFormat(pattern = "###,###")
    private Integer number;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
  }
}
