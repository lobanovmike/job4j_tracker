package ru.job4j.tracker;

public class ExitAction implements UserAction {
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
