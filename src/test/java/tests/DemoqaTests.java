package tests;

import org.junit.jupiter.api.Test;

public class DemoqaTests extends TestBase {

    @Test
    void successfulTests() {
        String name = "Ivan";
        String surname = "Ivanov";
        String email = "Ivanov1258@gmail.com";
        String gender = "Male";
        String mobile = "6666666666";
        String subjects = "Maths";
        String hobbies = "Music";
        String address = "Moscow, Petrovka, 38";
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
                        .checkResult("Gender", gender)
                        .checkResult("Mobile", mobile)
                        .checkResult("Date of Birth", "01 June,2000")
                        .checkResult("Subjects", subjects)
                        .checkResult("Hobbies", hobbies)
                        .checkResult("Picture", "imeg.jpg")
                        .checkResult("Address", address)
                        .checkResult("State and City", state + " " + city);
    }
}
