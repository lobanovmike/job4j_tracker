package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{
                "one", "1"
        });
        ValidateInput validateInput = new ValidateInput(out, in);
        int selected = validateInput.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{
                "0"
        });
        ValidateInput validateInput = new ValidateInput(out, in);
        int select = validateInput.askInt("Enter menu: ");
        assertThat(select, is(0));
    }

    @Test
    public void whenMultiplyValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{
                "0", "1"
        });
        ValidateInput validateInput = new ValidateInput(out, in);
        int select = validateInput.askInt("Enter menu");
        select = validateInput.askInt("Enter menu");
        assertThat(select, is(1));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{
                "-1"
        });
        ValidateInput validateInput = new ValidateInput(out, in);
        int select = validateInput.askInt("Enter menu");
        assertThat(select, is(-1));
    }
}