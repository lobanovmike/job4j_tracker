package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenJobAskByName() {
        Job job1 = new Job("training", 10);
        Job job2 = new Job("walk", 5);
        Comparator<Job> cmpByName = new JobAscByName();
        int rsl = cmpByName.compare(job1, job2);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenJobDeskByName() {
        Job job1 = new Job("training", 10);
        Job job2 = new Job("walk", 5);
        Comparator<Job> cmpByName = new JobDescByName();
        int rsl = cmpByName.compare(job1, job2);
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobAskByPriority() {
        Job job1 = new Job("training", 10);
        Job job2 = new Job("walk", 5);
        Comparator<Job> cmpByPriority = new JobAscByPriority();
        int rsl = cmpByPriority.compare(job1, job2);
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenJobDeskByPriority() {
        Job job1 = new Job("training", 10);
        Job job2 = new Job("walk", 5);
        Comparator<Job> cmpByPriority = new JobAscByName();
        int rsl = cmpByPriority.compare(job1, job2);
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorByPriorityAndName() {
        Comparator<Job> cmpPriorityName = new JobDescByPriority().thenComparing(new JobDescByName());
        int rsl = cmpPriorityName.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 0)
        );
        assertThat(rsl, lessThan(0));
    }
}