package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class demoqaTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successfulTests(){
        String name = "Ivan";
        String surname = "Ivanov";
        String email = "Ivanov1258@gmail.com";
        String mobile = "6666666666";
        String subjects = "Maths";
        String address = "Moscow, Petrovka, 38";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");

        $("[id = firstName]").setValue(name);
        $("[id = lastName]").setValue(surname);
        $("[id = userEmail]").setValue(email);
        $("[id = gender-radio-1]").parent().click();
        $("[id = userNumber]").setValue(mobile);

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2000");
        $("[aria-label = 'Choose Thursday, June 1st, 2000']").click();


        $("[id = subjectsInput]").sendKeys(subjects);
        $("[id = subjectsInput]").pressEnter();

        $("[id = hobbies-checkbox-3]").parent().click();

        $("input#uploadPicture").uploadFromClasspath("imeg.jpg");

        $("[id = currentAddress]").setValue(address);

        $("#state").click();
        $("#react-select-3-input").sendKeys("Rajasthan");
        $("#react-select-3-input").pressEnter();

        $("#city").click();
        $("#react-select-4-input").sendKeys("Jaipur");
        $("#react-select-4-input").pressEnter();

        $("[id = submit]").pressEnter();

        $(".modal-content").shouldHave(text(name + " " + surname), text(email), text("Male"), text(mobile),
                text("01 June,2000"), text(subjects), text("Music"), text("imeg.jpg"), text(address),
                text("Rajasthan Jaipur"));
    }
}
