package case_study.services;

import case_study.services.impl.EmployeeManagement;

public interface ICustomerServices extends IServices {
    @Override
    default void displayList() {

    }

    @Override
    default void addNew() {


    }
    void edit();
}
