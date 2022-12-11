package ir.maktab.view;

import ir.maktab.entitty.Collegian;
import ir.maktab.entitty.UniversityInfo;
import ir.maktab.entitty.enums.Grade;
import ir.maktab.entitty.enums.MaritalStatus;
import ir.maktab.entitty.enums.UniversityType;
import ir.maktab.exception.CollegianException;
import ir.maktab.exception.DuplicateNationalCodeException;
import ir.maktab.service.serviceImpl.CollegianServiceImpl;
import ir.maktab.validation.AccountValidation;

import javax.xml.bind.ValidationException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CollegianServiceImpl collegianService = new CollegianServiceImpl();

    public static void main(String[] args) {
        System.out.println("Hi,please enter your choice : ");
        System.out.println(" 1 -> signUp\n 2 -> signIn\n 3 -> edit your account\n 4 -> signOut");
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
                //
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
        AccountValidation.nationalCodeValid(birthCertificateNumber);

        System.out.println("please enter your national code:");
        String nationalCode = scanner.nextLine();
        AccountValidation.nationalCodeValid(nationalCode);
        try {
            collegianService.checkNationalCode(nationalCode);
        } catch (DuplicateNationalCodeException e) {
            System.out.println("you have been sign up before . ");
        }

        System.out.println("birthDay");
        LocalDate birthDate = getDate();
        Date birthday = Date.from(birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println("Student number:");
        String studentNumber = scanner.nextLine();

        System.out.println("university Name:");
        String universityName = scanner.nextLine();

        System.out.println("choose your university type");

        System.out.println("enter your typeOfUniversity\n 1:DAILY\n 2:EVENING\n 3:NONPROFIT\n 4:COMPOUND\n" +
                "5:EXCESS_CAPACITY\n 6:PAYAM_NOOR\n 7:APPLIED_SCIENCES\n 8:AZAD\n");
        UniversityType universityType = uniType();


        System.out.println("entering year");
        LocalDate enteringDate = getDate();
        Date enterDate = Date.from(enteringDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println("choose your grade");

        System.out.println("enter your grade\n 1:ASSOCIATE\n 2:CONTINUOUS_BACHELORS\n " +
                "3:DISCONTINUOUS_BACHELORS\n 4:CONTINUOUS_MASTER\n 5:DISCONTINUOUS_MASTER\n 6: HD\n 7:CONTINUOUS_PHD\n" +
                "8:DISCONTINUOUS_SPECIALIZED_DOCTORATE\n");
        Grade grade = gradeOfStudent();

        System.out.println("enter you marital status");
        System.out.println("1:single\n 2:married");
        MaritalStatus maritalStatus = getMaritalStatus();

        String username = nationalCode;
        String password = generateRandomPassword(8);

        System.out.println("are you Dormitory ? ");
        System.out.println("true or false ? ");
        boolean isDormitory = Boolean.parseBoolean(scanner.nextLine());
        try {
            isDormitoryResident(isDormitory);
        } catch (CollegianException e) {
            throw new RuntimeException(e);
        }

        UniversityInfo universityInfo = new UniversityInfo(studentNumber, universityName, universityType, enterDate,
                grade);
        Collegian collegian = new Collegian(firstName, lastName, fatherName, motherName, birthCertificateNumber,
                nationalCode, birthday, username, password, universityInfo, maritalStatus, isDormitory);
        collegianService.signUp(collegian);
    }

    public static UniversityType uniType() {
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> UniversityType.DAILY;
            case 2 -> UniversityType.EVENING;
            case 3 -> UniversityType.NONPROFIT;
            case 4 -> UniversityType.COMPOUND;
            case 5 -> UniversityType.EXCESS_CAPACITY;
            case 6 -> UniversityType.PAYAM_NOOR;
            case 7 -> UniversityType.APPLIED_SCIENCES;
            case 8 -> UniversityType.AZAD;
            default -> null;
        };
    }

    public static LocalDate getDate() {
        System.out.println("enter year : ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("enter month:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("enter day:");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate;
    }

    public static Grade gradeOfStudent() {
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> Grade.ASSOCIATE;
            case 2 -> Grade.CONTINUOUS_BACHELORS;
            case 3 -> Grade.DISCONTINUOUS_BACHELORS;
            case 4 -> Grade.CONTINUOUS_MASTER;
            case 5 -> Grade.DISCONTINUOUS_MASTER;
            case 6 -> Grade.PHD;
            case 7 -> Grade.CONTINUOUS_PHD;
            case 8 -> Grade.DISCONTINUOUS_SPECIALIZED_DOCTORATE;
            default -> null;
        };
    }

    public static MaritalStatus getMaritalStatus() {
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> MaritalStatus.MARRIED;
            case 2 -> MaritalStatus.SINGLE;
            default -> null;
        };
    }

    public static String generateRandomPassword(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%&";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();
    }

    public static boolean isDormitoryResident(boolean answer) throws CollegianException {
        if (answer == true) {
            return true;
        } else {
            return false;
        }
    }


    public static void signIn() {
        System.out.println("enter your  username");
        String username = scanner.nextLine();
        System.out.println("enter your password");
        String password = scanner.nextLine();
        try {
            AccountValidation.checkPassword(password);
        } catch (ValidationException e) {
            throw new CollegianException("Invalid password ! ");
        }
        StudentValidation.passwordIsValid(pass);
        studentImpl.signIn(user, pass);
    }

    public static void removeAccount(Account account) {
        accountService.signOut(account);
    }*/
}

