package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ShowAllActionTest {
    @Test
    public void whenFindAllItemsIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Input in = new StubInput(new String[] {
                "0", "1"
        });
        UserAction[] actions = new UserAction[] {
                new ShowAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
            "Menu." + ln
                    + "0. Show all items" + ln
                    + "1. Exit Program" + ln
                    + "=== Show all items ===" + ln
                    + item1 + ln
                    + item2 + ln
                    + "Menu." + ln
                    + "0. Show all items" + ln
                    + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenItemsNotFound() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(new String[] {
                "0", "1"
        });
        UserAction[] actions = new UserAction[] {
                new ShowAllAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "=== Show all items ===" + ln
                        + "Хранилище еще не содержит заявок" + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
        ));
    }
}