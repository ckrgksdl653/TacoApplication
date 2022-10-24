package tacos.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tacos.domain.data.Ingredient;
import tacos.domain.data.Taco;
import tacos.domain.db.GetIngredientService;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/design")
public class DesignTacoController {
    private final GetIngredientService getIngredientService;

    @GetMapping
    public String showDesignForm(Model model) {
        getIngredientService.addIngredientList(model);
        return "design";
    }

    @PostMapping
    public String processDesign(Taco design, Errors errors) {
        if (errors.hasErrors()) {
            return "design";
        }

        log.info("Processing design: {}", design);
        return "redirect:/orders/current";
    }
}
