package case_study.services;

import java.text.ParseException;

public interface IEmployeeServices extends IServices {
    @Override
    void displayList() ;
    @Override
    void addNew()  ;
    void edit();
}
