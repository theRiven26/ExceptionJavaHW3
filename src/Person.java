public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String dateOfBirth;
    private long phoneNumber;
    private char gender;



    public  Person(String lastName, String firstName, String middleName,
                  String dateOfBirth, long phoneNumber, char gender){
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        try
        {
            String[] dateArray = dateOfBirth.split(".");
             if(dateArray.length != 3){
                throw new IllegalArgumentException("Введен неверный формат даты");
            }
            this.dateOfBirth = dateOfBirth;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Ошибка при обработке даты рождения ");
        }
        this.phoneNumber = phoneNumber;
        try
        {
            if(gender != 'f' && gender != 'm'){
                throw new IllegalArgumentException("Введен несущечтвующий пол");
            }
            this.gender = gender;
        }catch (IllegalArgumentException e){

        }

    }
    public String getLastName(){
        return this.lastName;
    }
    @Override
    public String toString() {
        return lastName  + " " + firstName + " " + middleName + " " + dateOfBirth + " " + phoneNumber + " " + gender;
    }
}
