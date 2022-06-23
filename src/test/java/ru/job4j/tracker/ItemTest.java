package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void whenSortIncreaseByName() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Upload to cloud");
        Item item2 = new Item("Write test");
        Item item3 = new Item("Fix error");
        Item item4 = new Item("Fix bug");
        items = Arrays.asList(item1, item2, item3, item4);
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(item4, item3, item1, item2);
        assertThat(items, is(expected));
    }

    @Test
    public void whenSortDecreaseByName() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Upload to cloud");
        Item item2 = new Item("Write test");
        Item item3 = new Item("Fix error");
        Item item4 = new Item("Fix bug");
        items = Arrays.asList(item1, item2, item3, item4);
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(item2, item1, item3, item4);
        assertThat(items, is(expected));
    }
}