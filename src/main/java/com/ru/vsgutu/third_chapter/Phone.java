package com.ru.vsgutu.third_chapter;

import java.time.Duration;

public class Phone {
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private long creditCardNumber;
    private long debit;
    private long credit;
    private Duration townCallTime = 0;
    private Duration longDistanceCallTime = 0;

    private Phone() {}

    public Phone(
            long id,
            String name,
            String surname,
            String patronymic,
            long creditCardNumber,
            long debit,
            long credit,
            Duration townCallTime,
            Duration longDistanceCallTime) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.townCallTime = townCallTime;
        this.longDistanceCallTime = longDistanceCallTime;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getFullName() {
        return surname + " " + name + " " + patronymic;
    }

    public long getCreditCardNumber() {
        return this.creditCardNumber;
    }

    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public long getDebit() {
        return this.debit;
    }

    public void setDebit(long debit) {
        this.debit = debit;
    }

    public long getCredit() {
        return this.credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public Duration getTownCallTime() {
        return this.townCallTime;
    }

    public void setTownCallTime(Duration townCallTime) {
        this.townCallTime = townCallTime;
    }

    public Duration getLongDistanceCallTime() {
        return this.longDistanceCallTime;
    }

    public void setLongDistanceCallTime(Duration longDistanceCallTime) {
        this.longDistanceCallTime = longDistanceCallTime;
    }

    @Override
    public String toString() {
        return "{"
                + " id='"
                + getId()
                + "'"
                + ", name='"
                + getName()
                + "'"
                + ", surname='"
                + getSurname()
                + "'"
                + ", patronymic='"
                + getPatronymic()
                + "'"
                + ", creditCardNumber='"
                + getCreditCardNumber()
                + "'"
                + ", debit='"
                + getDebit()
                + "'"
                + ", credit='"
                + getCredit()
                + "'"
                + ", townCallTime='"
                + getTownCallTime()
                + "'"
                + ", longDistanceCallTime='"
                + getLongDistanceCallTime()
                + "'"
                + "}";
    }
}
