package tests;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import java.nio.channels.Selector;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class DemoqaTests extends TestBase {

    @Test
    void successfulTests() {
        String name = "Ivan";
        String surname = "Ivanov";
        String email = "Ivanov1258@gmail.com";
        String mobile = "6666666666";
        String subjects = "Maths";
        String address = "Moscow, Petrovka, 38";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#close-fixedban').remove()");

        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(Selectors.byText("Male")).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--001:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").sendKeys(subjects);
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(Selectors.byText("Music")).click();
        $("input#uploadPicture").uploadFromClasspath("imeg.jpg");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#stateCity-wrapper").$(Selectors.byText("Rajasthan")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(Selectors.byText("Jaipur")).click();
        $("#submit").pressEnter();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        checkTable("Student Name", name + " " + surname, "Student Email", email, "Gender",
                "Male", "Mobile", mobile, "Date of Birth", "01 June,2000", "Subjects",
                subjects, "Hobbies", "Music", "Picture", "imeg.jpg", "Address", address,
                "State and City", "Rajasthan Jaipur");

    }

    void checkTable(String key1, String value1, String key2, String value2, String key3, String value3, String key4,
                    String value4, String key5, String value5, String key6, String value6, String key7, String value7,
                    String key8, String value8, String key9, String value9, String key10, String value10) {
        $(".table-responsive").$(Selectors.byText(key1)).parent().shouldHave(text(value1));
        $(".table-responsive").$(Selectors.byText(key2)).parent().shouldHave(text(value2));
        $(".table-responsive").$(Selectors.byText(key3)).parent().shouldHave(text(value3));
        $(".table-responsive").$(Selectors.byText(key4)).parent().shouldHave(text(value4));
        $(".table-responsive").$(Selectors.byText(key5)).parent().shouldHave(text(value5));
        $(".table-responsive").$(Selectors.byText(key6)).parent().shouldHave(text(value6));
        $(".table-responsive").$(Selectors.byText(key7)).parent().shouldHave(text(value7));
        $(".table-responsive").$(Selectors.byText(key8)).parent().shouldHave(text(value8));
        $(".table-responsive").$(Selectors.byText(key9)).parent().shouldHave(text(value9));
        $(".table-responsive").$(Selectors.byText(key10)).parent().shouldHave(text(value10));
    }
}
