package ru.ponomarev.teammanager.domain.entity;

import com.google.common.base.Objects;

/**
 * @author Пономарев Андрей
 * Базовый класс игрока
 */
public abstract class Player {

    private final String mName;
    private final int mAge;
    private final IRole mRole;
    private long mId;


    Player(String name, int age, IRole role) {
        this.mName = name;
        this.mAge = age;
        this.mRole = role;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public int getAge() {
        return mAge;
    }

    public IRole getRole() {
        return mRole;
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
        return mId == player.mId &&
                mAge == player.mAge &&
                Objects.equal(mName, player.mName) &&
                Objects.equal(mRole, player.mRole);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mId, mName, mAge, mRole);
    }
}
