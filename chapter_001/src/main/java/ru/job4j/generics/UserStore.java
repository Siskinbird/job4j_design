package ru.job4j.generics;


public class UserStore<User extends Base> implements Store<User> {

    private final Store<User> store = new MemStore<>();


    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        if (model.getId().equals(id)){
            delete(id);
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (store.findById(id) == null) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public User findById(String id) {
        return null;
    }
}