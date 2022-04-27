package case_study.services;

public interface ICustomerServices extends IServices {
    @Override
    default void displayList() {

    }

    @Override
    default void addNew() {

    }
    void edit();
}
