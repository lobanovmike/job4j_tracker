package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает простейшую модель работы банковского сервиса, которая позволяет
 * регистрировать нового пользователя, добавлять ему счет и переводить деньги с одного
 * счета на другой.
 * @author Mikhail Lobanov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей с их счетами осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает нового пользователя и если такой отсутствует в хранилище, то
     * добавляет его.
     * @param user пользователь, который добавляется в хранилище
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает паспорт пользователя и счет. Если пользователь с указанным паспортом есть в хранилище
     * и если у него нет указанного счета, то пользователю добавляется счет.
      * @param passport паспорт, по которому ищется пользователь
     * @param account счет, который добавляется к пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод принимает паспорт пользователя. Если пользователь с указанным паспортом найден
     * то возвращается найденный пользователь. В противном случае возвращается null
     * @param passport паспорт по которому ищется пользователь
     * @return найденный пользователь, либо null
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод принимает паспорт пользователя и реквизиты счета.
     * Если пользователь с указанным паспортом есть в хранилище и у него есть счет с указанными реквизитами,
     * то возвращается счет пользователя, в противном случае возвращается значение null.
     * @param passport паспорт, по которому ищется пользователь
     * @param requisite реквизиты счета, по которому ищется счет
     * @return счет пользователя, если таковой имеется, ли значение null, если счета с указанными реквизитами
     * не существует
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(r -> requisite.equals(r.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод принимает паспорт и реквизиты счета с которого осуществляется перевод,
     * паспорт и реквизиты счета на который осуществляется перевод, и сумму перевода.
     * Возвращает true, если перевод был успешным
     * @param srcPassport паспорт пользователя с чьего счета осуществляется перевод
     * @param srcRequisite реквизиты счета с которого осуществляется перевод
     * @param destPassport паспорт пользователя, на счет которого осуществляется перевод
     * @param destRequisite реквизиты счета на который осуществляется перевод
     * @param amount сумма перевода
     * @return результат перевода, true если перевод был успешен, в противном случае false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
