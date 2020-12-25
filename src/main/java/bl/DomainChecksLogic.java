package bl;

import domain.Child;
import domain.Gender;
import domain.Group;


import java.util.List;

public class DomainChecksLogic {
    private final int ACCEPTABLE_AGE_FLOOR = 3;
    private final int ACCEPTABLE_AGE_CEILING = 7;
    private final int ACCEPTABLE_FIRSTNAME_MAX_LENGTH = 20;
    private final int ACCEPTABLE_LASTNAME_MAX_LENGTH = 50;
    private final int ACCEPTABLE_PATRONYMIC_MAX_LENGTH = 50;


    public boolean checkGroupName(String groupName) {
        return groupName != null && !groupName.isEmpty();
    }


    public boolean checkGroupNumber(int renumber) {
        return renumber > 0;
    }

    public boolean checkChildFirstName(String firstName) {
        return (firstName != null
                && !firstName.isEmpty()
                && firstName.length() <= ACCEPTABLE_FIRSTNAME_MAX_LENGTH);
    }

    public boolean checkChildLastName(String secondName) {
        return (secondName != null
                && !secondName.isEmpty()
                && secondName.length() <= ACCEPTABLE_LASTNAME_MAX_LENGTH);
    }

    public boolean checkChildPatronymic(String patronymic) {
        return (patronymic != null
                && !patronymic.isEmpty()
                && patronymic.length() <= ACCEPTABLE_PATRONYMIC_MAX_LENGTH);
    }

    public boolean checkChildAge(int age) {
        return (age >= ACCEPTABLE_AGE_FLOOR && age <= ACCEPTABLE_AGE_CEILING);
    }

    public boolean checkChildGender(String gender) {
        if (gender != null) {
            try {
                Gender.valueOf(gender);
            } catch (IllegalArgumentException e) {
                System.out.println("UNACCEPTABLE arguments");
            }
            return true;
        } else
            return false;
    }


}
