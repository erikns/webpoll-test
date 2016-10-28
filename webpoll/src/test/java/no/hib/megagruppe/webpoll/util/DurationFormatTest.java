package no.hib.megagruppe.webpoll.util;

import no.hib.megagruppe.webpoll.data.InMemorySurveyRepository;
import no.hib.megagruppe.webpoll.entities.OptionEntity;
import no.hib.megagruppe.webpoll.entities.QuestionEntity;
import no.hib.megagruppe.webpoll.entities.SurveyEntity;
import no.hib.megagruppe.webpoll.entities.UserEntity;
import no.hib.megagruppe.webpoll.fakes.TestSurveyRepository;
import no.hib.megagruppe.webpoll.models.SurveyAnsweringModel;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DurationFormatTest {

    SurveyAnsweringModel sam; // sam = SurveyAnsweringModel

    @Before
    public void setup() {
        InMemorySurveyRepository imsr = new InMemorySurveyRepository();
        SurveyEntity se = imsr.findByCode("testabc");
        sam = new SurveyAnsweringModel(se.getQuestions(),se.getName(),se.getDate(),se.getDeadline(),se.getOwner().toString());
    }

    @Test
    public void TimeRemainingReturnsFormattedString(){
        System.out.println(sam.getTimeRemaining());
        assertEquals(sam.getTimeRemaining(), "0d, 0t, 00m, 39s");
    }
}
