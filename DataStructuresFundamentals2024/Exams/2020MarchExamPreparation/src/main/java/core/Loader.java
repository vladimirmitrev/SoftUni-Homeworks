package core;

import interfaces.Buffer;
import interfaces.Entity;
import model.BaseEntity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Loader implements Buffer {
    private List<Entity> data;

    public Loader() {
        this.data = new ArrayList<>();
    }

    @Override
    public void add(Entity entity) {
        this.data.add(entity);
    }

    @Override
    public Entity extract(int id) {
        Entity result = null;

        for (Entity current : data) {
            if (current.getId() == id) {
                result = current;
                this.data.remove(current);
                break;
            }
        }

        return result;
    }

    @Override
    public Entity find(Entity entity) {
        int index = this.data.indexOf(entity);

        return index == -1 ? null : this.data.get(index);
    }

    @Override
    public boolean contains(Entity entity) {
        return this.data.contains(entity);
    }

    @Override
    public int entitiesCount() {
        return this.data.size();
    }

    @Override
    public void replace(Entity oldEntity, Entity newEntity) {
        int index = this.data.indexOf(oldEntity);

        ensureIndex(index);

        this.data.set(index, newEntity);
    }

    @Override
    public void swap(Entity first, Entity second) {
        int firstIndex = this.data.indexOf(first);
        ensureIndex(firstIndex);

        int secondIndex = this.data.indexOf(second);
        ensureIndex(secondIndex);

        this.data.set(firstIndex, second);
        this.data.set(secondIndex, first);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public Entity[] toArray() {
        Entity[] result = new Entity[this.entitiesCount()];
        this.data.toArray(result);

        return result;
    }

    @Override
    public List<Entity> retainAllFromTo(BaseEntity.Status lowerBound, BaseEntity.Status upperBound) {
        return this.data
                .stream()
                .filter(e -> e.getStatus().ordinal() >= lowerBound.ordinal()
                        && e.getStatus().ordinal() <= upperBound.ordinal())
                .collect(Collectors.toList());
    }

    @Override
    public List<Entity> getAll() {
        return new ArrayList<>(this.data);
    }

    @Override
    public void updateAll(BaseEntity.Status oldStatus, BaseEntity.Status newStatus) {
        for (int i = 0; i < this.entitiesCount(); i++) {
            Entity current = this.data.get(i);
            if (current.getStatus().equals(oldStatus)) {
                current.setStatus(newStatus);
            }
        }
    }

    @Override
    public void removeSold() {
         this.data = this.data
                 .stream()
                 .filter(e -> !e.getStatus().equals(BaseEntity.Status.SOLD))
                 .collect(Collectors.toList());
    }

    @Override
    public Iterator<Entity> iterator() {
        return this.data.iterator();
    }

    private static void ensureIndex(int index) {
        if (index == -1) {
            throw new IllegalStateException("Entity not found");
        }
    }
}
