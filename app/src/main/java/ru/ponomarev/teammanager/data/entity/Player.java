package ru.ponomarev.teammanager.data.entity;

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
}
