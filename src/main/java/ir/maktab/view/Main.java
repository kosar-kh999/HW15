package ir.maktab.view;

import ir.maktab.entitty.Account;
import ir.maktab.exception.DuplicateNationalCodeException;
import ir.maktab.service.serviceImpl.AccountServiceImpl;
import ir.maktab.validation.Validation;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Main {
    /*private static Scanner scanner = new Scanner(System.in);
    private static AccountServiceImpl accountService = new AccountServiceImpl();

    public static void main(String[] args) {
        System.out.println("Hi,please enter your choice : ");
        System.out.println("1 -> signUp\n 2 -> signIn\n 3 -> edit your account\n 4 -> signOut");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                signup();
                break;
            case 2:
                signIn();
                break;
            case 3:
                //
            case 4:

        }

    }

    public static void signup() {
        System.out.println("please enter your first name : ");
        String firstName = scanner.nextLine();

        System.out.println("please enter your last name : ");
        String lastName = scanner.nextLine();

        System.out.println("please enter your father name : ");
        String fatherName = scanner.nextLine();

        System.out.println("please enter your mother name : ");
        String motherName = scanner.nextLine();

        System.out.println("please enter your birth certificate number:");
        String birthCertificateNumber = scanner.nextLine();
        Validation.nationalCodeValid(birthCertificateNumber);

        System.out.println("please enter your national code:");
        String nationalCode = scanner.nextLine();
        Validation.nationalCodeValid(nationalCode);
        try {
            accountService.checkNationalCode(nationalCode);
        } catch (DuplicateNationalCodeException e) {
            System.out.println("you have been sign up before . ");
        }

        System.out.println("birthDay:enter year");
        int year = scanner.nextInt();
        System.out.println("enter month:");
        int month = scanner.nextInt();
        System.out.println("enter day:");
        int day = scanner.nextInt();
        LocalDate localDate = LocalDate.of(year, month, day);


        System.out.println("enter your gender:\n1:male\n2:female");
        int number = scanner.nextInt();
        Gender value = Gender.getValue(number);

        System.out.println("username:");
        String user = scanner.nextLine();


        System.out.println("password:");
        String pass = scanner.nextLine();
        StudentValidation.passwordIsValid(pass);
        //todo

        System.out.println("are you married?yes or no?");
        boolean answer = scanner.nextBoolean();
        isMarried(answer);


        System.out.println("Student number:");
        String studentNumber = scanner.nextLine();

        System.out.println("university Name:");
        String unName = scanner.nextLine();

        System.out.println("enter your typeOfUniversity\n 1:  AZAD_UNIVERSITY\n" +
                "2: APPLIED_SCIENCE_UNIVERSITY\n3: PAYAMNOOR_UNIVERSITY\n" +
                "4:  EXCESS_UNIVERSITY\n5: PARDIS_UNIVERSITY\n6: NONPROFIT_UNIVERSITY" +
                "\n7: DOLATI_ROZANEH\n8: DOLATI_SHABANEH\n");
        int num = Integer.parseInt(scanner.nextLine());
        TypeUniversity typeUniversity = TypeUniversity.getValue(num);


        System.out.println("entering year:enter year");
        int year1 = scanner.nextInt();
        System.out.println("enter month:");
        int month1 = scanner.nextInt();
        System.out.println("enter day:");
        int day1 = scanner.nextInt();
        LocalDate localDate1 = LocalDate.of(year1, month1, day1);


        System.out.println("enter number of type grade:\n1: ASSOCIATE\n2:" +
                "2: BA\n3: BA_DEGREE\n4: PROFESSIONAL_DOCTOR\n5:CONTINUOUS_SENIOR" +
                "\n6: DIS_SENIOR\n7: CONTINUOUS_PH_D\n8: DISCONTINUOUS_SPECIALIZED\n");
        int number2 = Integer.parseInt(scanner.nextLine());
        Grade grade = Grade.getValue(number2);


        UniversityInfo universityInfo = new UniversityInfo(studentNumber, unName,
                typeUniversity, localDate1, grade);
        Student student1 = new Student(name, family, father, mother, certificate, nationalCode, localDate
                , value, user, pass, answer, universityInfo);
        studentImpl.saveInfoStudent(student1);


    }

    public static boolean isMarried(boolean answer) {
        if (answer == true) {
            return true;
        } else if (answer == false) {
            return false;
        } else {
            throw new RuntimeException("enter correct about your dormitory");
        }
    }

    public static void signIn() {
        System.out.println("enter your  username");
        String user = scanner.nextLine();
        System.out.println("enter your password");
        String pass = scanner.nextLine();
        StudentValidation.passwordIsValid(pass);
        studentImpl.signIn(user, pass);
    }

    public static void removeAccount(Account account) {
        accountService.signOut(account);
    }*/
}

