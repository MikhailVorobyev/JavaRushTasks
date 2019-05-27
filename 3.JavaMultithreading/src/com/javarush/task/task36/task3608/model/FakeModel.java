package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    public ModelData getModelData() {
        return modelData;
    }

    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    public void loadUsers() {
        List<User> users = modelData.getUsers();
        users.add(new User("Pashenciy", 1, 5));
        users.add(new User("Vasyok", 2, 6));
        users.add(new User("Andryunec", 3, 2));
    }
}
