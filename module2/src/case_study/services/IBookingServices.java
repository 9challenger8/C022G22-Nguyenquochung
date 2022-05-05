package case_study.services;

public interface IBookingServices extends IServices{
    @Override
    default void displayList() {

    }

    @Override
    void addNew();


    void createdNewContract();
    void displayListContract();
    void editContract();
}
