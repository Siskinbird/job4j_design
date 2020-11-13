package ru.job4j.generics;


public class RoleStore<Role extends Base> implements Store<Role> {

    private final Store<Role> store = new MemStore<>();

    @Override
    public void add(Role model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
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
    public Role findById(String id) {
        return null;
    }
}
