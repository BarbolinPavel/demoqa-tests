package tests;

import org.junit.jupiter.api.Test;

public class DemoqaTests extends TestBase {

    @Test
    void successfulTests() {
        String name = "Ivan";
        String surname = "Ivanov";
        String email = "Ivanov1258@gmail.com";
        String mobile = "6666666666";
        String subjects = "Maths";
        String address = "Moscow, Petrovka, 38";

        registrationFormPage.openPage()
                .setFirstName(name)
                .setLastName(surname)
                .setUserEmail(email)
                .setGenter("Male")
                .setUserNumber(mobile)
                .setDateOfBirth("01","June","2000")
                .setSubjects(subjects)
                .setHobbies("Music")
                .setUploadPicture("imeg.jpg")
                .setCurrentAddress(address)
                .setState("Rajasthan")
                .setCity("Jaipur")
                .setSubmit()
                .openTable();

        registrationFormPage.checkResult("Student Name", name + " " + surname)
                        .checkResult("Student Email", email)
                        .checkResult("Gender","Male")
                        .checkResult("Mobile", mobile)
                        .checkResult("Date of Birth", "01 June,2000")
                        .checkResult("Subjects", subjects)
                        .checkResult("Hobbies", "Music")
                        .checkResult("Picture", "imeg.jpg")
                        .checkResult("Address", address)
                        .checkResult("State and City", "Rajasthan Jaipur");
    }
}
