package tacos.domain.db;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import tacos.domain.data.Ingredient;
import tacos.domain.data.Taco;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetIngredientService {

    public void addIngredientList(Model model) {
        List<Ingredient> ingredientList = Arrays.asList(
                new Ingredient("FLTO", "Flour Totilla", Ingredient.Type.WRAP),
                new Ingredient("COTO", "Corn Totilla", Ingredient.Type.VEGGIES),
                new Ingredient("GROB", "Grond Beef", Ingredient.Type.PROTEIN)
        );

        Ingredient.Type[] types = Ingredient.Type.values();
        for (Ingredient.Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterType(ingredientList, type));
        }
        model.addAttribute("taco", new Taco());
    }

    private List<Ingredient> filterType(List<Ingredient> ingredientList, Ingredient.Type type) {
        return ingredientList.stream().filter(ingredient -> ingredient.getTpye().equals(type)).collect(Collectors.toList());
    }
}
