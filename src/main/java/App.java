import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/input.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/result", (request, response) -> {
      String textInput = request.queryParams("enterPlace");

      //call business logic functions here
      String result = textInput;

      HashMap model = new HashMap();
      model.put("template", "templates/output.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
      // additional pages would go here
  } //Closes "public static void main(String[] args)"

  //public static 'Returntype' 'FuncName' (Paramtype param) {}  //first business logic function

} //Closes "public class App"
