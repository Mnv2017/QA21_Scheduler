package com.telran.scheduler.tests;

import com.telran.scheduler.model.Event;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EventCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!app.getEvent().isContainerReportPresent()) {
            app.getUser().defaultLogin();
        }
    }

    @Test
    public void createEventPositiveTest() throws InterruptedException {
        int quantityBeforeAdd;
        int quantityAfterAdd;

        quantityBeforeAdd = app.getEvent().getTotalEvents();

        // tap on +
        app.getEvent().tapOnPlusButton();
        // tap on Pencil
        app.getEvent().tapOnPencil();
        Thread.sleep(1000);
        app.getEvent().moveElementRightToLeft();
        // fill Event Form
        app.getEvent().fillEventCreationForm(new Event().setEventTitle("Vorstellungsgespraech").setEventType("Arbeit").setBreaks(2).setWage("25"));
        // confirm Event creation
        app.getEvent().tapOnAddEventButton();
        // isEventPresent

        quantityAfterAdd = app.getEvent().getTotalEvents();
        Assert.assertEquals(quantityAfterAdd,quantityBeforeAdd+1);

    }

    @Test
    public void eventCreationChangeDateTestOfRegisteredUserTest() throws InterruptedException {

        app.getEvent().tapOnPlusButton();
        app.getEvent().tapOnPencil();
        app.getEvent().selectDate("future", "NOVEMBER", "30");

        app.getEvent().fillEventCreationForm(new Event().setEventTitle("Event")
                .setEventType("1").setBreaks(1).setWage("50"));
        app.getEvent().tapOnAddEventButton();
    }
}
