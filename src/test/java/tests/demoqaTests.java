package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

class DemoqaTests {

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
        executeJavaScript("$('#close-fixedban').remove()");

        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2000");
        $("[aria-label = 'Choose Thursday, June 1st, 2000']").click();
        $("#subjectsInput").sendKeys(subjects);
        $("#subjectsInput").pressEnter();
        $("#hobbies-checkbox-3").parent().click();
        $("input#uploadPicture").uploadFromClasspath("imeg.jpg");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#react-select-3-input").setValue("Rajasthan");
        $("#react-select-3-input").pressEnter();
        $("#city").click();
        $("#react-select-4-input").sendKeys("Jaipur");
        $("#react-select-4-input").pressEnter();
        $("#submit").pressEnter();

        $(".modal-content").shouldHave(text(name + " " + surname),
                text(email),
                text("Male"),
                text(mobile),
                text("01 June,2000"),
                text(subjects),
                text("Music"),
                text("imeg.jpg"),
                text(address),
                text("Rajasthan Jaipur"));
    }
}
