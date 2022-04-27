package case_study.services.impl;

import case_study.services.ICustomerServices;

public class CustomerManagement implements ICustomerServices {
    @Override
    public void displayList() {
        ICustomerServices.super.displayList();
    }

    @Override
    public void addNew() {
        ICustomerServices.super.addNew();
    }

    @Override
    public void edit() {

    }
}
