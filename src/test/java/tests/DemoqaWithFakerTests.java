package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class DemoqaWithFakerTests  extends TestBase {

    Faker faker = new Faker();

    @Test
    void successfulTests() {
        String name = faker.name().firstName();
        String surname = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = "Male";
        String mobile = faker.phoneNumber().subscriberNumber(10);
        String subjects = "Maths";
        String hobbies = "Music";
        String address = faker.address().fullAddress();
        String state = "Rajasthan";
        String city = "Jaipur";

        registrationFormPage.openPage()
                .setFirstName(name)
                .setLastName(surname)
                .setUserEmail(email)
                .setGenter(gender)
                .setUserNumber(mobile)
                .setDateOfBirth("01","June","2000")
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setUploadPicture("imeg.jpg")
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .setSubmit()
                .openTable();

        registrationFormPage.checkResult("Student Name", name + " " + surname)
                .checkResult("Student Email", email)
                .checkResult("Gender",gender)
                .checkResult("Mobile", mobile)
                .checkResult("Date of Birth", "01 June,2000")
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "imeg.jpg")
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }
}
