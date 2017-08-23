package ru.ponomarev.teammanager.data.entity;

import com.google.common.base.Objects;

/**
 * @author Пономарев Андрей
 * Базовый класс игрока
 */
public abstract class Player {

    private long id;
    private final String fullName;
    private final int age;
    private final IRole role;


    Player(String fullName, int age, IRole role) {
        this.fullName = fullName;
        this.age = age;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public IRole getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return id == player.id &&
                age == player.age &&
                Objects.equal(fullName, player.fullName) &&
                Objects.equal(role, player.role);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, fullName, age, role);
    }
}
