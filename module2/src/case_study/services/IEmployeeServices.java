package case_study.services;

public interface IEmployeeServices extends IServices {
    @Override
    default void displayList() {

    }

    @Override
    default void addNew() {

    }
    void edit();
}
