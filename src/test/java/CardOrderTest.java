import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CardOrderTest {
    @Test
    void shouldRegister() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue("Челябинск");
        LocalDate date = LocalDate.now().plusDays(3);
        $("[data-test-id = 'date'] .input__control").setValue(String.valueOf(date));
        $("[name = 'name']").setValue("Иванов Илья");
        $("[name = 'phone']").setValue("+79048042065");
        $("[data-test-id='agreement']").click();
        $$("button").find(exactText("Забронировать")).click();
        $("[data-test-id = 'notification']").shouldBe(visible, Duration.ofSeconds(15));

    }

}