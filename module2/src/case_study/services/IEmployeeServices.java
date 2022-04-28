package case_study.services;

import java.text.ParseException;

public interface IEmployeeServices extends IServices {
    @Override
    default void displayList() {

    }

    @Override
    default void addNew() throws ParseException {

    }
    void edit();
}
