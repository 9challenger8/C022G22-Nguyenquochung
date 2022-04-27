package case_study.services;

public interface IFacilityServices extends IServices {
    @Override
    default void displayList() {

    }

    @Override
    default void addNew() {

    }
    void displayListMaintenance();
}
