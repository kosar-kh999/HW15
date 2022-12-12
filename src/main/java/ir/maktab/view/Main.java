package ir.maktab.view;

import ir.maktab.entitty.*;
import ir.maktab.entitty.enums.*;
import ir.maktab.exception.CollegianException;
import ir.maktab.exception.DuplicateNationalCodeException;
import ir.maktab.exception.LoanException;
import ir.maktab.service.serviceImpl.*;
import ir.maktab.validation.AccountValidation;
import ir.maktab.validation.CardValidation;

import javax.xml.bind.ValidationException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static CollegianServiceImpl collegianService = new CollegianServiceImpl();

    private static Collegian collegianOne;

    private static EducationalLoanServiceImpl educationalLoanService = new EducationalLoanServiceImpl();

    private static EducationLoan educationLoan;

    private static StudentTuitionLoanServiceImpl studentTuitionLoanService = new StudentTuitionLoanServiceImpl();

    private static StudentTuitionLoan studentTuitionLoan;

    private static HousingLoanServiceImpl housingLoanService = new HousingLoanServiceImpl();
    private static HousingLoan housingLoan;

    private static RefundServiceImpl refundService = new RefundServiceImpl();
    private static Refund refund;
    private static Loan loan;
    private static CreditCard creditCard;
    private static CreditCardServiceImpl creditCardService = new CreditCardServiceImpl();

    public static void main(String[] args) {
        System.out.println("Hi,please enter your choice : ");
        System.out.println(" 1 -> signUp\n 2 -> signIn\n 3 -> update\n 4 -> signOut\n 5 -> exist");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                if (signup())
                    secondMenu();
                else {
                    System.err.println("Unable to Sign Up ");
                }
                break;
            case 2:
                signIn();
                break;
            case 3:
                editPassword();
            case 4:
                signOut();
            default:
                System.exit(0);
                break;
        }
    }

    public static void secondMenu() {
        System.out.println("which loan do you want?");
        System.out.println("  Press 1 --> Educational loan");
        System.out.println("  Press 2 --> student tuition loan");
        System.out.println("  Press 3 --> housing loan");
        System.out.println("  Press 4 --> refund of loan");
        int secondChoice = Integer.parseInt(scanner.nextLine());
        switch (secondChoice) {
            case 1 -> {
                if (addNewEducationalLoan()) {
                    getCardInfo();
                } else {
                    secondMenu();
                }
            }
            case 2 -> {
                if (addNewStudentTuitionLoan()) {
                    getCardInfo();
                } else {
                    secondMenu();
                }
            }
            case 3 -> {
                if (addNewHousingLoan()) {
                    getCardInfo();
                } else {
                    secondMenu();
                }
            }
            case 4 -> getRefund();
            default -> System.exit(0);
        }
    }

    public static boolean signup() {
        boolean result = false;
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

        System.out.println("""
                 enter your typeOfUniversity
                 1:DAILY
                 2:EVENING
                 3:NONPROFIT
                 4:COMPOUND
                 5:EXCESS_CAPACITY
                 6:PAYAM_NOOR
                 7:APPLIED_SCIENCES
                 8:AZAD
                """);
        UniversityType universityType = uniType();


        System.out.println("entering year");
        LocalDate enteringDate = getDate();
        Date enterDate = Date.from(enteringDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println("choose your grade");

        System.out.println("""
                 enter your grade
                 1:ASSOCIATE
                 2:CONTINUOUS_BACHELORS
                 3:DISCONTINUOUS_BACHELORS
                 4:CONTINUOUS_MASTER
                 5:DISCONTINUOUS_MASTER
                 6: HD
                 7:CONTINUOUS_PHD
                 8:DISCONTINUOUS_SPECIALIZED_DOCTORATE
                """);
        Grade grade = gradeOfStudent();

        System.out.println("enter you marital status");
        System.out.println("1:married\n 2:single");
        MaritalStatus maritalStatus = getMaritalStatusOfStudent();

        String username = nationalCode;
        String password = String.valueOf(generatePassword(8));

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
        collegianOne = new Collegian(firstName, lastName, fatherName, motherName, birthCertificateNumber,
                nationalCode, birthday, username, password, universityInfo, maritalStatus, isDormitory);
        collegianService.signUp(collegianOne);
        if (collegianOne != null) {
            result = true;
        } else
            System.err.println("you didn't sign up !");
        return result;
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

    public static MaritalStatus getMaritalStatusOfStudent() {
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> MaritalStatus.MARRIED;
            case 2 -> MaritalStatus.SINGLE;
            default -> null;
        };
    }

    private static char[] generatePassword(int length) {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        char[] password = new char[length];

        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        password[3] = numbers.charAt(random.nextInt(numbers.length()));

        for (int i = 4; i < length; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }
        return password;
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
            System.err.println("invalid password");
        }
        collegianService.signIn(username, password);
    }

    public static void editPassword() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        collegianService.signIn(username, password);
        System.out.println("do you want to edit password? (Y/N)");
        String yesNo = scanner.nextLine();
        if (yesNo.equalsIgnoreCase("y")) {
            Collegian collegian = new Collegian(username, password);
            collegianService.editCollegian(collegian);
        } else System.err.println("your password isn't change");
    }

    public static void signOut() {
        collegianService.signOut(collegianOne);
    }

    public static boolean addNewEducationalLoan() {
        boolean result = false;
        System.out.println("choose your grade");

        System.out.println("""
                 enter your grade
                 1:ASSOCIATE
                 2:CONTINUOUS_BACHELORS
                 3:DISCONTINUOUS_BACHELORS
                 4:CONTINUOUS_MASTER
                 5:DISCONTINUOUS_MASTER
                 6: HD
                 7:CONTINUOUS_PHD
                 8:DISCONTINUOUS_SPECIALIZED_DOCTORATE
                """);
        Grade grade = gradeOfStudent();

        System.out.println("Enter your date of request the loan : ");
        LocalDate date = getDate();
        Date requestDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println("1:payment period is semester");
        PaymentPeriod semester = getSemester();

        educationLoan = new EducationLoan(semester, requestDate, grade);
        educationalLoanService.saveNewEducationalLoan(educationLoan);
        if (collegianOne != null) {
            result = true;
        }
        return result;
    }

    public static PaymentPeriod getSemester() {
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> PaymentPeriod.SEMESTER;
            default -> null;
        };
    }

    public static boolean addNewStudentTuitionLoan() {
        boolean result = false;

        System.out.println("choose your grade");
        System.out.println("""
                 enter your grade
                 1:ASSOCIATE
                 2:CONTINUOUS_BACHELORS
                 3:DISCONTINUOUS_BACHELORS
                 4:CONTINUOUS_MASTER
                 5:DISCONTINUOUS_MASTER
                 6: HD
                 7:CONTINUOUS_PHD
                 8:DISCONTINUOUS_SPECIALIZED_DOCTORATE
                """);
        Grade grade = gradeOfStudent();

        System.out.println("Enter your date of request the loan: ");
        LocalDate date = getDate();
        Date requestDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println("1:payment period is semester");
        PaymentPeriod semester = getSemester();

        System.out.println("choose your university type");

        System.out.println("""
                 enter your typeOfUniversity
                 1:DAILY
                 2:EVENING
                 3:NONPROFIT
                 4:COMPOUND
                 5:EXCESS_CAPACITY
                 6:PAYAM_NOOR
                 7:APPLIED_SCIENCES
                 8:AZAD
                """);
        UniversityType universityType = uniType();

        studentTuitionLoan = new StudentTuitionLoan(semester, requestDate, universityType, grade);
        try {
            studentTuitionLoanService.saveNewStudentTuitionLoan(studentTuitionLoan);
        } catch (LoanException e) {
            System.err.println("You don't have enough requirements of student tuition loan !");
        }
        if (studentTuitionLoan != null) {
            result = true;
        }
        return result;
    }


    public static PaymentPeriod getGradeOfPayment() {
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> PaymentPeriod.SEMESTER;
            default -> null;
        };
    }

    public static boolean addNewHousingLoan() {
        boolean result = false;

        System.out.println("enter you marital status");
        System.out.println("1:married\n 2:single");
        MaritalStatus maritalStatus = getMaritalStatusOfStudent();

        System.out.println("enter your Spouse national code : ");

        System.out.println("please enter your national code:");
        String nationalCode = scanner.nextLine();
        AccountValidation.nationalCodeValid(nationalCode);
        try {
            collegianService.checkNationalCode(nationalCode);
        } catch (DuplicateNationalCodeException e) {
            System.out.println("you have been sign up before . ");
        }

        if ((!collegianOne.isDormitoryResident() && maritalStatus.equals(MaritalStatus.MARRIED))) {
            System.out.println("enter your Housing Rental Contract Number : ");
            long housingRentalContractNumber = Long.parseLong(scanner.nextLine());

            System.out.println("enter your address : ");
            String address = scanner.nextLine();

            System.out.println("choose your city type : ");
            System.out.println("""
                     enter your city type
                     1:TEHRAN
                     2:BIG_CITY
                     3:OTHER_CITY
                    """);
            CityType cityType = getCityType();

            System.out.println("1:payment period is grade");
            PaymentPeriod gradeOfPayment = getGradeOfPayment();

            System.out.println("Enter your date of request the loan : ");
            LocalDate date = getDate();
            Date requestDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

            HouseInfo houseInfo = new HouseInfo(housingRentalContractNumber, address);
            housingLoan = new HousingLoan(gradeOfPayment, requestDate, cityType, houseInfo);

            housingLoanService.saveNewHousingLoan(housingLoan);
        }
        if (housingLoan != null) {
            result = true;
        }
        return result;
    }

    public static CityType getCityType() {
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> CityType.TEHRAN;
            case 2 -> CityType.BIG_CITY;
            case 3 -> CityType.OTHER_CITY;
            default -> null;
        };
    }

    public static double getRefund() {
        double amount = loan.getAmount();
        int years = 5;
        double interestRate = 0.04;
        return refundService.repaymentAmount(amount, years, interestRate);
    }

    public static void getCardInfo() {
        System.out.println("enter card number : ");
        String cardNumber = scanner.nextLine();
        try {
            CardValidation.validCardNumber(cardNumber);
        } catch (ValidationException e) {
            System.err.println("this card number is not valid . ");
        }

        System.out.println("enter expire date : ");
        LocalDate date = getDate();
        Date expireDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println("enter your cvv2");
        int cvv2 = Integer.parseInt(scanner.nextLine());

        System.out.println("enter opening date");
        LocalDate dateOne = getDate();
        Date openingDate = Date.from(dateOne.atStartOfDay(ZoneId.systemDefault()).toInstant());

        System.out.println("choose your bank type : ");
        System.out.println("""
                 enter your bank type
                 1:MASKAN
                 2:MELI
                 3:REFAH
                 4:TEJARAT
                 5:OTHER_BANK
                """);
        BankType bankOfType = getBankOfType();

        System.out.println("enter your amount . ");
        double amount = Double.parseDouble(scanner.nextLine());

        creditCard = new CreditCard(cardNumber, expireDate, cvv2, openingDate, bankOfType, amount);
        creditCardService.saveNewCreditCard(creditCard);
    }

    public static BankType getBankOfType() {
        int choice = Integer.parseInt(scanner.nextLine());
        return switch (choice) {
            case 1 -> BankType.MASKAN;
            case 2 -> BankType.MELI;
            case 3 -> BankType.REFAH;
            case 4 -> BankType.TEJARAT;
            case 5 -> BankType.OTHER_BANK;
            default -> null;
        };
    }
}

