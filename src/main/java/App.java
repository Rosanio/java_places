import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("places", request.session().attribute("places"));
      model.put("template", "templates/input.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/result", (request, response) -> {
      HashMap model = new HashMap();

      ArrayList<Place> places = request.session().attribute("places");

      if(places == null) {
        places = new ArrayList<Place>();
        request.session().attribute("places", places);
      }

      String placeName = request.queryParams("enterPlace");
      Place place = new Place(placeName);
      places.add(place);

      model.put("template", "templates/output.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
      // additional pages would go here
  } //Closes "public static void main(String[] args)"

  //public static 'Returntype' 'FuncName' (Paramtype param) {}  //first business logic function

} //Closes "public class App"
