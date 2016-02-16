import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Enter place:");
  }

  @Test
  public void submitPlaceTest() {
    goTo("http://localhost:4567/");
    fill("#enterPlace").with("Portland");
    submit(".btn");
    assertThat(pageSource()).contains("You entered a place.");
  }




/*
  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Enter change:");
  }
  @Test
  public void getChange() {
    goTo("http://localhost:4567");
    fill("#userChange").with("87");
    submit(".btn");
    assertThat(pageSource()).contains("Your change for 87 cents is 3 quarters, 1 dime, 2 pennies.");
  }
  @Test
  public void negativeNumber() {
    goTo("http://localhost:4567");
    fill("#userChange").with("-87");
    submit(".btn");
    assertThat(pageSource()).contains("Please enter a positive value");
  }
*/

}
