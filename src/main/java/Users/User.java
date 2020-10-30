package Users;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class User {
    /**
     * Property - Id of the owner of the contract
     */
    private int userId;
    /**
     * Property - First name, last Name, middle name of the user
     */
    private String fio;
    /**
     * Property - users date of birth
     */
    private LocalDate birthDate;
    /**
     * Property - gender of the user
     */
    private Gender gender;
    /**
     * Property - series of the passport of the user
     */
    private String passportSeries;
    /**
     * Property - number of the passport of the user
     */
    private String passportNumber;
    /**
     * Property - current date
     */
    public LocalDate currentDate;
    /**
     * Property - age of the user. Calculates as number of years between users date of birth and current date
     * @see Period#getYears()
     */
    private int userAge = Period.between(birthDate,currentDate).getYears();
    /**
     * @return current value of the userId
     */
    public int getUserId() {
        return userId;
    }
    /**
     * Сhanges the userId value to the passed value
     * @param userId - new value of the userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    /**
     * @return current value of the fio
     */
    public String getFio() {
        return fio;
    }
    /**
     * Сhanges the fio value to the passed value
     * @param fio - new value of the fio
     */
    public void setFio(String fio) {
        this.fio = fio;
    }
    /**
     * @return current value of the birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }
    /**
     * Сhanges the birthDate value to the passed value
     * @param birthDate - new value of the birthDate
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    /**
     * @return current value of the gender
     */
    public Gender getGender() {
        return gender;
    }
    /**
     * Сhanges the gender value to the passed value
     * @param gender - new value of the gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    /**
     * @return current value of the passportSeries
     */
    public String getPassportSeries() {
        return passportSeries;
    }
    /**
     * Сhanges the passportSeries value to the passed value
     * @param passportSeries - new value of the passportSeries
     */
    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }
    /**
     * @return current value of the passportNumber
     */
    public String getPassportNumber() {
        return passportNumber;
    }
    /**
     * Сhanges the passportNumber value to the passed value
     * @param passportNumber - new value of the passportNumber
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
    /**
     * @return current value of the userAge
     */
    public int getAge() {
        return userAge;
    }
    /**
     * Сhanges the userAge value to the passed value
     * @param userAge - new value of the userAge
     */
    public void setAge(int userAge) {
        this.userAge = userAge;
    }


}
